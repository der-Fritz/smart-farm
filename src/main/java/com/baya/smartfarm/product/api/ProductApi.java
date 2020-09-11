package com.baya.smartfarm.product.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.product.Product;
import com.baya.smartfarm.product.ProductDto;
import com.baya.smartfarm.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/product")
public class ProductApi implements CrudApi<ProductDto> {

    private final ProductService productService;
    private final TypeMapper mapper;

    @PostMapping(value = "/register")
    public ApiResponse<ProductDto> register(ProductDto productDto) {
        log.info("New product registration: {}", productDto);
        Product product = productService.register(mapper.map(productDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(product));
    }

    @Override
    public ApiResponse<ProductDto> create(ProductDto productDto) {
        log.info("New product registration: {}", productDto);
        Product product = productService.register(mapper.map(productDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(product));
    }

    @Override
    public ApiResponse<ProductDto> update(ProductDto productDto) {
        log.info("Updating existing product: {}", productDto);
        Product product = productService.register(mapper.map(productDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(product));
    }

    @Override
    public ApiResponse<ProductDto> delete(ProductDto productDto) {
        return null;
    }

    @Override
    public ApiResponse<PaginationResult<ProductDto>> findAll(String search, Integer page, Integer size, String sortBy) {
        return null;
    }

    @Override
    public ApiResponse<ProductDto> find(Long id) {
        return null;
    }
}
