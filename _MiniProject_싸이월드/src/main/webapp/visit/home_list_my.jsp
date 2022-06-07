<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>	
	
<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8">

<!-- <!-- Bootstrap
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script> -->

<!-- sweetAlert2 CDN -->
<script src="//cdn.jsdelivr.net/npm/sweetalert2@11"></script>



<style type="text/css">


*{
    margin: 0px;  
    box-sizing: border-box;  
}

html, body{
    width: 100%;
    height: 100%;
}

.wrapper_home{
    width: 100%;
    height: 100%;
    border-radius: 15px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.home_header{
    height: 127px;
    padding-top: 20px;
    padding-left: 30px;
    padding-right: 30px;
}

.footer_home{
    height: 260px;
    padding-left: 30px;
    padding-right: 30px;
    padding-bottom: 26px;
}

.footer__title{
    margin-bottom: 13px;
}

.title1{
    font-size: 13px;
    font-weight: 700;
    font-style: Malgun Gothic normal;
    color: skyblue;
}

.title2{
    font-size: 8px;
    font-weight: 400;
    font-style: Sci Fied Bitmap normal;
    line-height: 8px;
    letter-spacing: -0.08em;
}

.line{
    border-top: 1px solid black;
    margin-top: 8px;
    margin-bottom: 8px;
}

.ment{
    font-family: Malgun Gothic;
    font-style: normal;
    font-weight: normal;
    font-size: 11px;
    line-height: 15px;
}

.video{
    width: 464px;
    height: 240px;
    background-color: gray;
}

</style>

<script type="text/javascript">
	
	function del(f) { // f = this.form
		
		var idx = f.idx.value; // 게시물 번호
		var pwd = f.pwd.value; // 원래비번
		var c_pwd = f.c_pwd.value.trim();
		var m_id = f.m_id.value.trim();
		
		if(c_pwd==''){
			
			Swal.fire({
				  text : '삭제할 게시글의 비밀번호를 입력하세요.',
				  icon : 'error',
				  didClose: () => {
					    f.c_pwd.value='';
						f.c_pwd.focus();
				  }
				})

			return;
		}
		
		if(c_pwd != pwd){
			
			Swal.fire({
				  text : '비밀번호가 틀렸습니다.',
				  icon : 'error',
				  didClose: () => {
					    f.c_pwd.value='';
						f.c_pwd.focus();
				  }
				})

			return;
		}
		
		Swal.fire({
			  text: '정말 삭제하시겠습니까?',
			  icon: 'question',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '확인',
			  cancelButtonText: '취소'
			}).then((result) => {
			  
				if (result.isConfirmed) {
				  location.href='delete.do?idx='+idx+'&m_id='+m_id;
			  }
			})

	}
	

	
	
	function modify(f){
		
		var idx = f.idx.value; // 게시물 번호
		var name = f.name.value;
	/* 	var content = f.content.value; */
		var pwd = f.pwd.value;
		var c_pwd = f.c_pwd.value.trim();
		var m_id = f.m_id.value.trim();
		
		if(c_pwd==''){
			
			Swal.fire({
				  text : '수정할 게시글의 비밀번호를 입력하세요.',
				  icon : 'error',
				  didClose: () => {
					    f.c_pwd.value='';
						f.c_pwd.focus();
				  }
				})
			return;
		}
		
		if(c_pwd != pwd){
			
			Swal.fire({
				  text : '비밀번호가 틀렸습니다.',
				  icon : 'error',
				  didClose: () => {
					    f.c_pwd.value='';
						f.c_pwd.focus();
				  }
				})

			return;
		}
		
		
		location.href = "modify_form.do?idx="+idx+'&m_id='+m_id;
	}
	
	
</script>

<head>
    <title>싸이월드 홈</title>
    <!-- <link rel="stylesheet" href="styles/home.css"> -->
</head>
<body>

	
	
    <div class="wrapper_home">
        <div class="wrapper__body">
            <div class="home_header">
                <div class="header__title">
                    <span class="title1">Updated news</span>
                    <span class="title2">TODAY STORY</span>
                </div>
                <div class="line"></div>
                <div class="ment">[스크랩] 싸이월드 BGM 2022</div>
                <div class="ment">[스크랩] "발랄+깜찍" 이 노래가 이랬어?</div>
                <div class="ment">[스크랩] 여름맞이 여행추천 -_-+</div>
                <div class="ment">[스크랩] 집인데 집 가고싶을 때... 눈water ㅎㅡㄹㄹㅣㄴDㅏ..</div>
            </div>
            <div class="footer_home" style="margin-top:20px;">
                <div class="footer__title">
                    <span class="title1">방명록</span>
                    <span class="title2">  What friends Say</span>
                </div>
                
                <div>
                	<div id="box">
				
					<div align="right">
						<input class="btn btn-primary" type="button" value="글쓰기"
							style="margin-bottom: 10px;"
							onclick="location.href='insert_form.do'">
						<input type="button" value="목록보기" onclick="location.href='list_login.do'">
					</div>
		
				<!-- 게시물이 없으면 -->
				<c:if test="${ empty list }">
					<div class="ment" id="empty_message">게시글이 없습니다.</div>
				</c:if>
		
		
		
				<div style="overflow-y:scroll; width:480px; height:200px; margin-top: 10px;">

				<c:forEach var="vo" items="${ list }">
		
					<form>
						<input type="hidden" name="idx" value="${ vo.idx }">
						<input type="hidden" name="pwd" value="${ vo.pwd }">
						<input type="hidden" name="m_id" value="${vo.m_id}">
						
						<div>
							<div class="content_type">${ vo.content }</div>
							
							<div>
								<div style="font-size:11px; margin-top:5px;">작성일자: ${fn:substring(vo.regdate,0,10)}</div>
							</div>
						</div>
						
						<div style="clear: both;">
								
							<tr>
								<td colspan="2" align="center"><h5>비밀번호: <input type="password" name="c_pwd">
									<input type="button" value="수정" onclick="modify(this.form);">
									<input type="button" value="삭제" onclick="del(this.form);">
									</h5>
								</td>
							</tr>
						</div>	
						
					</form>
						
					<br>	
				</c:forEach>
				
				
				</div>
				</div>
				</div>
                </div>
                
                
            </div>
        </div>
    </div>
</body>
</html>	