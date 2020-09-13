package com.baya.smartfarm.farmer.service;

import com.baya.smartfarm.farmer.Farmer;
import com.baya.smartfarm.location.District;
import com.baya.smartfarm.location.DistrictRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional(propagation = Propagation.REQUIRED)
public class FarmerServiceImpl implements FarmerService {

  private final FarmerRepository farmerRepository;
  private final DistrictRepository districtRepository;

  @Override
  public Farmer register(Farmer farmer) {

    log.info("Register Farmer :{}", farmer);
     Farmer farmer1= farmerRepository.save(farmer);
    District district = new District();
    district.setName(farmer1.getDistrictName());
    district.setDirections(farmer1.getDirections());
    districtRepository.save(district);
    log.info("Register Farmer :{}", district);
   return farmer1;
  }


  @Override
  @Transactional(readOnly = true)
  public Optional<Farmer> findByMsisdn(String msidn) {
    return farmerRepository.findByMsisdn(msidn);
  }

  @Override
  public Optional<Farmer> findById(Long id) {
    return farmerRepository.findById(id);
  }


  @Override
  @Transactional(readOnly = true)
  public List<Farmer> findByLastName(String lastName) {
    return farmerRepository.findByLastName(lastName);
  }

  @Override
  @Transactional(readOnly = true)
  public List<Farmer> findByFirstName(String firstName) {
    return farmerRepository.findByFirstName(firstName);
  }

  @Override
  public List<Farmer> findByFirstNameAndLastName(String firstName, String lastName) {
    return farmerRepository.findByFirstNameAndLastName(firstName, lastName);
  }

  @Override
  public Long total() {
    return farmerRepository.count();
  }

  @Override
  public Farmer update(Farmer farmer) {
    return farmerRepository.save(farmer);
  }

  @Override
  public List<Farmer> findAll(Pageable pageable) {
    return farmerRepository.findAll(pageable).getContent();
  }
}
