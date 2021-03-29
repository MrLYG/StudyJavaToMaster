package com.example.httpclienttest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class HttpclienttestApplication {

    public static void main(String[] args) throws InterruptedException {
        SpringApplication.run(HttpclienttestApplication.class, args);
        Runnable r = new HttpClientTest();
        ExecutorService service = Executors.newFixedThreadPool(50);
        //执行
        while (true) {
            service.execute(r);
            service.execute(r);
            service.execute(r);
            service.execute(r);
            service.execute(r);
            service.execute(r);
            Thread.sleep(5000);
        }

    }

}
