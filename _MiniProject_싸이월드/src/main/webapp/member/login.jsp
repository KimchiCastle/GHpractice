<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>싸이월드 로그인</title>
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
				  text : '아이디를 입력하세요.',
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
				  text  : '비밀번호를 입력하세요.',
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
					
					Swal.fire({
						  title: '로그인 성공!',
						  icon: 'success',
						  showCancelButton: false,
						  confirmButtonColor: '#3085d6',
						  cancelButtonColor: '#d33',
						  confirmButtonText: '확인'
						}).then((result) => {
						  if (result.isConfirmed) {
							  
								location.href='../visit/list_login.do';
									
								return;
						  }
						});
				}else{
					
					$(function() {
						$("#fail_m").html('로그인정보가 일치하지않습니다.<br>다시 입력해주세요.').css("color","red");
						return;
					});					
				}
			}
		}); 
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
	margin-top: 150px;
	width: 400px;
	min-height: 300px;
	font-family: 맑은고딕체;
	border: 2px solid #B0E0E6;
	border-radius: 15px;
}

#id_table {
	margin-bottom: 10px;
	margin: auto;
	width: 58%;
}

#input_box {
	margin-bottom: 10px;
}

#background{
	color: black;
	border-radius: 15px;
}

#fail_m{
	font-size: 13px;

}

.panel-heading{
	margin-top:20px;
}



</style>
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body>

	<div id="main_box">
		
		<div id="background">
			
			<div class="panel-heading">
				<h3 style="text-align: center; font-weight: bold; font-family: 맑은고딕체;">로그인</h3> </div>
			<div class="panel-body">

				<form id="login_form">
					
					<table id="id_table">
						<tr>
							<th><input type="text" class="form-control" name="m_id"
								id="input_box" placeholder="ID"></th>
						</tr>
						<tr>
							<th><input type="password" class="form-control" name="m_pwd"
								id="input_box" placeholder="Password"></th>
						</tr>
						<tr>
							<td><span id="fail_m"></span></td>						
						</tr>
						<tr>
							<th>
								<div align="center" style="margin-top: 20px;">
									<button type="button" onclick="login(this.form);">로그인</button>
									<button type="button" id="signup">회원가입</button>

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