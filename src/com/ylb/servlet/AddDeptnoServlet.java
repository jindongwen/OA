package com.ylb.servlet;

import com.ylb.entity.Dept;
import com.ylb.service.Imp.DeptnoServletImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

@WebServlet("/sxt/AddDeptnoServlet")
public class AddDeptnoServlet extends BaseServlet {


    private void deptSave(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        DeptnoServletImp dep = new DeptnoServletImp();
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept dept = new Dept(deptno, deptname, location);
        System.out.println(dept);
        int num = dep.insert(dept);
        if (num > 0){
            resp.sendRedirect(req.getContextPath() +"/sxt/AddDeptnoServlet?method=deptFindAll");
        }else{

        }
    }

    private void deptFindAll(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        DeptnoServletImp dep = new DeptnoServletImp();
        List<Dept> search = dep.search();
        req.setAttribute("list",search);
        req.getRequestDispatcher("/deptList.jsp").forward(req,resp);
    }
    private void deptFindOne(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        DeptnoServletImp dep = new DeptnoServletImp();
        Dept dept = dep.FindOne(deptno);
        req.setAttribute("dept",dept);
        req.getRequestDispatcher("/deptUpdate.jsp").forward(req,resp);
    }

    private void deptSet(HttpServletRequest req,HttpServletResponse resp) throws IOException, ServletException {
        DeptnoServletImp dep = new DeptnoServletImp();
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        String deptname = req.getParameter("deptname");
        String location = req.getParameter("location");
        Dept dept = new Dept(deptno, deptname, location);
        int update = dep.update(dept);

        if(update >  0){
            resp.sendRedirect(req.getContextPath() +"/sxt/AddDeptnoServlet?method=deptFindAll");
        }else{
            req.setAttribute("msg","修改失败");
            req.getRequestDispatcher("/deptUpdate.jsp").forward(req,resp);
        }
    }
    private void deptDelete(HttpServletRequest req,HttpServletResponse resp) throws IOException {
        DeptnoServletImp dep = new DeptnoServletImp();
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        System.out.println(".........."+deptno);
        int delete = dep.delete(deptno);
        System.out.println("Delete="+delete);
        if (delete > 0){
            resp.sendRedirect(req.getContextPath() +"/sxt/AddDeptnoServlet?method=deptFindAll");
        }else{

        }
    }
}
