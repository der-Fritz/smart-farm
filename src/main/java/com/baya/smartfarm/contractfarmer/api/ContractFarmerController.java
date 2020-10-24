package com.baya.smartfarm.contractfarmer.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.contractfarmer.ContractFarmer;
import com.baya.smartfarm.contractfarmer.dto.ContractFarmerDto;
import com.baya.smartfarm.contractfarmer.service.ContractFarmerService;
import com.baya.smartfarm.farmer.FarmerDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/contractfarmer")
public class ContractFarmerController  implements CrudApi<FarmerDto> {

  private final ContractFarmerService contractFarmerService;
  private final TypeMapper mapper;


  @PostMapping(value = "/register")
  public ApiResponse<ContractFarmerDto> register(@Valid @RequestBody ContractFarmerDto contractFarmerDto) {
    log.info("New Registration : {} ", contractFarmerDto);
    final ContractFarmer contractFarmer = contractFarmerService.register(mapper.map(contractFarmerDto));
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(contractFarmer));
  }

  @GetMapping(value = "/find/{famerId}")
  public ApiResponse<ContractFarmerDto> findByFarmerId(@PathVariable(name = "famerId") final String farmerId) {
    final ContractFarmer contractFarmer = contractFarmerService.findByFarmerId(farmerId);
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(contractFarmer));
  }
  @GetMapping(value = "/find/contract/{contractid}")
  public ApiResponse<ContractFarmerDto> findByContractId(@PathVariable(name = "contractid") final String contractId) {
    final ContractFarmer contractFarmer = contractFarmerService.findByFarmerId(contractId);
    return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(contractFarmer));
  }

  @Override
  public ApiResponse<FarmerDto> create(FarmerDto farmerDto) {
    return null;
  }

  @Override
  public ApiResponse<FarmerDto> update(FarmerDto farmerDto) {
    return null;
  }

  @Override
  public ApiResponse<FarmerDto> delete(FarmerDto farmerDto) {
    return null;
  }

  @Override
  public ApiResponse<PaginationResult<FarmerDto>> findAll(String search, Integer page, Integer size, String sortBy) {
    return null;
  }

//  @Override
//  public ApiResponse<PaginationResult<ContractFarmerDto>> findAll(String search, Integer page, Integer size, String sortBy) {
//    List<ContractFarmerDto> farmerDtos = contractFarmerService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
//      .stream()
//      .map(mapper::map)
//      .collect(Collectors.toList());
//
//    PaginationResult<ContractFarmerDto> pagedFarmer = PaginationResult.pagination(farmerDtos, contractFarmerService.total(), page, size);
//    return new ApiResponse<>(HttpStatus.OK.value(), pagedFarmer);
//  }

  @Override
  public ApiResponse<FarmerDto> find(Long id) {
    return null;
  }
}
