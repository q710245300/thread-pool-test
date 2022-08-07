package com.wyy.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.*;

@Configuration
@EnableAsync
@Slf4j
public class ThreadPoolConfig implements AsyncConfigurer {

    /**
     * Spring 封装的线程池
     */
    @Bean("asyncPoolExecutor")
    public ThreadPoolTaskExecutor asyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(2);
        executor.setMaxPoolSize(2);
        executor.setKeepAliveSeconds(60);
        executor.setQueueCapacity(2);
        executor.setThreadNamePrefix("edward-thread-");
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        executor.setAllowCoreThreadTimeOut(true);
        executor.initialize();
        return executor;
    }

//    /**
//     * juc 原生线程池
//     */
//    @Bean("threadPoolExecutor")
//    public ThreadPoolExecutor threadPoolExecutor() {
//        BlockingQueue<Runnable> runnables = new LinkedBlockingQueue<>(2);
//        return new ThreadPoolExecutor(
//                2,
//                2,
//                30,
//                TimeUnit.SECONDS,
//                runnables,
//                new ThreadPoolExecutor.AbortPolicy()
//        );
//
//    }

//    /**
//     * 让 @Async 注解识别
//     */
//    @Override
//    public Executor getAsyncExecutor() {
//        // 需要替换的话自己改一下方法名即可
//        return threadPoolExecutor();
//    }

}
