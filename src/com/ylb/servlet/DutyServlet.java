package com.ylb.servlet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.ylb.entity.Duty;
import com.ylb.entity.Employee;
import com.ylb.service.DutyService;
import com.ylb.service.Imp.DutyServiceImp;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@WebServlet("/sxt/DutyServlet")
public class DutyServlet extends BaseServlet {
    protected DutyService dutyService = new DutyServiceImp();
    protected void dutyPOI(HttpServletRequest req, HttpServletResponse resp){
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        String dtdate = req.getParameter("dtdate");

        System.out.println(deptno);
        List<Duty> list = dutyService.findMore(empid, deptno, dtdate);
        createExcel(list,resp);
    }

    private static void createExcel(List<Duty> list,HttpServletResponse resp) {
        // 创建一个Excel文件
        HSSFWorkbook workbook = new HSSFWorkbook();
        // 创建一个工作表
        HSSFSheet sheet = workbook.createSheet("考勤");

        CellRangeAddress region = new CellRangeAddress(0, // first row
                0, // last row
                0, // first column
                4 // last column
        );
        sheet.addMergedRegion(region);

        HSSFRow hssfRow = sheet.createRow(0);
        HSSFCell headCell = hssfRow.createCell(0);
        headCell.setCellValue("考勤列表");

        // 设置单元格格式居中
        HSSFCellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);


        headCell.setCellStyle(cellStyle);


        // 添加表头行
        hssfRow = sheet.createRow(1);
        // 添加表头内容
        headCell = hssfRow.createCell(0);
        headCell.setCellValue("姓名");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(1);
        headCell.setCellValue("部门");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(2);
        headCell.setCellValue("日期");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(3);
        headCell.setCellValue("签到时间");
        headCell.setCellStyle(cellStyle);

        headCell = hssfRow.createCell(4);
        headCell.setCellValue("签退时间");
        headCell.setCellStyle(cellStyle);

        // 添加数据内容
        for (int i = 0; i < list.size(); i++) {
            hssfRow = sheet.createRow((int) i + 2);
            Duty duty = list.get(i);

            // 创建单元格，并设置值
            HSSFCell cell = hssfRow.createCell(0);
            cell.setCellValue(duty.getRealName());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(1);
            cell.setCellValue(duty.getDeptName());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(2);
            cell.setCellValue(duty.getDtDate().toString());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(3);
            cell.setCellValue(duty.getSigninTime());
            cell.setCellStyle(cellStyle);

            cell = hssfRow.createCell(4);
            cell.setCellValue(duty.getSignoutTime());
            cell.setCellStyle(cellStyle);
        }

        // 保存Excel文件
        try {
//            OutputStream outputStream = new FileOutputStream("D:/duty.xls");
            resp.setHeader("Content-Disposition","attachment;filename=duty.xls");
            resp.setContentType("application/vnd.ms-excel");
            ServletOutputStream outputStream = resp.getOutputStream();
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void SearchSelectedDuty(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String empid = req.getParameter("empid");
        String deptno = req.getParameter("deptno");
        String dtdate = req.getParameter("dtdate");

        System.out.println(deptno);
        List<Duty> list = dutyService.findMore(empid, deptno, dtdate);

        String s = new Gson().toJson(list);

        resp.getWriter().print(s);
    }
    protected void signOut(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        LocalDate dtDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String signOutTime = LocalTime.now().format(format);
        Employee emp = (Employee) req.getSession().getAttribute("emp");

        Duty duty = new Duty(0, dtDate, null, signOutTime, emp.getEmpId());
        int i = dutyService.signOut(duty);

        resp.getWriter().print(i);

    }
    protected void signIn(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        接收数据
        LocalDate dtDate = LocalDate.now();
        DateTimeFormatter format = DateTimeFormatter.ofPattern("HH:mm:ss");
        String signinTime = LocalTime.now().format(format);
        Employee emp = (Employee) req.getSession().getAttribute("emp");

        Duty duty = new Duty(0, dtDate, signinTime, "00:00:00", emp.getEmpId());

        int i = dutyService.signIn(duty);
        //        数据处理

//        做出响应

        resp.getWriter().print(i);

    }
}
