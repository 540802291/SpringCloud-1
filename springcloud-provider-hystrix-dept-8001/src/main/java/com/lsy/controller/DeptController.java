package com.lsy.controller;

import com.lsy.pojo.Dept;
import com.lsy.service.DeptService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class DeptController {

    @Autowired
    private DeptService service = null;

    @RequestMapping(value = "/dept/get/{id}",method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出错误信息，会自动调用@HystrixCommand标注好的defaultFallback调用类中指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public Dept get(@PathVariable("id") Long id){
        Dept dept = this.service.findById(id);
        if (dept == null){
            throw new RuntimeException("该ID:"+id+"没有对应的信息");
        }
        return dept;
    }

    //服务调用失败也会给予响应，不会阻塞不通，造成联机级障。这就是服务熔断
    public Dept processHystrix_Get(@PathVariable("id") Long id){
        return new Dept().setDeptno(id).setDname("该ID:"+id+"没有对应的信息，null--@HystrixCommand")
                .setDb_source("this data no in the mysql");
    }
}
