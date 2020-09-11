package com.baya.smartfarm.farm.api;

import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.common.CrudApi;
import com.baya.smartfarm.common.PaginationResult;
import com.baya.smartfarm.config.TypeMapper;
import com.baya.smartfarm.exception.BusinessException;
import com.baya.smartfarm.farm.Department;
import com.baya.smartfarm.farm.DepartmentDto;
import com.baya.smartfarm.farm.service.DepartmentService;
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
@RequestMapping("/department")
public class DepartmentAPI implements CrudApi<DepartmentDto> {

    private final DepartmentService departmentService;
    private final TypeMapper mapper;

    @PostMapping(value = "/register")
    public ApiResponse<DepartmentDto> register(@Valid @RequestBody DepartmentDto departmentDto) {
        log.info("New Registration : {} ", departmentDto);
        final Department department = departmentService.register(mapper.map(departmentDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(department));
    }

    @Override
    public ApiResponse<DepartmentDto> create(DepartmentDto departmentDto) {
        log.info("New Registration : {} ", departmentDto);
        final Department department = departmentService.register(mapper.map(departmentDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(department));
    }

    @Override
    public ApiResponse<DepartmentDto> update(DepartmentDto departmentDto) {
        log.info("Update Existing Department : {} ", departmentDto);
        final Department department = departmentService.update(mapper.map(departmentDto));
        return new ApiResponse<>(HttpStatus.OK.value(), mapper.map(department));
    }

    @Override
    public ApiResponse<DepartmentDto> delete(DepartmentDto departmentDto) {
        return null;
    }

    @Override
    @GetMapping(value = "/findAll")
    public ApiResponse<PaginationResult<DepartmentDto>> findAll(String search, Integer page, Integer size, String sortBy) {
        List<DepartmentDto> departmentDtos = departmentService.findAll(PageRequest.of(page - 1, size, Sort.by(sortBy)))
                .stream()
                .map(mapper::map)
                .collect(Collectors.toList());

        PaginationResult<DepartmentDto> pagedDepartment = PaginationResult.pagination(departmentDtos, departmentService.total(), page, size);
        return new ApiResponse<>(HttpStatus.OK.value(), pagedDepartment);
    }

    @Override
    public ApiResponse<DepartmentDto> find(Long id) {
        final Optional<Department> department = departmentService.findById(id);
        return department.map(department1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(department1)))
                .orElseThrow(() -> new BusinessException("Department with Id " + id + "not found"));
    }

    @GetMapping(value = "/find/{deptName}")
    public ApiResponse<DepartmentDto> findDepartment(@PathVariable(name = "deptName") final String deptName) {
        final Optional<Department> department = departmentService.findByDeptName(deptName);
        return department.map(department1 -> new ApiResponse<>(HttpStatus.OK.value(), mapper.map(department1)))
                .orElseThrow(() -> new BusinessException("Service provider with department name " + deptName + "not found"));
    }
}
