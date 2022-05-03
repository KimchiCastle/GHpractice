<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<link rel="stylesheet" href="css/my_home.css">
<link rel="stylesheet" href="css/my_home_menu.css">
<link rel="stylesheet" href="css/my_sub_menu.css">

</head>
<body>

	<div id="main_box">
		<div id="header">
		<%@include file="header/my_header.jsp" %>
		</div>
		<div id="header2">
		<%@include file= "header/my_header2.jsp" %>
		</div>
		<div id="aside"><%@include file="menu/5_project.jsp" %></div>
		<div id="content">이곳엔 &lt;공사중&gt;</div>
		<div id="footer"></div>
	</div>


</body>
</html>