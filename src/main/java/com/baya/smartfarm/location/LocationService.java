package com.baya.smartfarm.location;

import java.util.List;

public interface LocationService {

  List<Province> getAll();

  Province findById(Long id);
}
