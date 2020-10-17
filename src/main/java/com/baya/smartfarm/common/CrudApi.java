package com.baya.smartfarm.common;

import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
public interface CrudApi<T> {

  @PostMapping("/create")
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  ApiResponse<T> create(@RequestBody T t);

  @PutMapping("/update/{id}")
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  ApiResponse<T> update(@RequestBody T t);

  @DeleteMapping("/delete")
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  ApiResponse<T> delete(@RequestBody T t);

  @GetMapping("/all")
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  ApiResponse<PaginationResult<T>> findAll(@RequestParam(defaultValue = "") String search,
                                           @RequestParam(defaultValue = "1") Integer page,
                                           @RequestParam(defaultValue = "10") Integer size,
                                           @RequestParam(defaultValue = "id") String sortBy);

  @GetMapping("/{id}")
  @CrossOrigin(origins = "*", allowedHeaders = "*")
  ApiResponse<T> find(@PathVariable Long id);

}
