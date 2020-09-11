package com.baya.smartfarm.project;

import com.baya.smartfarm.common.BaseEntity;
import lombok.Data;

import java.io.Serializable;

@Data
public class ManagerDto extends BaseEntity implements Serializable {

    private String firstName;
    private String lastName;
    private String idNumber;
    private String msisdn;
}
