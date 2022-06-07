<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Bootstrap -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<!-- sweetAlert2 CDN -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>


<script type="text/javascript">
	
	function del(f) { // f = this.form
		
		var idx = f.idx.value; // 게시물 번호
		var pwd = f.pwd.value; // 원래비번
		var c_pwd = f.c_pwd.value.trim();
		
		if(c_pwd==''){
			
			alert('삭제할 게시물의 비밀번호를 입력하세요.');
			f.c_pwd.value='';
			f.c_pwd.focus();
			return;

		}
		
		if(c_pwd != pwd){
			alert('비밀번호가 틀렸습니다.');
			return;
		}
		location.href='delete.do?idx='+idx;
	}

	function modify(f){
		
		var idx = f.idx.value; // 게시물 번호
		var name = f.name.value;
	/* 	var content = f.content.value; */
		var pwd = f.pwd.value;
		var c_pwd = f.c_pwd.value.trim();
		
		if(c_pwd==''){
			
			alert('수정할 게시물의 비밀번호를 입력하세요.');
			f.c_pwd.value='';
			f.c_pwd.focus();
			return;

		}
		
		if(c_pwd != pwd){
			alert('비밀번호가 틀렸습니다.');
			f.c_pwd.value='';
			f.c_pwd.focus();
			return;
		}
	
		location.href = "modify_form.do?idx="+idx;
	}
	
	function login(){
		
		Swal.fire({
			  title: '로그인후 이용하실 수 있습니다.',
			  icon: 'info',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '로그인 하기',
			  cancelButtonText: '취소'
			}).then((result) => {
			  if (result.isConfirmed) {
			   
			      location.href='../member/login.jsp';
			   
			  }
			})
		
	}
	
	
</script>
<style type="text/css">

	a{
		margin-left: 15px;
	}
	
	#box {
		margin: auto;
		width: 500px;
		margin-top: 10px;
	}
	
	#title {
		text-align: center;
		font-size: 30px;
		font-family: 휴먼옛체, 굴림체, 궁서체;
		color: #D9EDF7;
		text-shadow: 1px 1px 3px black;
	}
	
	.content_type {
		padding: 5px;
		min-height: 40px;
		border: 1px solid gray;
		box-shadow: -1px -1px 1px #333333;
		text-shadow: none;
		color: black;
	}
</style>


</head>
<body>



	<div id="box">
	<a href="../member/login.jsp" >로그인</a>
	<a href="../member/sign_up.jsp">회원가입</a>
	
	<hr style="margin: 0px;">
		<h1 id="title">::방명록::</h1>
		<hr>
		<div align="left" style="width: 50%; float: left;">
			<input class="btn btn-defualt" type="button" value="내가 쓴글 보러가기"
				style="margin-bottom: 10px;"
				onclick="login();">
		</div>
		<div align="right"style="width: 50%; float: left;">
			<input class="btn btn-info" type="button" value="글쓰기"
				style="margin-bottom: 10px;"
				onclick="login();">
		</div>
		<div style="clear: both;"></div>
		<!-- 게시물이 없으면 -->
		<c:if test="${ empty list }">
			<div id="empty_message">게시물이 없습니다.</div>
		</c:if>

		<c:forEach var="vo" items="${ list }">

			<form>
				<input type="hidden" name="idx" value="${ vo.idx }"> 

				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>[${ vo.m_id }]님의 글</h4>
					</div>
					<div class="panel-body">
						<div class="content_type">${ vo.content }</div>
						<div style="width: 50%; float: left;">작성일자 : ${ fn:substring(vo.regdate,0,10) }</div>
						<div style="width: 50%; float: left; text-align: right;">${ vo.ip }</div>
						<div style="clear: both;">
					
						<!-- 	비밀번호 : <input type="password" name="c_pwd"> <input
								class="btn btn-info" type="button" value="수정"
								onclick="login();">
							<input class="btn btn-danger" type="button" value="삭제"
								onclick="login();"> -->

						</div>

					</div>
				</div>

			</form>
		</c:forEach>

	</div>
</div>
</body>
</html>