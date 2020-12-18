package com.ylb.servlet;

import com.ylb.entity.Position;
import com.ylb.service.DeptnoServlet;
import com.ylb.service.Imp.DeptnoServletImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/PosServlet")
public class PosServlet extends BaseServlet {
    private void posSelectAll(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptnoServlet ser = new DeptnoServletImp();
        List<Position> positions = ser.posFindAll();
        req.setAttribute("list", positions);
        req.getRequestDispatcher("/positionList.jsp").forward(req, resp);
    }

    private void posSave(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DeptnoServlet ser = new DeptnoServletImp();
        int posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");

        Position position = new Position(posid, pname, pdesc);
        int i = ser.posSave(position);
        if(i > 0){
            resp.sendRedirect(req.getContextPath()+"/PosServlet?method=posSelectAll");
        }
    }

    private void posDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DeptnoServlet ser = new DeptnoServletImp();
        int posid = Integer.parseInt(req.getParameter("posid"));

        int i = ser.posDelete(posid);
        if(i > 0){
            resp.sendRedirect(req.getContextPath()+"/PosServlet?method=posSelectAll");
        }
    }

    private void posFindOne(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        DeptnoServlet ser = new DeptnoServletImp();

        int posid = Integer.parseInt(req.getParameter("posid"));

        Position position = ser.posFindOne(posid);
        req.setAttribute("pos",position);
        req.getRequestDispatcher("/positionUpdate.jsp").forward(req,resp);
    }

    private void posUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        DeptnoServlet ser = new DeptnoServletImp();
        int posid = Integer.parseInt(req.getParameter("posid"));
        String pname = req.getParameter("pname");
        String pdesc = req.getParameter("pdesc");

        Position position = new Position(posid, pname, pdesc);
        int i = ser.posUpdate(position);
        if(i>0){
            resp.sendRedirect(req.getContextPath()+"/PosServlet?method=posSelectAll");
        }
    }
}
