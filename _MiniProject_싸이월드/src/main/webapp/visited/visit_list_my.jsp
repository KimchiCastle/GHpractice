<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>

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

<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>

<script type="text/javascript">
	

	
	function del(f) { // f = this.form
		var idx = f.idx.value;
		var pwd = f.pwd.value; // 원래비번
		var c_pwd = f.c_pwd.value.trim();
		var id = f.id.value; //  작성한 사람 id
		var m_id = f.m_id.value; // 현재 로그인 id
		
		if(id!=m_id){
			Swal.fire({
				title	 : '본인이 작성한 글이 아닙니다.',
				icon	 : 'error'
			});
			return;
			
		}
		
		if(c_pwd==''){
			Swal.fire({
				title	 : '삭제할 게시물의 비밀번호를 입력하세요.',
				icon	 : 'error',
				didClose : () => {
					f.c_pwd.value='';
					f.c_pwd.focus();
				}
			
			});

			return;

		}
		
		if(c_pwd != pwd){
			
			Swal.fire({
				title	 : '비밀번호가 틀렸습니다.',
				icon	 : 'error',
				didClose : () => {
					f.c_pwd.value='';
					f.c_pwd.focus();
				}
			
			});

			
			alert();
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
			Swal.fire({
				title	 : '수정할 게시물의 비밀번호를 입력하세요.',
				icon	 : 'error',
				didClose : () => {
					f.c_pwd.value='';
					f.c_pwd.focus();
				}
			
			});

			return;

		}
		
		if(c_pwd != pwd){
			
			Swal.fire({
				title	 : '비밀번호가 틀렸습니다.',
				icon	 : 'error',
				didClose : () => {
					f.c_pwd.value='';
					f.c_pwd.focus();
				}
			
			});
			

			return;
		}
	
		location.href = "modify_form.do?idx="+idx;
	}
	
</script>

<style type="text/css">

	a{
		margin-left: 15px;
		text-decoration : none;
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
	
	<span>${ member.m_id }님 환영합니다!!</span>
	
	<a href="logout.do">로그아웃</a>
	
	<hr style="margin: 0px;">
		<h1 id="title">방명록 게시판</h1>
		<hr>
		<div align="left" style="width: 50%; float: left;">
			<input class="btn btn-defualt" type="button" value="메인으로"
				style="margin-bottom: 10px;"
				onclick="location.href='list_login.do'">
		</div>

		<div align="right"style="width: 50%; float: left;">
			<input class="btn btn-info" type="button" value="글쓰기"
				style="margin-bottom: 10px;"
				onclick="location.href='insert_form.do'">
		</div>

		<!-- 게시물이 없으면 -->
		<c:if test="${ empty list }">
			<div id="empty_message">게시물이 없습니다.</div>
		</c:if>


		<c:forEach var="vo" items="${ list }">

			<form>
				<input type="hidden" name="id" value="${ vo.m_id }"> 
				<input type="hidden" name="idx" value="${ vo.idx }"> 
				<input type="hidden" name="m_id" value="${ member.m_id }">
				<input type="text" name="pwd" value="${ vo.pwd }">

				<div class="panel panel-info">
					<div class="panel-heading">
						<h4>[${ vo.m_id }]님의 글</h4>
					</div>
					<div class="panel-body">
						<div class="content_type">${ vo.content }</div>
						<div style="width: 50%; float: left;">작성일자 : ${ fn:substring(vo.regdate,0,10) }</div>
						<div style="width: 50%; float: left; text-align: right;">${ vo.ip }</div>
						<div style="clear: both;">
						
						
							<c:if test="${ vo.m_id == member.m_id }">
							비밀번호 : <input type="password" name="c_pwd"> 
							<input
								class="btn btn-info" type="button" value="수정"
								onclick="modify(this.form);">
							<input class="btn btn-danger" type="button" value="삭제"
								onclick="del(this.form);">
							</c:if>
							
							
							
							
						</div>

					</div>
				</div>

			</form>
		</c:forEach>

	</div>
</body>
</html>