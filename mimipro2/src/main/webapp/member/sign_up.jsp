<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<!-- Bootstrap 3.x 사용설정 : CDN(Content Delivery Network) -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<script src="https://code.jquery.com/jquery-3.6.0.js"></script>

<!-- sweetAlert2 CDN -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">
	
</script>

<!-- w3.css 사용설정 -->
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<!-- 이메일 정규식 및 중복체크 -->
<script type="text/javascript">
	var mailRegCheck =/^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	
	$(document).ready(function(){
		  $("#m_email").keyup(function(event){
			  
			  var m_email = $( this ).val();
			  
			  console.log(m_email);
			  
			  if(mailRegCheck.test(m_email)==false){
				  $("#email_msg").html("형식이 잘못되었습니다.")
				     .css("color","#ffcccc");
				  
				  //서버 안갔다왔을때(클라쪽). 여기 비활성화 안주면 안됨
				  $("#btn_register").attr("disabled",true);
				  return;
			  }
				//서버에 사용 가능 여부 확인
			  $.ajax({
				  url:'check_email.do',  //MemberCheckEmailAction
			      data:{"m_email":m_email}, //parameter: check_email.do?m_email=이메일
			      dataType:'json',
			      success:function(res){
			    	  //res = {"res":true}
			    	  //res = {"res":false}
						if(res.result){ // 사용가능
							
							$("#email_msg").html("사용가능한 ID입니다.").css("color","#cccfff");
							
							//가입하기 버튼 활성화
							$("#btn_register").attr("disabled",false);
						
						}else{
							$("#email_msg").html("이미 사용중인 ID입니다.").css("color","#ffcccc");
							
							//가입하기 버튼 비활성화
							$("#btn_register").attr("disabled",true);
						}
			      },
			      error:function(err){
			    	  alert(err.responseText);
			      }
			  });
		  });
	});

 
	function send(f) {

		//필수 입력 항목
		var m_id = f.m_id.value.trim();
		var m_name = f.m_name.value.trim();
		var m_pwd = f.m_pwd.value.trim();
		var pwd_check = f.pwd_check.value.trim();
		var m_email = f.m_email.value.trim();

		
		
		//아이디 체크
		if (m_id == '') {
			Swal.fire({
				 icon	: 'error',
				  title : 'ID를 입력하세요.',
				  didClose: () => {
						f.m_id.value = '';
						f.m_id.focus();
				  }
			})
			
			return;
		}
		
		//비밀번호 체크
		if (m_pwd == '') {
			Swal.fire({
				 icon	: 'error',
				  title : '비밀번호를 입력하세요.',
				  didClose: () => {
						f.m_pwd.value = '';
						f.m_pwd.focus();
				  }
			})
			
			return;
		}

		//비밀번호확인 체크
		if (m_pwd != pwd_check) {
			 Swal.fire({
				 icon	: 'error',
				  title : '비밀번호가 서로 일치하지 않습니다.',
				  didClose: () => {
						f.pwd_check.value = '';
						f.pwd_check.focus();
				  }
			})


		 return;
			 
		 } 

		var korRegCheck = /[ㄱ-ㅎㅏ-ㅣ가-힣]/;

		//이름 체크
		if (m_name == '') {
			 Swal.fire({
				 icon	: 'error',
				  title : '이름을 입력하세요.',
				  didClose: () => {
						f.m_name.value = '';
						f.m_name.focus();
				  }
			})
			
			return;
		}

		if(!korRegCheck.test(m_name)){
			Swal.fire({
				 icon	: 'error',
				  title : '이름은 한글만 입력가능 합니다.',
				  didClose: () => {
						 f.m_name.value = '';
						 f.m_name.focus();
				  }
			})
		 return;
		 } 

		//이메일 체크
		if (m_email == '') {
			 Swal.fire({
				 icon	: 'error',
				  title : '이메일을 입력하세요.',
				  didClose: () => {
						f.m_email.value = '';
						f.m_email.focus();
				  }
			})
			
			return;
		}


		// ===================================================

		//전송대상
		f.action = "join_insert.do";

		//전송
		f.submit();
	}

	/* 회원가입 취소 버튼 눌렀을때.. */
	$(function() {
		$("#cancle").click(function() {
			
			Swal.fire({
				title: '회원가입을 취소 하시겠습니까?',
				  icon: 'question',
				  showCancelButton: true,
				  confirmButtonColor: '#3085d6',
				  cancelButtonColor: '#d33',
				  confirmButtonText: '확인',
				  cancelButtonText: '취소'
			}).then((result) => {
			  if (result.isConfirmed) {
			    	location.href="../visit/list.do";
			  }
			})
			
		})
	});
	
</script>

<!-- 아이디 체크 정규식 및 중복체크 -->
<script type="text/javascript">
	var regular_id = /^[a-zA-Z0-9]{3,15}$/;
	
	//ID check
	$(function() {
		
		$("#m_id").keyup(function(event){
						
			//			자기 자신, #m_id
			var m_id = $(this).val();
	
			if( regular_id.test(m_id)==false ){
				
				$("#id_msg").html("영문자, 숫자 3~15자리를 입력하세요.")
						    .css("color","#ffcccc");
				
				//가입하기 버튼 비활성화
				$("#btn_register").attr("disabled",true);
				
				
				return;
			}
				
			//서버에 사용가능 여부 확인(jQuery Ajax)			
			$.ajax({
				
				url			: 'check_id.do', 		//MemberCheckIdAction
				type		: 'GET',
				data		: { 'm_id' : m_id },	//Parameter : check_id?m_id=one
				dataType	: 'json',
				success		: function(result_data){
					//result_data = {"result" : true};	// 사용가능
					//result_data = {"result" : false};	// 사용 중
	
					if(result_data.result){ // 사용가능
						
						$("#id_msg").html("사용가능한 ID입니다.").css("color","#cccfff");
						
						//가입하기 버튼 활성화
						$("#btn_register").attr("disabled",false);
					
					}else{
						$("#id_msg").html("이미 사용중인 ID입니다.").css("color","#ffcccc");
						
						//가입하기 버튼 비활성화
						$("#btn_register").attr("disabled",true);
					}
						
				
				},
				error		: function(err){
					
					alert(err.responseText);
					
				}
				
			});
			
			
			
		});
		
		
	});


</script>


<style type="text/css">
#box {
	width: 500px;
	min-height: 300px;
	margin: auto;
	margin-top: 30px;
}

#id_msg {
	display: inline-block;
	width: 300px;
}

#email_msg {
	display: inline-block;
	width: 300px;
}
</style>

</head>
<body>

	<form>
		<div id="box">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 style="text-align: center">회원가입</h3>
				</div>
				<div class="panel-body">
					<!-- table -->

					<table style="margin: auto; margin-top: 30px;">
						<!-- 아이디 -->
						<tr>
							<th><label for="m_id">I D </label></th>
						</tr>
						<tr>
							<th><input type="text" class="form-control" id="m_id"
								name="m_id" placeholder="ID 입력"></th>
						</tr>

						<tr>
							<td><span id="id_msg"></span></td>
						</tr>


						<!-- 비번 -->
						<tr>
							<th><label for="m_pwd">비밀번호 </label></th>
						</tr>

						<tr>
							<!-- 최종적으로 type을 password로 바꿀예정 지금은 개발중이라 text -->
							<th><input type="text" class="form-control" name="m_pwd"
								style="margin-bottom: 10px;" placeholder="비밀번호 입력"></th>
						</tr>
						
						<tr>
							<td><span>　</span></td>
						</tr>
						
						<!-- 비번check -->
						<tr>
							<th><label>비밀번호 재확인 </label></th>
						</tr>

						<tr>
							<th><input type="text" class="form-control" name="pwd_check"
								style="margin-bottom: 10px;" placeholder="비밀번호 재확인"></th>
						</tr>
						
						<tr>
							<td><span>　</span></td>
						</tr>
						
						<!-- 이름 -->
						<tr>
							<th><label for="m_name">이름 </label></th>
						</tr>

						<tr>
							<th><input type="text" class="form-control" name="m_name"
								style="margin-bottom: 10px;" placeholder="이름 입력"></th>
						</tr>
						
						<tr>
							<td><span>　</span></td>
						</tr>
						

						<!-- 이메일 -->
						<tr>
							<th><label for="email">e-mail </label></th>
						</tr>
						<tr>
							<th><input type="text" id="m_email" name="m_email" 
							class="form-control" value="" placeholder="예)email@gmail.com"></th>
						</tr>

						<tr>
							<td><span id="email_msg"></span></td>
						</tr>

						<!-- 가입 / 취소 -->
						<tr>
							<th style="text-align: center;">
								<button type="button" class="btn btn-default" id="btn_register"
									onclick="send(this.form);">가입</button>
								<button type="button" class="btn btn-default" id="cancle">취소</button>
							</th>
						</tr>

					</table>


				</div>
			</div>
		</div>

	</form>

</body>
</html>