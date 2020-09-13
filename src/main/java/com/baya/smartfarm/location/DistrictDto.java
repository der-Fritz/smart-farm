package com.baya.smartfarm.location;

import com.baya.smartfarm.common.BaseDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class DistrictDto extends BaseDto implements Serializable {
  private String districtName;
  private String direction;
}
