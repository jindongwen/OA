package com.ylb.mapper;

import com.ylb.entity.Dept;

import java.util.List;

/**
 * @Auther: jindongwen
 * @Date: 2020-12-14-22:33
 * @Description:OA
 * @version:1.0
 */
public interface DeptMapper {
    int insert(Dept dept);
    List<Dept> select();
    int update(Dept dept);
    int delete(int number);
    Dept selectOne(int deptno);
}
