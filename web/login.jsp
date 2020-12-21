<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>欢迎登录后台管理系统</title>
<link href="css/style.css" rel="stylesheet" type="text/css" />
<script language="JavaScript" src="js/jquery.js"></script>
<script src="js/cloud.js" type="text/javascript"></script>

<script language="javascript">
	$(function(){
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
	$(window).resize(function(){  
    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
    })  
});  
</script> 

</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">



    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  


<div class="logintop">    
    <span>欢迎访问尚学堂OA系统</span>    
    <ul>
    <li><a href="#">回首页</a></li>
    <li><a href="#">帮助</a></li>
    <li><a href="#">关于</a></li>
    </ul>    
    </div>
    
    <div class="loginbody">
    
    <span class="systemlogo"></span> 
       
    <div class="loginbox loginbox2">
    <form action="sxt/EmployeeServlet?method=empLogin" method="post">
        <ul>
            <li><input name="name" type="text" class="loginuser" value="admin" onclick="JavaScript:this.value=''"/></li>
            <li><input name="pwd" type="text" class="loginpwd" value="密码" onclick="JavaScript:this.value=''"/></li>
            <li class="yzm">
                <span><input name="" type="text" value="验证码" onclick="JavaScript:this.value=''"/></span><cite><img id = "img1" src="rand.jpg" width="120px" height="46px" onclick="change()"></cite>
            </li>
            <li><input type="submit" class="loginbtn" value="登录"  onclick="javascript:window.location='main.html'"  /><label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label></li>
        </ul>
    </form>
    
    </div>
    
    </div>
    
    
   <script type="text/javascript">
       function change(){
           var ele = document.getElementById("img1");
           ele.src="rand.jpg?u="+Math.random();
       }
   </script>
	
    
</body>

</html>
