package com.baya.smartfarm.plan;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.location.DistrictDto;
import com.baya.smartfarm.project.ProjectType;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDate;

@Data
public class ProjectPlanDto extends BaseDto implements Serializable {

    private String planName;
    private String createdBy;
    private int projectBudget;
    private LocalDate startDate;
    private LocalDate endDate;
    private String productionAmount;
    private ProjectType projectType;
    private DistrictDto district;

}
