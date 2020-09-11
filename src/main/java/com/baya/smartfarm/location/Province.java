package com.baya.smartfarm.location;


import com.baya.smartfarm.common.BaseEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@ToString
@Setter
@Access(AccessType.FIELD)
public class Province extends BaseEntity {

  @Column
  private String name;

  @ToString.Exclude
  @OneToMany(mappedBy = "province")
  private List<District> districts;

}
