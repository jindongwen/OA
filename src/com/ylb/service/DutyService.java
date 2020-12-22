package com.ylb.service;

import com.ylb.entity.Duty;

import java.util.List;

public interface DutyService {
    int signIn(Duty duty);

    int signOut(Duty duty);

//    查询指定用户的考勤

    List<Duty> findMore(String empid,String deptno,String dtdate);
}
