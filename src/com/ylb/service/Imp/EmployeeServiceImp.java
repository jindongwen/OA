package com.ylb.service.Imp;

import com.ylb.entity.Employee;
import com.ylb.mapper.EmpMapper;
import com.ylb.service.EmployeeService;
import com.ylb.util.DBUtil;

import java.util.List;

public class EmployeeServiceImp implements EmployeeService {
    @Override
    public int save(Employee emp) {
        EmpMapper mapper = DBUtil.getSqlSession().getMapper(EmpMapper.class);
        int save = mapper.empInsert(emp);
        DBUtil.closeSqlSession();
        return save;
    }

    @Override
    public List<Employee> FindAll(String empId, String deptno, String onduty, String hirdate) {
        EmpMapper mapper = DBUtil.getSqlSession().getMapper(EmpMapper.class);
        List<Employee> employees = mapper.empFindAll(empId, deptno, onduty, hirdate);
        DBUtil.closeSqlSession();
        return employees;
    }

    @Override
    public int deleteOne(String empid) {
        EmpMapper mapper = DBUtil.getSqlSession().getMapper(EmpMapper.class);
        int i = mapper.empDelete(empid);
        DBUtil.closeSqlSession();
        return i;
    }

    @Override
    public Employee findOne(String empId) {
        EmpMapper mapper = DBUtil.getSqlSession().getMapper(EmpMapper.class);
        List<Employee> employees = mapper.empFindAll(empId, null, null, null);
        DBUtil.closeSqlSession();
        if (employees != null){
            return employees.get(0);
        }
        return null;
    }

    @Override
    public int Update(Employee emp) {
        EmpMapper mapper = DBUtil.getSqlSession().getMapper(EmpMapper.class);
        int i = mapper.empUpdate(emp);
        DBUtil.closeSqlSession();
        return i;
    }
}
