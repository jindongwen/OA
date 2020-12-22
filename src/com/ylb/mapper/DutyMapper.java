package com.ylb.mapper;

import com.ylb.entity.Duty;

import java.time.LocalDate;
import java.util.List;

public interface DutyMapper {
    int dutyInsert(Duty duty);

    Duty dutySelectOne(String empid, LocalDate dtdate);

//    签退：修改考勤信息

    int dutyUpdate(Duty duty);

//    查询考勤信息

    List<Duty> selectMore(String empid,String deptno,String dtdate);
}
