package com.lsy.cfgbeans;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

    @Bean
    @LoadBalanced    //将访问模板开启Ribbon负载均衡(默认为轮询算法)
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

}