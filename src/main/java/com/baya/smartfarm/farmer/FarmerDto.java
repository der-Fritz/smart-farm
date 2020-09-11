package com.baya.smartfarm.farmer;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.location.District;
import lombok.Data;

import java.io.Serializable;

@Data
public class FarmerDto extends BaseDto implements Serializable {

  private String msisdn;
  private String firstName;
  private String lastName;
  private String idNumber;
  private District district;
  private String latitude;
  private String longitude;
  private String village;


}
