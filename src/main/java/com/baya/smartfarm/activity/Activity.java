package com.baya.smartfarm.activity;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.location.District;
import com.baya.smartfarm.merchant.MerchantType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "activities", indexes = {@Index(name = "indx_activity", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Activity extends BaseEntity {

    @Column(name = "activity_name", length = 50, unique = false, nullable = false)
    private String activityName;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "activity_type", length = 50, nullable = false)
    private MerchantType activityType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false)
    @JsonIgnore
    private District district;

    @Column(name = "longitude", length = 50, nullable = true)
    private String longitude;

    @Column(name = "latitude", length = 50, nullable = true)
    private String latitude;

    @Column(name = "growth_point", length = 50, nullable = false)
    private String growthPoint;

}
