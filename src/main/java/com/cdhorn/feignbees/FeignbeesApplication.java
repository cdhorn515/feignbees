package com.cdhorn.feignbees;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class FeignbeesApplication {


    public static void main(String[] args) {
        SpringApplication.run(FeignbeesApplication.class, args);
    }


}

