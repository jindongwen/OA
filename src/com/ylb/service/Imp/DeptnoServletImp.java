package com.ylb.service.Imp;

import com.ylb.entity.Dept;
import com.ylb.entity.Position;
import com.ylb.mapper.DeptMapper;
import com.ylb.mapper.PositionMapper;
import com.ylb.service.DeptnoServlet;
import com.ylb.util.DBUtil;
import org.apache.logging.log4j.core.util.datetime.FastDateFormat;

import java.util.List;

public class DeptnoServletImp implements DeptnoServlet {
    @Override
    public int insert(Dept dept) {
        DeptMapper mapper = DBUtil.getSqlSession().getMapper(DeptMapper.class);
        int insert = mapper.insert(dept);
        DBUtil.closeSqlSession();
        return insert;
    }

    @Override
    public int delete(int deptno) {
        DeptMapper mapper = DBUtil.getSqlSession().getMapper(DeptMapper.class);
        int d = mapper.delete(deptno);
        DBUtil.closeSqlSession();
        return d;
    }

    @Override
    public int update(Dept dept) {
        DeptMapper mapper = DBUtil.getSqlSession().getMapper(DeptMapper.class);
        int num = mapper.update(dept);
        DBUtil.closeSqlSession();
        return num;
    }

    @Override
    public List<Dept> search() {
        DeptMapper mapper = DBUtil.getSqlSession().getMapper(DeptMapper.class);
        List<Dept> list = mapper.select();
        DBUtil.closeSqlSession();
        return list;
    }

    @Override
    public Dept FindOne(int deptno) {
        DeptMapper mapper = DBUtil.getSqlSession().getMapper(DeptMapper.class);
        Dept dept = mapper.selectOne(deptno);
        DBUtil.closeSqlSession();
        return dept;
    }

    @Override
    public List<Position> posFindAll() {
        PositionMapper mapper = DBUtil.getSqlSession().getMapper(PositionMapper.class);
        List<Position> positions = mapper.posSelect();
        DBUtil.closeSqlSession();
        return positions;
    }

    @Override
    public int posSave(Position p) {
        PositionMapper mapper = DBUtil.getSqlSession().getMapper(PositionMapper.class);
        int i = mapper.posInsert(p);
        DBUtil.closeSqlSession();
        return i;
    }

    @Override
    public int posDelete(int p) {
        PositionMapper mapper = DBUtil.getSqlSession().getMapper(PositionMapper.class);
        int i = mapper.posDelete(p);
        DBUtil.closeSqlSession();
        return i;
    }

    @Override
    public Position posFindOne(int p) {
        PositionMapper mapper = DBUtil.getSqlSession().getMapper(PositionMapper.class);
        Position dept = mapper.posSelectOne(p);
        DBUtil.closeSqlSession();
        return dept;
    }

    @Override
    public int posUpdate(Position p) {
        PositionMapper mapper = DBUtil.getSqlSession().getMapper(PositionMapper.class);
        int i = mapper.posUpdate(p);
        DBUtil.closeSqlSession();
        return i;
    }
}
