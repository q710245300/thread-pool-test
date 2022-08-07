package com.wyy.controller;

import com.wyy.AsyncService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;

@RestController
@RequiredArgsConstructor
@Slf4j
public class AsyncTestController {

    @Autowired
    AsyncService asyncService;

    @GetMapping(value = "/task1")
    public String task1(){
        try {
            asyncService.task1();
        } catch (Exception exception) {
            log.error("come to Exception",exception);
        }
        return null;
    }
///

    @GetMapping(value = "/task2")
    public String task2() throws Exception {
//        try {
            Future<String> stringFuture = asyncService.task2();

//            String s = stringFuture.get();
//        } catch (Exception exception) {
//            log.error("come to Exception",exception);
//        }
        return null;
    }
}