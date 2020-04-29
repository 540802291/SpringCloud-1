package com.lsy.service;

import com.lsy.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component     //记得加Component
public class DeptClientServiceFallBack implements FallbackFactory<DeptClientService> {

    //hystrix熔断降级处理
    @Override
    public DeptClientService create(Throwable throwable) {
        return new DeptClientService() {
            @Override
            public boolean add(Dept dept) {
                return false;
            }

            @Override
            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的信息，Consumer客户端提供的降级信息")
                        .setDb_source("this data no in the mysql");
            }

            @Override
            public List<Dept> list() {
                return null;
            }
        };
    }
}
