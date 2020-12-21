package com.ylb.mapper;

import com.ylb.entity.Employee;

import java.util.List;

public interface EmpMapper {
    int empInsert(Employee emp);

    List<Employee> empFindAll(String empId,String deptno, String onduty,String hirdate);

    int empDelete(String empid);

    int empUpdate(Employee emp);

    List<Employee> selectMgr();

//    查询用户 登陆
    Employee empSelectOne(String name,String pwd);
}
