package com.baya.smartfarm.config;//package com.cbsolutions.smartfarmer.config;
//
//import com.econetwireless.common.scheduledtask.configuration.ScheduledTaskParameterProvider;
//import com.econetwireless.common.strategies.service.ServiceLookup;
//import org.springframework.scheduling.TaskScheduler;
//
//import javax.persistence.EntityManager;
//
//public class ScheduledTaskParameterProviderImpl implements ScheduledTaskParameterProvider {
//
//    private TaskScheduler taskScheduler;
//
//    private EntityManager entityManager;
//
//    private ServiceLookup serviceLookup;
//
//    @Override
//    public String getTaskExecutorUser() {
//        return "system";
//    }
//
//    @Override
//    public TaskScheduler getTaskScheduler() {
//        return taskScheduler;
//    }
//
//    public void setTaskScheduler(TaskScheduler taskScheduler) {
//        this.taskScheduler = taskScheduler;
//    }
//
//    @Override
//    public EntityManager getEntityManager() {
//        return entityManager;
//    }
//
//    public void setEntityManager(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    @Override
//    public ServiceLookup getServiceLookup() {
//        return serviceLookup;
//    }
//
//    public void setServiceLookup(ServiceLookup serviceLookup) {
//        this.serviceLookup = serviceLookup;
//    }
//
//}
