package com.ylb.mapper;

import com.ylb.entity.Dept;
import com.ylb.entity.Position;

import java.util.List;

public interface PositionMapper {
    int posInsert(Position dept);
    List<Position> posSelect();
    int posUpdate(Position dept);
    int posDelete(int number);
    Position posSelectOne(int deptno);

}
