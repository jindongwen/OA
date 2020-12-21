package com.ylb.servlet;

import com.ylb.entity.Duty;
import com.ylb.entity.Employee;
import com.ylb.service.DutyService;
import com.ylb.service.Imp.DutyServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/sxt/DutyServlet")
public class DutyServlet extends BaseServlet {
    protected DutyService dutyService = new DutyServiceImp();

    protected void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        接收数据
        LocalDate dtDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String signinTime = LocalTime.now().format(format);
        Employee emp = (Employee) req.getSession().getAttribute("emp");
        System.out.println(emp.getEmpId());
        Duty duty = new Duty(0, dtDate, signinTime, "00:00:00",
                emp.getEmpId());
        System.out.println(duty);
        int i = dutyService.signIn(duty);

        //        数据处理

//        做出响应

        resp.getWriter().print(i);

    }
}
