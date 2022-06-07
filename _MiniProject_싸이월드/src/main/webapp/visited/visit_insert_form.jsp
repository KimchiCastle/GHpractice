<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	
	function send(f) {
		
		var m_id = f.m_id.value.trim();
		var content = f.content.value.trim();
		var pwd = f.pwd.value.trim();
		
		if(content==''){
			Swal.fire({
				title	 : '내용을 입력하세요.',
				icon	 : 'error',
				didClose : () => {
					f.content.value='';
					f.content.focus();
				}
			
			});

			return;
		}
		
		if(pwd==''){
			Swal.fire({
				title	 : '비밀번호를 입력하세요.',
				icon	 : 'error',
				didClose : () => {
					f.pwd.value='';
					f.pwd.focus();
				}
			
			});

			return;
		}
		
		
		
		f.action = "insert.do";
	
		f.submit();
	}

	function cancel() {
		
		Swal.fire({
			  title: '글쓰기를 취소 하시겠습니까?',
			  icon: 'warning',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '확인',
			  cancelButtonText: '취소'
			}).then((result) => {
			  if (result.isConfirmed) {
			    location.href="list_login.do";
			  }
			})
		
	}
	
	
</script>


<style type="text/css">
	#box{
		margin: auto;
		margin-top: 30px;
		width: 550px;
	}
	textarea {
	width: 100%;
	resize: none;
}
	
</style>

</head>
<body>

	<form>
		<div id="box">
			<input type="hidden" name="m_id" value="${ member.m_id }">
			<div class="panel panel-primary">
				<div class="panel-heading">
					<h4>방명록쓰기</h4>
				</div>
				<div class="panel-body">
					<table class="table">
						
						<tr>
							<th>${ member.m_id }님의 작성</th>
						</tr>
						
						<tr>
							<th>내용</th>
							<td><textarea name="content"  rows="5" cols="50" ></textarea></td>
						</tr>
						<tr>
							<th>비밀번호</th>
							<td><input type="password" name="pwd"></td>
						</tr>
						
						<tr>
							<td colspan="2" align="center" >
								<input class="btn btn-primary" type="button" value="글올리기"
								onclick="send(this.form);">
		
								<input class="btn btn-succese" type="button" value="목록보기"
								onclick="cancel();">
							</td>
						</tr>
						
						
					</table>
					</div>

				</div>
			</div>


	
	</form>

</body>
</html>