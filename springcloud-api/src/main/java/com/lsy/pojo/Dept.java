package com.lsy.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@AllArgsConstructor     //全参构造
@NoArgsConstructor      //无参构造
@Data
@Accessors(chain = true)    //链式写法
public class Dept implements Serializable {
    private Long deptno;   //主键
    private String dname;  //部门名称
    private String db_source;  //来自哪个数据库，因为微服务架构一个服务对应一个数据库，同一信息被储存到不同数据库

}
