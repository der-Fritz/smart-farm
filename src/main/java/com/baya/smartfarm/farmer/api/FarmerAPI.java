package com.baya.smartfarm.farmer.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.exception.BusinessException;
import com.baya.smartfarm.farmer.Farmer;
import com.baya.smartfarm.farmer.FarmerDto;
import com.baya.smartfarm.farmer.service.FarmerRepository;
import com.baya.smartfarm.farmer.service.FarmerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/farmer")
@CrossOrigin(origins = "http://localhost:4200")
public class FarmerAPI implements CrudApi<FarmerDto> {

  private final FarmerService farmerService;
  private final TypeMapper mapper;
  private final FarmerRepository farmerRepository;

  @PostMapping(value = "/register")
  public ApiResponse<FarmerDto> register(@Valid @RequestBody FarmerDto farmerDto) {
    log.info("New Registration : {} ", farmerDto);

    Farmer farmer= new Farmer();
    farmer= mapper.map(farmerDto);
    farmer.setDirections(farmerDto.getDistrict().getDirection());
    farmer.setDistrictName(farmerDto.getDistrict().getDistrictName());
    farmerService.register(farmer);
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(farmer));
  }

  @GetMapping(value = "/find/{msisdn}")
  public ApiResponse<FarmerDto> findFarmer(@PathVariable(name = "msisdn") final String msisdn) {
    final Optional<Farmer> farmer = farmerService.findByMsisdn(msisdn);
    return farmer.map(farmer1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(farmer1)))
      .orElseThrow(() -> new BusinessException("Service provider with msisdn " + msisdn + "not found"));
  }

  @Override
  public ApiResponse<FarmerDto> create(FarmerDto farmerDto) {

    log.info("New Registration : {} ", farmerDto);
    final Farmer farmer = farmerService.register(mapper.map(farmerDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(farmer));
  }

  @Override
  public ApiResponse<FarmerDto> update(FarmerDto farmerDto) {

    log.info("Update Existing Farmer : {} ", farmerDto);
    final Farmer farmer = farmerService.update(mapper.map(farmerDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(farmer));
  }

  @Override
  public ApiResponse<FarmerDto> delete(FarmerDto farmerDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<FarmerDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    List<FarmerDto> farmerDtos = farmerService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());

    PaginationResult<FarmerDto> pagedFarmer = PaginationResult.pagination(farmerDtos, farmerService.total(), page, size);
    return new ApiResponse<>(HttpStatus.OK.value(), pagedFarmer);
  }

  @Override
  public ApiResponse<FarmerDto> find(Long id) {

    final Optional<Farmer> farmer = farmerService.findById(id);
    return farmer.map(farmer1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(farmer1)))
      .orElseThrow(() -> new BusinessException("Farmer with Id " + id + "not found"));
  }

}
