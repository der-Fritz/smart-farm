package com.baya.smartfarm.task;

import com.baya.smartfarm.activity.Activity;
import com.baya.smartfarm.common.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tasks", indexes = {@Index(name = "indx_task", columnList = "id", unique = true)})
@Getter
@Setter
@ToString
@Access(AccessType.FIELD)
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Tasks extends BaseEntity {

    @Column(name = "task_name", length = 50, unique = false, nullable = false)
    private String taskName;

    @Column(name = "description", length = 50, nullable = false)
    private String description;

    @Column(name = "task_type", length = 50, nullable = false)
    private TaskType taskType;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "activity_id", nullable = false)
    @JsonIgnore
    private Activity activity;

    @Column(name = "start_time", length = 50, nullable = true)
    private LocalDateTime startTime;

    @Column(name = "end_time", length = 50, nullable = true)
    private LocalDateTime endTime;

}
