<%@page import="myutil.Jumin2"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 
	request.setCharacterEncoding("UTF-8");

	String myJumin = request.getParameter("jumin");
	
	Jumin2 check = new Jumin2();

	check.setJumin_no(myJumin);
	
	// ▲ Business Logic

	
%>   
 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style type="text/css">
	#box{
		width: 200px;
		
	/* 	margin-top: 30px;  */
	}
</style>

</head>
<body>
<div id='box'>
	<table class="table table-striped">
		<tr>
			<th>주민번호</th>
			<td><%= myJumin %></td>
		</tr>
		
		<% 	if(!check.isvalid2()){ %>	
			<tr> <th colspan="2">잘못된 주민번호 입니다.</th> </tr>
			<tr> <td colspan="2" align="center"> <a href="jumin.html">다시하기</a></tr>
		<% }else { %>	
		<tr>
			<th>출생년도</th>
			<td><%= check.getYear() %> <%= check.getGanji() %></td>
		</tr>
		<tr>
			<th>나이</th>
			<td><%= check.getAge() %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%= check.getGender() %></td>
		</tr>
		<tr>
			<th>띠</th>
			<td><%= check.getTti() %></td>
		</tr>
		<tr>
			<th>출생계절</th>
			<td><%= check.getSeason() %></td>
		</tr>
		<tr>
			<th>출생지역</th>
			<td><%= check.getLocal() %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
			<!-- <a href="jumin.html">다시하기</a> -->
			<input type="button" value="다시하기"
				onclick="location.href='jumin.html';">
	 	</tr>
		
		<%} %>

	</table>
</div>	
</body>
</html>