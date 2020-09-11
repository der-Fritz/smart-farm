package com.baya.smartfarm.batches;

import com.baya.smartfarm.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "batches", indexes = {@Index(name = "indx_batch", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Batches extends BaseEntity {

    @Column(name = "batch_number", length = 12, unique = true, nullable = false)
    private String batchNo;

    @Column(name = "name", length = 50, unique = false, nullable = false)
    private String name;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "quantity", length = 50, nullable = false)
    private double quantity;

    @Column(name = "price", length = 50, nullable = false)
    private double price;



}
