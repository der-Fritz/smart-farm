package com.baya.smartfarm.location;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
@CacheConfig(cacheNames = {"locationCache"})
public class LocationServiceImpl implements LocationService {

  private final DistrictRepository districtRepository;
  private final ProvinceRepository provinceRepository;

  @Override
  @Cacheable(cacheNames = {"locationCache"})
  public List<Province> getAll() {
    return provinceRepository.findAll();
  }

  @Override
  @Cacheable(cacheNames = {"locationCache"})
  public Province findById(Long id) {
    return provinceRepository.getOne(id);
  }
}
