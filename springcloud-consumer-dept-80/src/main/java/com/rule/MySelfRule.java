package com.rule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration   //标识是一个配置类
public class MySelfRule {

//    @Bean
//    public IRule myRule(){
//        return new RandomRule();
//        //Ribbon自带7种算法，默认为轮询，现在把他换成随机，你也可以自己写算法
//    }

    @Bean
    public IRule myRule(){
        return new RandomRule_My();
        //用自己写的算法，每个服务被调用5次后轮询而不是一次
    }




}
