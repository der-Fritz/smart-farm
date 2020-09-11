package com.baya.smartfarm.farm;

import com.baya.smartfarm.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "departments", indexes = {@Index(name = "indx_department", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Department extends BaseEntity {

  @Column(name = "dept_name", nullable = false, unique = true, length = 45)
  private String deptName;

  @Column(name = "dept_type", nullable = false, length = 45)
  private String deptType;

  @Column(name = "description", nullable = false, length = 45)
  private String description;

}
