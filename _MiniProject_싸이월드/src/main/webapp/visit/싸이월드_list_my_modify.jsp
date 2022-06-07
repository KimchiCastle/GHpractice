<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	

<!DOCTYPE html>
<html lang="ko">
<meta charset="UTF-8">

<style type="text/css">

*{
    margin: 0px;
    box-sizing: border-box;
}

.background{
	margin: auto;
	margin-top : 70px;
    width: 1024px;
    height: 600px;
    padding-left: 20px;
    padding-top: 20px;
    background-image: url('../images/back2.png');
    border-radius: 15px;
}
.outerbox{
    width: 808px;
    height: 544px;
    /* background-image: url('../images/outer.png'); */
    border-radius: 15px;
    margin-left: 10px;
}
.wrapper_left{
    display: flex;
    flex-direction: row;
    padding-left: 32px;
    padding-top: 32px;
}

.wrapper__left{
    width: 208px;   
    height: 472px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    align-items: left;
    padding-top: 20px;
}

.today {
	font-size: 9px;
	padding-bottom: 8px;
}
.zero {
	color: red;
	font-size: 11px;
}
.count {
	font-size: 11px;
}

.wrapper__left__body{
    width: 208px;
    height: 440px;
    display: flex;
    flex-direction:column;
    justify-content: space-between;
    border: 1px solid gray;
    border-radius: 15px;
    padding-top: 20px;
    padding-bottom: 31px;
    padding-left: 30px;
    padding-right: 30px;
    background-color: white;
}
.wrapper__left__body .header{
    width: 100%;
    height: 70%;
}
.headerGrey{
    width: 148px;
    height:  133px;
    background-color: #c4c4c4;
    background-image: url('../images/login.png');
    background-size: 140px 139px;
}

.line{
    border-top: 1px dotted black;
    margin-top: 12px;
    margin-bottom: 12px;
}
.profileWrapper{
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    height: 72px;
}
.profile{
    color: #999999;
	font-size: 9px;
	font-weight: bold;
}

.wrapper__left__body .footer {
	width: 100%;
	height: 30%;
	display: flex;
	align-items: flex-end;
}

.wrapper__right{
    width: 524px;
    height: 472px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    padding-left: 10px;
    z-index: 1;
}

.wrapper__right__header{
    padding-top: 10px;
    width: 510px;
    display: flex;
    justify-content: space-between;
    align-items: center;
}

.wrapper__right__title{
    padding-left: 40px;
    color: #55b2d4;
    font-weight: 700;
    font-size: 16px;
}

.wrapper__right__setting{
    font-size: 13px;
    font-weight: 500;
}

.wrapper__right__body{
    width: 524px;
    height: 430px;
    background-color: white;
    border: 1px solid gray;
    border-radius: 15px;
}

.feelWrapper{
    width: 141px;
    height: 41px;
    display: flex;
    flex-direction: column;
    justify-content: space-between;
}

.feelSelect{
    width: 141px;
}

.bbbb{
    color: red;
}

a{
	font-size: 14px;
	font-style: 맑은고딕체;
	color: #1E90FF;
}

a:hover{
	color: #87CEEB;
}

</style>

<head>
    <title>싸이월드 방명록수정</title>
</head>

<body>
	
    <div class="background">
		
        <div class="outerbox">
            <div class="wrapper_left">
                <div class="wrapper__left">
                    <div class="wrapper__left__header">
                       
                        <div class="today">
                            <a href="logout.do" style="text-decoration: none;">로그아웃</a>
                        </div>
                    
                    </div>
                    <div class="wrapper__left__body">
                        <div class="header">
                          
                            <div class=headerGrey>
                            </div>
                           
                            <div class="line"></div>
                            <div class="profileWrapper">
                                <div class="today">
                                     TODAY <span class="zero">102</span> | TOTAL <span class="count">12345</span> 
                                </div>
                                
                                <div class="profile">
                                    <i class="fas fa-phone-alt"></i> ID: ${member.m_id}
                                </div>
                                
                                <div class="profile">
                                    <i class="fas fa-envelope"></i> E-mail: ${member.m_email}
                                </div>
                                
                                <div class="profile">
                                    <i class="fas fa-star"></i>
                                </div>
                            </div>
                        </div>
                        <div class="footer">
                            <div class="feelWrapper">
                                <div class="feel">오늘의 기분</div>
                                <select class="feelSelect">
                                    <option>기쁨 😀</option>
                                    <option>슬픔 😭</option>
                                    <option>분노 😡</option>
                                    <option>행복 😊</option>
                                    <option>귀찮 😒</option>
                                </select>
                            </div>
                        </div>
                    </div>
                </div>
                
                
                <div class="wrapper__right">
                    <div class="wrapper__right__header">
                        <div class="wrapper__right__title">사이좋은 사람들, 싸이월드</div>
                      <!--   <div class="wrapper__right__setting">사생활보호설정<i class="fas fa-caret-right bbbb"></i></div> -->
                    </div>
                    
                    <div class="wrapper__right__body">
                        <div>
                       		 <%@include file="home_list_my_modify.jsp" %>
                    	</div>
                    </div>

                    
                </div>
            </div>
        </div>
    </div>
</body>
</html>	