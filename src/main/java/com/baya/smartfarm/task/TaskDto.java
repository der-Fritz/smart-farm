package com.baya.smartfarm.task;

import com.baya.smartfarm.activity.Activity;
import com.baya.smartfarm.common.BaseDto;
import java.time.LocalDateTime;

public class TaskDto extends BaseDto {
    private String taskName;
    private String description;
    private TaskType taskType;
    private Activity activity;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
}
