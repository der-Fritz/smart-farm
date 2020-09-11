package com.baya.smartfarm.location;

import com.baya.smartfarm.common.BaseDto;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProvinceDto extends BaseDto implements Serializable {
  private String name;
  private List<DistrictDto> districts;
}
