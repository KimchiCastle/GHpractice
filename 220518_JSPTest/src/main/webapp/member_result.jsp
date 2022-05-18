<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	//Java Code -> _jspService(request, response) 메소드 내에 삽입
	
	//편집상에서는 내장객체는 보이지 않는다. 실행상태에서 코드에 내장되어 있다.
	//JSP내장객체 : request, response, session, application
	//				out
	
	
	request.setCharacterEncoding("UTF-8");
	
	


	String id = request.getParameter("id");
	System.out.println(id);
	String pwd = request.getParameter("pwd");
	System.out.println(pwd);
	
	
	//System.out.println(pwdMasking.substring(pwd.length()/2,pwd.length()));
	
	
	
	StringBuffer sbPwd = new StringBuffer();
	//String pwdMasking = pwd.substring(0, pwd.length()/2);
	
	sbPwd.append(pwd.substring(0, pwd.length()/2));
	
	for(int i=pwd.length()/2; i<pwd.length(); i++) {
		
		sbPwd.append("*");
		
	}
	
	System.out.println(sbPwd);
	
	String pwdMasking = sbPwd.toString();
	
	String name = request.getParameter("name");
	System.out.println(name);
	
	//String email = request.getParameter("email");
	//String email2 = request.getParameter("email2");
	
	String userEmail = String.format( "%s@%s", request.getParameter("email"), request.getParameter("email2"));
	System.out.println(userEmail); 
	
	String profile = request.getParameter("profile");
	System.out.println(profile);
	
	String MBTI = request.getParameter("MBTI");
	String gender = request.getParameter("gender");
	String recommender = request.getParameter("recommender");
	
	recommender.trim();
	
	if(recommender.isEmpty()) {
		recommender = "추천인없음";
	}
	
	
	String [] hobby_array = request.getParameterValues("hobby");
	
	//취미처리
	String hobby_list = "취미 없음";
	
	if(hobby_array != null) {
		
		StringBuffer sb = new StringBuffer();
		
		//String [] hobby_array = {"운동", 독서"};
		for(String hobby : hobby_array) {
			
			sb.append(hobby).append(" ");
			
			
		}
		
		//hobby_list 초기화
		hobby_list = sb.toString().trim();
		
	}

	System.out.println(hobby_list);
	
	//Business Logic ▲
%>  


<!-- // Presentation Logic : ▼ -->

    
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
		width: 400px;
		margin: auto;
		margin-top: 30px; 
		border: 1px solid blue;
		box-shadow: 1px 1px 1px black;
	}
	
	caption {
		text-align: center;
	}

</style>

</head>
<body>

<div id='box'>
	<table class="table table-striped" >
		<caption>::::회원정보 결과::::</caption>
		<tr>
			<th>이름</th>
			<td><%= name %></td>
		</tr>
		
		<tr>
			<th>ID</th>
			<td><%= id %></td>
		</tr>
		
		<tr>
			<th>비밀번호</th>
			<td><%= pwdMasking %></td>
		</tr>
		
		<tr>
			<th>email</th>
			<td><%= userEmail %></td>
		</tr>
		
		<tr>
			<th>MBTI</th>
			<td><%= MBTI %></td>
		</tr>
		
		<tr>
			<th>추천인</th>
			<td><%= recommender %></td>
		</tr>
		
		<tr>
			<th>취미</th>
			<td><%= hobby_list %></td>
		</tr>
		
		<tr>
			<th>자기소개</th>
			<td><%= profile %></td>
		</tr>
		
		<tr>
			<td colspan="2" align="center">
			<a href="member_input.html">다시하기</a>
		</tr>
	
	</table>

</div>

</body>
</html>