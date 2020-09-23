package com.baya.smartfarm.merchant.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.exception.BusinessException;


import com.baya.smartfarm.merchant.Merchant;
import com.baya.smartfarm.merchant.MerchantDto;
import com.baya.smartfarm.merchant.service.MerchantService;
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
@RequestMapping("/merchant")
public class MerchantApi implements CrudApi<MerchantDto> {

    private final MerchantService merchantService;
    private final TypeMapper mapper;

    @PostMapping(value = "/register")
    public ApiResponse<MerchantDto> register(@Valid @RequestBody MerchantDto merchantDto) {
        log.info("New supplier registration : {} ", merchantDto);
        final Merchant merchant = merchantService.register(mapper.map(merchantDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(merchant));
    }

    @Override
    public ApiResponse<MerchantDto> create(MerchantDto merchantDto) {
        log.info("New supplier registration : {}", merchantDto);
        Merchant merchant = merchantService.register(mapper.map(merchantDto));
        return new  ApiResponse<>(HttpStatus.OK.value(), mapper.map(merchant));
    }
    @GetMapping(value = "/find/{name}")
    public ApiResponse<MerchantDto> findMerchant(@PathVariable(name = "name") final String name) {
        final Optional<Merchant> merchant = merchantService.findByName(name);
        return merchant.map(merchant1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(merchant1)))
                .orElseThrow(() -> new BusinessException("Merchant with name, " + name + ",not found"));
    }

    @Override

    public ApiResponse<MerchantDto> update(MerchantDto merchantDto) {
        log.info("Updating existing supplier details: {}", merchantDto);
        Merchant merchant = merchantService.update(mapper.map(merchantDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(merchant));
    }

    @Override
    @DeleteMapping(value ="/delete")
    public ApiResponse<MerchantDto> delete(MerchantDto merchantDto) {
        return null;
    }

    @Override
    @GetMapping( value = "/findAll")
    public ApiResponse<PaginationResult<MerchantDto>> findAll(String search, Integer page, Integer size, String sortBy) {
        List<MerchantDto> merchantDtos = merchantService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        PaginationResult<MerchantDto> pagedMerchant = PaginationResult.pagination(merchantDtos, merchantService.total(), page, size);
        return new ApiResponse<>(HttpStatus.OK.value(), pagedMerchant);
    }

    @Override
    public ApiResponse<MerchantDto> find(Long id) {
        final Optional<Merchant> merchant = merchantService.findById(id);
        return merchant.map(merchant1 ->new ApiResponse<>(HttpStatus.OK.value(), mapper.map(merchant1)))
                .orElseThrow(() -> new BusinessException("Merchant with Id " + id + "not found"));
    }
}
