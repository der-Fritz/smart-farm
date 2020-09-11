package com.baya.smartfarm.equipment;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.project.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "equipment", indexes = {@Index(name = "indx_equipment", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Equipment extends BaseEntity {

  @Column(name = "name", nullable = false, length = 45)
  private String equipmentName;

  @Column(name = "equipment_value", nullable = false, length = 45)
  private Double equipmentValue;

  @Column(name = "equipment_type", length = 45)
  private EquipementType equipementType;

  @Column(name = "equipment_status", nullable = true, length = 45)
  private Status status;

  @Column(name = "description", nullable = true, length = 250)
  private String description;

  @ManyToOne(fetch = FetchType.LAZY, optional = true)
  @JoinColumn(name = "project_id", nullable = false)
  @JsonIgnore
  private Project project;
}
