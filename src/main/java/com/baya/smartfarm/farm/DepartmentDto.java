package com.baya.smartfarm.farm;

import com.baya.smartfarm.common.BaseDto;
import lombok.Data;

import java.io.Serializable;

@Data
public class DepartmentDto extends BaseDto implements Serializable {

    private String deptName;
    private String deptType;
    private String description;

}
