package com.ylb.entity;

import java.io.Serializable;

/**
 * @Auther: jindongwen
 * @Date: 2020-12-14-22:28
 * @Description:OA
 * @version:1.0
 */
public class Dept implements Serializable {
    protected int deptno;
    protected String deptname;
    protected String location;

    public Dept() {
    }

    public Dept(int deptno, String deptname, String location) {
        this.deptno = deptno;
        this.deptname = deptname;
        this.location = location;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    public String getDeptname() {
        return deptname;
    }

    public void setDeptname(String deptname) {
        this.deptname = deptname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Dept{" +
                "deptno=" + deptno +
                ", deptname='" + deptname + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}
