package com.lsy.service;

import com.lsy.pojo.Dept;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

//@FeignClient(value = "SPRINGCLOUD-DEPT")
@FeignClient(value = "SPRINGCLOUD-DEPT",fallbackFactory = DeptClientServiceFallBack.class)
public interface DeptClientService {

    @GetMapping("/dept/add")
    boolean add(@RequestBody Dept dept);

    @GetMapping("/dept/get/{id}")
    Dept get(@PathVariable("id")Long id);

    @GetMapping("/dept/list")
    List<Dept> list();

}
