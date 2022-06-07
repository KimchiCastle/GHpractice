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
	
	function send(f) {
		var m_id    = f.m_id.value.trim();
		var content = f.content.value.trim();
		var pwd     = f.pwd.value.trim();
		
		if(content==''){
			Swal.fire({
				text	 : '내용을 입력하세요.',
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
				text	 : '비밀번호를 입력하세요.',
				icon	 : 'error',
				didClose : () => {
					f.pwd.value='';
					f.pwd.focus();
				}
			
			});

			return;
		}
		
		
		Swal.fire({
			  text: '정말 수정하시겠습니까?',
			  icon: 'question',
			  showCancelButton: true,
			  confirmButtonColor: '#3085d6',
			  cancelButtonColor: '#d33',
			  confirmButtonText: '확인',
			  cancelButtonText: '취소'
			}).then((result) => {
			  
				if (result.isConfirmed) {
				 
					f.action = "modify.do";
					f.submit();
			  }
			})
		
		return;
	}

	
	function cancel() {
		
		Swal.fire({
			  text: '수정을 취소 하시겠습니까?',
			  icon: 'question',
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

<head>
    <title>싸이월드 방명록수정</title>
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
            <div class="footer_home" style="margin-top: 50px;">
                <div class="footer__title">
                    <span class="title1">방명록수정</span>
               </div>
          
                
      <form>
		<div id="box">
			<input type="hidden" name="m_id" value="${ member.m_id }">
			<input type="hidden" name="idx" value="${ vo.idx }">
			
			
				<div>
					<table class="table">
						
						<tr>
							<td style="text-align: left; font-size:15px;">비밀번호</td>
							<td>
								<input type="password" name="pwd" value="${ vo.pwd }" style="margin-left: 10px;">
							</td> 
						</tr>
						
						<tr>
							<td style="text-align: left; font-size:15px;">내용</td>
							<td>
								<textarea name="content"  rows="5" cols="50" style="margin-left: 10px;" >${ vo.content }</textarea>
							</td>
						</tr>
						
						<tr>
							<td colspan="2" align="center" >
								<div style="margin-top: 20px;">	
									<input type="button" value="수정" onclick="send(this.form);">
									<input type="button" value="취소" onclick="cancel();">
								</div>
							</td>
						</tr>
						
						
					</table>
					</div>
				</div>
		</form>
				
				
                </div>
            </div>
        </div>
    </div>
</body>
</html>	