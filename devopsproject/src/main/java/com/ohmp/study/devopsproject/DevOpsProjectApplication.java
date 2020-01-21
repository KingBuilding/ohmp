package com.ohmp.study.devopsproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.concurrent.*;

@SpringBootApplication
public class DevOpsProjectApplication {
    private static boolean falg = true;

    public static void main(String[] args) throws IOException {
        SpringApplication.run(DevOpsProjectApplication.class, args);
        //System.gc();
        ExecutorService executorService = Executors.newFixedThreadPool(3);


        CompletableFuture completableFuture = new CompletableFuture();
        CompletableFuture<String> s = completableFuture.thenApplyAsync((a) -> {
            return "";
        }, executorService);
        CompletableFuture.runAsync(() -> {  //在此处打断点
            System.out.println("111");
        }, executorService);

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (falg) {
//                    try {
//                        Thread.currentThread().sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + falg);
//                }
//
//            }
//        }).start();
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while (falg) {
//                    try {
//                        Thread.currentThread().sleep(2000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    if (falg) {
//                        falg = false;
//                    }
//                    System.out.println(Thread.currentThread().getName() + falg);
//                }
//
//            }
//        }).start();
        //System.in.read();

    }

    @RestController
    public class TestController {
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        ThreadLocal local = new ThreadLocal();


        @GetMapping("test")
        public String sayHello(String message) {
            local.set("");
            local.get();
            return "hello ,world" + message;
        }
    }


}
