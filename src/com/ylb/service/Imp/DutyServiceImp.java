package com.ylb.service.Imp;

import com.ylb.entity.Duty;
import com.ylb.mapper.DutyMapper;
import com.ylb.service.DutyService;
import com.ylb.util.DBUtil;

import java.util.List;

public class DutyServiceImp implements DutyService {
    @Override
    public int signIn(Duty duty) {
        DutyMapper mapper = DBUtil.getSqlSession().getMapper(DutyMapper.class);
        Duty duty1 = mapper.dutySelectOne(duty.getEmprId(), duty.getDtDate());
        if(duty1 != null){
            return -1;
        }
        
        int i = mapper.dutyInsert(duty);
        DBUtil.closeSqlSession();
        return i;
    }

    @Override
    public int signOut(Duty duty) {
        DutyMapper mapper = DBUtil.getSqlSession().getMapper(DutyMapper.class);
        int i = mapper.dutyUpdate(duty);
        DBUtil.closeSqlSession();
        return i;
    }

    @Override
    public List<Duty> findMore(String empid, String deptno, String dtdate) {
        DutyMapper mapper = DBUtil.getSqlSession().getMapper(DutyMapper.class);
        List<Duty> duties = mapper.selectMore(empid, deptno, dtdate);
        DBUtil.closeSqlSession();
        return  duties;
    }
}
