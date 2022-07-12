<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width", initial-scale="1">
<link rel="stylesheet" href="css/bootstrap.css">
<title>이번 생은 처음이라</title>
</head>
<body>
	<div class="container">
		<div class=:col-lg-4></div>
		<div class=:col-lg-4>
			<div class="jumbotron" style="padding-top:20px;">
				<form method="post" action="joinAction.jsp">
					<h3 style="text-align:center;">회원가입 화면</h3>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="아이디" name="userID" maxlength="20">
					</div>
					<div class="form-group">
						<input type="password" class="form-control" placeholder="비밀번호" name="userPW" maxlength="20">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="이름" name="userName" maxlength="20">
					</div>
					<div class="form-group">
						<input type="text" class="form-control" placeholder="핸드폰번호" name="userPhone" maxlength="20">
					</div>
					<div class="form-group">
						<input type="email" class="form-control" placeholder="이메일"
							name="userEmail" maxlength="20">
					</div>
					<div class="form-check">
						<input class="form-check-input" type="radio" name="userGender" id="flexRadioDefault1" value="남자"  checked>
						<label class="form-check-label" for="flexRadioDefault1" > 남자 </label>
						<input class="form-check-input" type="radio" name="userGender" id="flexRadioDefault2" value="여자"> 
						<label class="form-check-label" for="flexRadioDefault2"> 여자 </label>
					</div>
					<div class="form-group">
						<span class="label label-primary">짧은 소개글</span>
						<input type="text" class="form-control" placeholder="소개글" name="user_Intro" maxlength="200">
					</div>
					<div class="form-check">
						<span class="label label-primary">글 공개 여부</span><br>
						<input class="form-check-input" type="radio" name="user_INFM_YN" id="flexRadioDefault1" value="Y" checked>
						<label class="form-check-label" for="flexRadioDefault1" > 공개 </label>
						<input class="form-check-input" type="radio" name="user_INFM_YN" id="flexRadioDefault2" value="N"> 
						<label class="form-check-label" for="flexRadioDefault2"> 비공개 </label>
					</div>
					
					<input type="submit" class="btn btn-primary form-control" value="회원가입">
				</form>
			</div>
		</div>
		<div class=:col-lg-4></div>
	</div>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>