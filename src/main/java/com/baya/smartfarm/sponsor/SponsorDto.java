package com.baya.smartfarm.sponsor;

import com.baya.smartfarm.common.BaseDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class SponsorDto extends BaseDto implements Serializable {

    private String firstName;
    private String lastName;
    private String idNumber;
    private String msisdn;
    private SponsorType sponsorType;
    private String organization;

}
