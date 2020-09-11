package com.baya.smartfarm.farmer.service;

import com.baya.smartfarm.farmer.Farmer;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface FarmerService {

  Farmer register(Farmer farmer);

  Optional<Farmer> findByMsisdn(String msisdn);

  Optional<Farmer> findById(Long id);

  List<Farmer> findByLastName(String lastName);

  List<Farmer> findByFirstName(String firstName);

  List<Farmer> findByFirstNameAndLastName(String firstName, String lastName);

  Long total();

  Farmer update(Farmer farmer);


  List<Farmer> findAll(Pageable pageable);


}
