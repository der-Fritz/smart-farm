package com.baya.smartfarm.merchant.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.merchant.Merchant;
import com.baya.smartfarm.merchant.MerchantDto;
import com.baya.smartfarm.merchant.service.MerchantService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/supplier")
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

    @Override
    public ApiResponse<MerchantDto> update(MerchantDto merchantDto) {
        log.info("Updating existing supplier details: {}", merchantDto);
        Merchant merchant = merchantService.register(mapper.map(merchantDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(merchant));
    }

    @Override
    @DeleteMapping
    public ApiResponse<MerchantDto> delete(MerchantDto merchantDto) {
        return null;
    }

    @Override
    @GetMapping( value = "/findAll")
    public ApiResponse<PaginationResult<MerchantDto>> findAll(String search, Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public ApiResponse<MerchantDto> find(Long id) {
        return null;
    }
}
