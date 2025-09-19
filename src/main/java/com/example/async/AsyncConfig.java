package com.example.async;

import java.util.concurrent.Executor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@EnableAsync
public class AsyncConfig {

    @Bean(name = "threadPoolTaskExecutor")
    public Executor threadPoolTaskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5); // The number of threads to keep in the pool
        executor.setMaxPoolSize(10); // The maximum number of threads
        executor.setQueueCapacity(25); // The queue capacity for waiting tasks
        executor.setThreadNamePrefix("EmailExecutor-"); // A prefix for thread names
        executor.initialize();
        return executor;
    }
}
