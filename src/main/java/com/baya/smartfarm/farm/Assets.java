package com.baya.smartfarm.farm;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.project.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "assets", indexes = {@Index(name = "indx_assert", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)

public class Assets extends BaseEntity {
  @Column(name = "name", nullable = false, length = 45)
  private String assetName;

  @Column(name = "asset_value", nullable = false, length = 45)
  private Double assetValue;

  @Column(name = "assert_type", length = 45)
  private AssetType assetType;

  @Column(name = "asset_status", nullable = true, length = 45)
  private Status status;

  @Column(name = "description", nullable = true, length = 250)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "project_id", nullable = false)
  @JsonIgnore
  private Project project;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "farm_id", nullable = false)
  @JsonIgnore
  private Farm farm;


}
