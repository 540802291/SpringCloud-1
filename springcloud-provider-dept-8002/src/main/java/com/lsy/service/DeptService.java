package com.lsy.service;

import com.lsy.dao.DeptDao;
import com.lsy.pojo.Dept;

import java.util.List;

public interface DeptService extends DeptDao {
    @Override
    boolean addDept(Dept dept);

    @Override
    Dept findById(Long id);

    @Override
    List<Dept> findAll();
}
