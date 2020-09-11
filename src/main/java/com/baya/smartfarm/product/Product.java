package com.baya.smartfarm.product;

import com.baya.smartfarm.batches.Batches;
import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.project.Project;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "products", indexes = {@Index(name = "indx_product", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Product extends BaseEntity {

    @Column(name = "product_code", length = 12, unique = true, nullable = false)
    private String productCode;

    @Column(name = "name", length = 50, unique = false, nullable = false)
    private String name;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "quantity", length = 50, nullable = false)
    private double quantity;

    @Column(name = "price", length = 50, nullable = false)
    private double price;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "project_id", nullable = false)
    @JsonIgnore
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "batches_id", nullable = false)
    @JsonIgnore
    private Batches batches;


}
