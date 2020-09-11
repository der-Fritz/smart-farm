package com.baya.smartfarm.config;//package com.cbsolutions.smartfarmer.config;
//
//
//import com.econetwireless.common.scheduledtask.configuration.ScheduledTaskParameterProvider;
//import com.econetwireless.common.scheduledtask.configuration.SchedulingMetaDataReaderConfiguration;
//import com.econetwireless.common.scheduledtask.configuration.TaskRunnerConfiguration;
//import com.econetwireless.common.scheduledtask.configuration.TaskSchedulerConfiguration;
//import com.econetwireless.common.strategies.service.ApplicationContextServiceLookup;
//import com.econetwireless.common.strategies.service.ServiceLookup;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Import;
//import org.springframework.context.annotation.Profile;
//import org.springframework.core.task.TaskExecutor;
//import org.springframework.scheduling.TaskScheduler;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
//import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//@Configuration
//@Profile("scheduled_task_runner")
//@Import(value = {SchedulingMetaDataReaderConfiguration.class, TaskRunnerConfiguration.class, TaskSchedulerConfiguration.class})
//public class ScheduledTaskConfiguration {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//    @Bean
//    public ScheduledTaskParameterProvider parameterProvider(ServiceLookup serviceLookup) {
//
//        final ScheduledTaskParameterProviderImpl provider = new ScheduledTaskParameterProviderImpl();
//        provider.setEntityManager(entityManager);
//        provider.setServiceLookup(serviceLookup);
//        provider.setTaskScheduler(taskScheduler());
//        return provider;
//    }
//
//    @Bean
//    public TaskScheduler taskScheduler() {
//        return new ThreadPoolTaskScheduler();
//    }
//
//    @Bean
//    public TaskExecutor taskExecutor() {
//        final ThreadPoolTaskExecutor threadPoolTaskExecutor = new ThreadPoolTaskExecutor();
//        threadPoolTaskExecutor.setCorePoolSize(50);
//        threadPoolTaskExecutor.setMaxPoolSize(500);
//        return threadPoolTaskExecutor;
//    }
//
//    @Bean
//    public ServiceLookup serviceLookup(ApplicationContext applicationContext) {
//        return new ApplicationContextServiceLookup(applicationContext);
//    }
//}
