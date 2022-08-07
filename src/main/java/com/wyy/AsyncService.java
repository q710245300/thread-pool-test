package com.wyy;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.Future;

@Slf4j
@Service
public class AsyncService {

    @Async("asyncPoolExecutor")
    public void task1() throws Exception {
        log.info("task1开始执行");
        Thread.sleep(3000);
        log.info("task1执行结束");

        int i = 1/0;

        throw new RuntimeException("出现异常");
    }

    @Async("asyncPoolExecutor")
    public Future<String> task2() throws Exception {
        log.info("task2开始执行");
        Thread.sleep(3000);
        log.info("task2执行结束");

        int i = 1/0;

        return new AsyncResult<String>("task2 success");
    }
}