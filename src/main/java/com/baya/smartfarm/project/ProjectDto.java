package com.baya.smartfarm.project;

import com.baya.smartfarm.common.BaseDto;
import com.baya.smartfarm.farmer.Farmer;
import com.baya.smartfarm.sponsor.Sponsor;

public class ProjectDto extends BaseDto {

    private String projectName;
    private  ProjectType projectType;
    private Farmer farmer;
    private Sponsor sponsor;
    private String description;
    private String duration;

}
