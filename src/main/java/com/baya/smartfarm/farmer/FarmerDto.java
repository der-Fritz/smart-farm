package com.baya.smartfarm.farmer;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.location.District;
import com.baya.smartfarm.location.DistrictDto;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class FarmerDto extends BaseDto implements Serializable {

  private String msisdn;
  private String firstName;
  private String lastName;
  private String idNumber;
  private DistrictDto district;
  private int ward;
  private double longitude;
  private double latitude;
  private String village;


}
