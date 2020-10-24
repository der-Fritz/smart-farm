package com.baya.smartfarm.contract.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.contract.Contract;
import com.baya.smartfarm.contract.ContractDto;
import com.baya.smartfarm.contract.service.ContractService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/contract")
public class ContractAPI implements CrudApi<ContractDto> {

    private final TypeMapper mapper;
    private final ContractService contractService;

    @PostMapping(path = "/register")
    public ApiResponse<ContractDto> register(@Valid @RequestBody ContractDto contractDto){
        log.info("Creating a new contract: {}", contractDto);
        final Contract contract = contractService.register(mapper.map(contractDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(contract));
    }

    @Override
    public ApiResponse<ContractDto> create(ContractDto contractDto) {
        return null;
    }

    @Override
    public ApiResponse<ContractDto> update(ContractDto contractDto) {
        return null;
    }

    @Override
    public ApiResponse<ContractDto> delete(ContractDto contractDto) {
        return null;
    }

    @Override
    public ApiResponse<PaginationResult<ContractDto>> findAll(String search, Integer page, Integer size, String sortBy) {
        List<ContractDto> contractDtos = contractService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        PaginationResult<ContractDto> pagedcontract = PaginationResult.pagination(contractDtos, contractService.total(), page, size);
        return new ApiResponse<>(HttpStatus.OK.value(), pagedcontract);
    }

    @Override
    public ApiResponse find(Long id) {
        return null;
    }
}
