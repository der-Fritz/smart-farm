package com.baya.smartfarm.project;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.farmer.Farmer;
import com.baya.smartfarm.sponsor.Sponsor;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "projects", indexes = {@Index(name = "indx_project", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Project extends BaseEntity {

    @Column(name="project_name", nullable = false, length = 45)
    private String projectName;

    @Column(name="project_type", nullable = false, length = 45)
    private  ProjectType projectType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "farmer_id", nullable = false)
    @JsonIgnore
    private Farmer farmer;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "sponsor_id", nullable = false)
    @JsonIgnore
    private Sponsor sponsor;

    @Column(name = "description", nullable = false, length = 45)
    private String description;

    @Column(name = "duration", nullable = false, length = 45)
    private String duration;

}
