package com.ylb.service;

import com.ylb.entity.Dept;
import com.ylb.entity.Position;

import java.util.List;

/**
 * @Auther: jindongwen
 * @Date: 2020-12-14-23:52
 * @Description:OA
 * @version:1.0
 */
public interface DeptnoServlet {
    int insert(Dept dept);
    int delete(int deptno);
    int update(Dept dept);
    List<Dept> search( );
    Dept FindOne(int deptno);


    List<Position> posFindAll();
    int posSave(Position p);
    int posDelete(int p);
    Position posFindOne(int p);
    int posUpdate(Position p);
}
