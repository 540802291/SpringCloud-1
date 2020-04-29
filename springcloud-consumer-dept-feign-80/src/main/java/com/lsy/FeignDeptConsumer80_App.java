package com.lsy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.lsy"})
@ComponentScan("com")
public class FeignDeptConsumer80_App {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer80_App.class,args);
    }

}
