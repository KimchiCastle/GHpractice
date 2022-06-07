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
						<input type="button" value="내가 쓴 글" onclick="location.href='list_my.do?m_id=${member.m_id}'">	
					</div>
		
				<!-- 게시물이 없으면 -->
				<c:if test="${ empty list }">
					<div class="ment" id="empty_message">게시글이 없습니다.</div>
				</c:if>
		
		
				<div style="overflow-y:scroll; width:480px; height:190px; margin-top: 10px;">
				<c:forEach var="vo" items="${ list }">
		
					<form>
						<input type="hidden" name="idx" value="${ vo.idx }">
						
						<div>
							<div><h5 style="font-weight: bold; font-style:맑은고딕체; width: 28%; float: left;"  >[${ vo.m_id }]님의 글 : </h5></div>
							<div class="content_type" style="width: 72%; float: left; ">${ vo.content }</div>
							
							<div>
								<div style="float: left; font-size:11px; margin-top:5px;"">작성일자: ${fn:substring(vo.regdate,0,10)}</div>
								<div style="float: right; font-size:11px;">[ip: ${ vo.ip }]</div>
							</div>
						  <br>
						</div>
						
						<div style="clear:both;"></div>
						<br>
						
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