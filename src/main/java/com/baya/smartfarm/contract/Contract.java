package com.baya.smartfarm.contract;

import com.baya.smartfarm.activity.Activity;
import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.task.TaskType;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "contracts", indexes = {@Index(name = "indx_contracts", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Contract extends BaseEntity {

    @Column(name = "contract_name", length = 50, unique = false, nullable = false)
    private String contractName;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "contract_type", length = 50, nullable = false)
    private String contractType;

    @Column(name = "date_signed", nullable = false)
    private LocalDate dateSigned;

    @Column(name = "start_date", nullable = true)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    @Column(name = "sponsor_id", nullable = false)
    private Long sponsorId;

    @Column(name = "farmer_national_id", nullable = false)
    private String farmerNationalId;


}
