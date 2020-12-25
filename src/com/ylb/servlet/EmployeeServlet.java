package com.ylb.servlet;

import com.google.gson.Gson;
import com.ylb.entity.Dept;
import com.ylb.entity.Employee;
import com.ylb.entity.Position;
import com.ylb.service.DeptnoServlet;
import com.ylb.service.EmployeeService;
import com.ylb.service.Imp.DeptnoServletImp;
import com.ylb.service.Imp.EmployeeServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/sxt/EmployeeServlet")
public class EmployeeServlet  extends BaseServlet {
    private DeptnoServlet dept = new DeptnoServletImp();
    private EmployeeService emps = new EmployeeServiceImp();
    private Employee emp=null;

    //查询上级领导
    protected void empAllMgr(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Employee> mgr = emps.findMgr();
        String s = new Gson().toJson(mgr);
        resp.getWriter().print(s);
    }

    protected void empFindMgr(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        List<Employee> mgr = emps.findMgr();
        String s = new Gson().toJson(mgr);
        resp.getWriter().print(s);
    }

    protected void empLogin(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String pwd = req.getParameter("pwd");
        EmployeeService empSer = new EmployeeServiceImp();
        Employee emp = empSer.login(name, pwd);
        if(emp!=null){
//            登陆成功 使用session 实现欢迎登陆页面
            HttpSession session = req.getSession();
            session.setAttribute("emp",emp);

            resp.sendRedirect(req.getContextPath()+"/main.html");
        }else {
            resp.sendRedirect(req.getContextPath()+"/login.jsp");
        }
    }


    protected void empLogout(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        emp=null;

        resp.sendRedirect(req.getContextPath()+"/login.jsp");
    }

    protected void empSave(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
        EmployeeService emp = new EmployeeServiceImp();
        String empId = req.getParameter("empId");
        String password = req.getParameter("password");
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        int posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrid");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        String birth = req.getParameter("birthDate");
        LocalDate birthDate = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hire = req.getParameter("hireDate");
        LocalDate hireDate = LocalDate.parse(hire, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String leave = req.getParameter("leaveDate");
        LocalDate leaveDate = LocalDate.parse(hire, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int onDuty = Integer.parseInt(req.getParameter("onDuty"));
        int empType = Integer.parseInt(req.getParameter("empType"));
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emerContactPerson = req.getParameter("emerContactPerson");
        String idCard = req.getParameter("idCard");
        Date date = Date.valueOf(birth);
        Employee employee = new Employee(empId, password, deptno, posid, mgrid, realName, sex, birthDate, hireDate, leaveDate, onDuty, empType, phone, qq, emerContactPerson, idCard);

        int save = emps.save(employee);
        if(save>0){
            req.getRequestDispatcher("/sxt/EmployeeServlet?method=empFindAll").forward(req,resp);
        }else{
            resp.sendRedirect(req.getContextPath()+"/empList.html");
        }
    }

    protected void empFindDEM(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Dept> deptList = dept.search();  //部门所有信息
        List<Position> posList = dept.posFindAll(); //查询岗位
        List<Employee> mgrList = emps.findMgr();

        req.setAttribute("deptList",deptList);
        req.setAttribute("posList",posList);
        req.setAttribute("mgrList",mgrList);
        req.getRequestDispatcher("/empAdd.jsp").forward(req,resp);
    }
    protected void empFindAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService emp = new EmployeeServiceImp();
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        String onduty = req.getParameter("onduty");
        String hiredate = req.getParameter("hiredate");

        System.out.println("empid:"+empid);
        System.out.println("deptno:"+deptno);
        System.out.println("onduty:"+onduty);
        System.out.println("hiredate:"+hiredate);
//        查询所有部门
        List<Dept> deptList = dept.search();


        List<Employee> employees = emps.FindAll(empid, deptno, onduty, hiredate);
        req.setAttribute("deptno",deptno);
        req.setAttribute("deptList",deptList);
        req.setAttribute("list",employees);
        req.getRequestDispatcher("/empList.jsp").forward(req,resp);
    }


    protected void empDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService emp = new EmployeeServiceImp();
        String empid = req.getParameter("empid");

        int i = emp.deleteOne(empid);
        if(i > 0){
            resp.sendRedirect(req.getContextPath()+"/sxt/EmployeeServlet?method=empFindAll");
        }
    }

    protected void empFindOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String empid = req.getParameter("empid");
        EmployeeService emp = new EmployeeServiceImp();
        Employee one = emp.findOne(empid);
        req.setAttribute("emp",one);
        req.getRequestDispatcher("/empUpdate.jsp").forward(req,resp);
    }
    protected void empUpdate(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        EmployeeService emp = new EmployeeServiceImp();
        String empId = req.getParameter("empId");
        String password = req.getParameter("password");
        int deptno = Integer.parseInt(req.getParameter("deptno"));
        int posid = Integer.parseInt(req.getParameter("posid"));
        String mgrid = req.getParameter("mgrid");
        String realName = req.getParameter("realName");
        String sex = req.getParameter("sex");
        String birth = req.getParameter("birthDate");
        LocalDate birthDate = LocalDate.parse(birth, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String hire = req.getParameter("hireDate");
        LocalDate hireDate = LocalDate.parse(hire, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        String leave = req.getParameter("leaveDate");
        LocalDate leaveDate = LocalDate.parse(hire, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
        int onDuty = Integer.parseInt(req.getParameter("onDuty"));
        int empType = Integer.parseInt(req.getParameter("empType"));
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String emerContactPerson = req.getParameter("emerContactPerson");
        String idCard = req.getParameter("idCard");

        Employee employee = new Employee(empId, password, deptno, posid, mgrid, realName, sex, birthDate, hireDate, leaveDate, onDuty, empType, phone, qq, emerContactPerson, idCard);
        int update = emp.Update(employee);
        if(update > 0){
            req.getRequestDispatcher("/sxt/EmployeeServlet?method=empFindAll").forward(req,resp);
        }
    }
}
