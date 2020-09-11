package com.baya.smartfarm.location;


import com.baya.smartfarm.common.ApiResponse;
import com.baya.smartfarm.config.TypeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/location")
@Slf4j
@RequiredArgsConstructor
public class LocationApi {

  private final LocationService locationService;
  private final TypeMapper mapper;

  @GetMapping(value = "/provinces")
  public ApiResponse<List<ProvinceDto>> getAll() {
    List<ProvinceDto> provinceDtos = locationService.getAll()
      .stream()
      .map(mapper::map)
      .collect(Collectors.toList());
    return new ApiResponse<>(HttpStatus.OK.value(), provinceDtos);
  }

  @GetMapping(value = "/provinces/{id}")
  public ApiResponse<ProvinceDto> get(@PathVariable Long id) {
    final Province province = locationService.findById(id);
    return new ApiResponse<ProvinceDto>(HttpStatus.OK.value(), mapper.map(province));
  }

}
