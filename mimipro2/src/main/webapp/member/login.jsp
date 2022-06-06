<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">




	function login(f){
		
		var m_id  = f.m_id.value.trim();
		var m_pwd = f.m_pwd.value.trim();
		
		if(m_id==''){
			Swal.fire({
				 icon	: 'error',
				  title : 'ID를 입력하세요.',
				  text	: 'ID칸이 비어있습니다.',
				  didClose: () => {
						f.m_id.value = '';
						f.m_id.focus();
				  }
				})

			return;
		}
		
		if(m_pwd==''){
			Swal.fire({
				 icon	: 'error',
				  title : '비밀번호를 입력하세요.',
				  text  : '비밀번호가 비어있습니다.',
				  didClose: () => {
						f.m_pwd.value = '';
						f.m_pwd.focus();
				  }
				})
			return;
		}
		
		$.ajax({
			
			type : 'GET',
			url  : 'login.do',
			data : { 'm_id':m_id, 'm_pwd':m_pwd },
			dataType : 'json',
			success : function(res) {
				
				//res = {"result" : true}
				
				if(res.result){
					alert('로그인성공!');
					
					location.href='../visit/list_login.do'
					
					return;
					
					
				}else{
					
					$(function() {
						
						$("#fail_m").html('아이디 또는 비밀번호를 잘못 입력했습니다.<br>입력하신 내용을 다시 확인해주세요.').css("color","red");
						
						return;
						
					});					
				}
				
			},
			error : function(err){
			 	alert(err.responseText); 
			}
			
		} ); 
	/* 	alert('로그인시도');
		return; */
		
/* 		f.method = "GET"; 
		
		f.action = "login.do";

		f.submit();
 */
	}



	$(function() {
		$("#signup").click(function() {

			window.location.href = 'sign_up.jsp';

		})
	});
</script>

<style type="text/css">
#main_box {
	margin: auto;
	margin-top: 60px;
	width: 550px;
	min-height: 300px;
}

#id_table {
	margin-bottom: 10px;
	margin: auto;
	width: 60%;
}

#input_box {
	margin-bottom: 10px;
}
</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<div id="main_box">
		<div class="panel panel-info">
			<div class="panel-heading">
				<h3 style="text-align: center">로그인</h3>
			</div>
			<div class="panel-body">

				<form id="login_form">
					<table id="id_table">
						<tr>
							<th><input type="text" class="form-control" name="m_id"
								id="input_box" placeholder="I D"></th>
						</tr>
						<tr>
							<th><input type="text" class="form-control" name="m_pwd"
								id="input_box" placeholder="비밀번호"></th>
						</tr>
						<tr>
							<td><span id="fail_m"></span></td>						
						</tr>
						<tr>
							<th>
								<div align="center">
									<button type="button" class="btn btn-info"
										onclick="login(this.form);">로그인</button>
									<button type="button" class="btn btn-success" id="signup">회원가입</button>

								</div>
							</th>
						</tr>
					</table>
				</form>

			</div>

		</div>
	</div>


</body>
</html>