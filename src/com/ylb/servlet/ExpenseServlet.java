package com.ylb.servlet;

import com.ylb.entity.Employee;
import com.ylb.entity.Expense;
import com.ylb.service.ExpenseService;
import com.ylb.service.Imp.ExpenseServiceImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Date;

@WebServlet("/sxt/ExpenseServlet")
public class ExpenseServlet extends BaseServlet{
    ExpenseService exps = new ExpenseServiceImp();
    protected void expAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Employee emp =(Employee) req.getSession().getAttribute("emp");
        java.sql.Date expTime = new java.sql.Date(new Date().getTime());
        String expDesc = req.getParameter("expDesc");
        String nextAuditor = req.getParameter("nextAuditor");


        Expense expense = new Expense(0, emp.getEmpId(), 1000, expTime, expDesc, nextAuditor, null, "0");
        int i = exps.ExpenseSave(expense);
        if (i >0){
            resp.sendRedirect(req.getContextPath()+"/myExpense.html");
        }else{
            resp.sendRedirect("main.html");
        }

    }
}
