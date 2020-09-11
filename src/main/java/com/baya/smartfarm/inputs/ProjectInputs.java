package com.baya.smartfarm.inputs;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.merchant.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "project_inputs", indexes = {@Index(name = "indx_project_input", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class ProjectInputs extends BaseEntity {

    @Column(name = "serial_id", length = 12, unique = true, nullable = false)
    private String serialNo;

    @Column(name = "name", length = 50, unique = false, nullable = false)
    private String name;

    @Column(name = "quantity", length = 50, nullable = false)
    private double quantity;

    @Column(name = "price", length = 50, nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "supplier_id", nullable = false)
    @JsonIgnore
    private Supplier supplier;


}
