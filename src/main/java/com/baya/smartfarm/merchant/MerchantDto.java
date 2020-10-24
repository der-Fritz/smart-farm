package com.baya.smartfarm.merchant;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.location.DistrictDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class MerchantDto extends BaseDto implements Serializable {

    private String name;
    private String msisdn;
    private MerchantType merchantType;

    private String longitude;
    private String latitude;
    private String growthPoint;

}
