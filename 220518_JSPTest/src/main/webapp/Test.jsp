<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%! 
	//선언부
	int a = 10;
	
	//멤버메소드 인스턴스메소드 이렇게 사용하는 경우는 거의 없다.
	void sub(){
		
	}

%>   

<%
	//scriptlet : Java Code작성
	//_jspService()메소드 내에 코딩된다.
	Random random = new Random();
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


<%
	for(int i=0; i<5; i++){
%>
안녕 JSP야!!! -> 정말 반갑네<br>
<%
	} // for - end
%>

<% int x =100; %>

a  <%= a %><br>
x  <%= x %><br>

<%
	for(int i=0; i<10; i++){
		//여기서 out은 JSP 내장 객체이다.
		out.print(a + " ");
	}
	
%>


</body>
</html>