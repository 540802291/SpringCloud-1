package com.lsy.controller;

import com.lsy.pojo.Dept;
import com.lsy.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptController_Consumer {

    @Autowired
    private DeptClientService service = null;

    @RequestMapping("/consumer/dept/add")
    public boolean add(Dept dept){
        return this.service.add(dept);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> add(){
        return this.service.list();
    }

    @RequestMapping("/consumer/dept/get/{id}")
    public Dept add(@PathVariable("id")Long id){
        return this.service.get(id);
    }


}
