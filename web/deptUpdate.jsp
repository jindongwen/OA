<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>$Title$</title>
    <base href="<%=request.getContextPath()+"/"%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
</head>

<body>

	<div class="place">
    <span>位置：</span>
    <ul class="placeul">
    <li><a href="#">人事管理</a></li>
    <li><a href="#">修改部门信息</a></li>
    </ul>
    </div>
    
    <div class="formbody">
    
    <div class="formtitle"><span>基本信息</span></div>
    
    <ul class="forminfo">
        <form action="sxt/AddDeptnoServlet?method=deptSet" method="post">
            <li><label>部门编号</label><input name="deptno" type="text" class="dfinput" value="${requestScope.dept.deptno}"/> ${requestScope.msg}</li>
            <li><label>部门名称</label><input name="deptname" type="text" class="dfinput"  value="${requestScope.dept.deptname}"/></li>
            <li><label>办公地点</label><input name="location" type="text" class="dfinput" value="${requestScope.dept.location}"/></li>
            <li><label>&nbsp;</label><input type="submit" class="btn" value="确认保存"/></li>
        </form>
    </ul>
    </div>


</body>

</html>
