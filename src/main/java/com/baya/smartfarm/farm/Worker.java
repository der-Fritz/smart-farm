package com.baya.smartfarm.farm;

import com.baya.smartfarm.common.BaseEntity;
import com.baya.smartfarm.location.District;
import com.baya.smartfarm.task.Tasks;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "workers", indexes = {@Index(name = "indx_worker", columnList = "msisdn", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Worker extends BaseEntity {

    @Column(name="worker_name", nullable = false, length = 45)
    private String workerName;

    @Column(name="work_surname", nullable = false, length = 45)
    private String workerSurname;

    @Column(name = "id_number", unique = true, nullable = false, length = 10)
    private String idNumber;

    @Column(name="msisdn", unique = true, nullable = false, length = 12)
    private String msisdn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "district_id", nullable = false)
    @JsonIgnore
    private District district;

    @Column(name = "village", nullable = false, length = 45)
    private String village;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "dept_id", nullable = false)
    @JsonIgnore
    private Department department;

    @Column(name = "supervisor", nullable = false, length = 45)
    private String supervisor;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "task_id", nullable = false)
    @JsonIgnore
    private Tasks tasks;
}
