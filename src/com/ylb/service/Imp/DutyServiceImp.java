package com.ylb.service.Imp;

import com.ylb.entity.Duty;
import com.ylb.mapper.DutyMapper;
import com.ylb.service.DutyService;
import com.ylb.util.DBUtil;

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
}
