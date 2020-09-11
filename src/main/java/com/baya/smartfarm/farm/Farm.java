package com.baya.smartfarm.farm;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.farmer.Farmer;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "farms", indexes = {@Index(name = "indx_farm", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Farm extends BaseEntity {

    @Column(name = "farm_name", nullable = false, length = 45)
    private String name;

    @Column(name = "farm_type", nullable = false, length = 45)
    private String type;

    @Column(name = "farm_size", nullable = false, length = 45)
    private String farmSize;

  @Column(name = "farm_province", nullable = false, length = 45)
  private String province;

  @Column(name = "farm_district", nullable = false, length = 45)
  private String district;

  @Column(name = "farm_location", length = 45)
  private String location;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "farmers_id", nullable = false)
  @JsonIgnore
  private Farmer farmer;
}
