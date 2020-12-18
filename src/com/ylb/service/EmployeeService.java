package com.ylb.service;

import com.ylb.entity.Employee;
import com.ylb.mapper.EmpMapper;

import java.util.List;

public interface EmployeeService {
    int save(Employee emp);

    List<Employee> FindAll(String empId, String deptno, String onduty, String hirdate);

    int deleteOne(String empid);

    Employee findOne(String empId);

    int Update(Employee emp);
}
