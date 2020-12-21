package com.ylb.mapper;

import com.ylb.entity.Duty;

import java.time.LocalDate;

public interface DutyMapper {
    int dutyInsert(Duty duty);

    Duty dutySelectOne(String empid, LocalDate dtdate);
}
