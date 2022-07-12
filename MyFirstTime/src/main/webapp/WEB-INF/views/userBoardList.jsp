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
	<%--
		공개 안했으면 다 못보고 공개 불가여도 본인은 가능
		<script>
			alert("공개를 허용하지 않은 회원입니다");
			history.back();
		</script> 
	--%>
		
	
	<div class="well"> 갱우님의 게시글 목록입니다.</div>
		<div class="container" style="height:auto; min-height:750px;">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th width=150 style="background-color:#eeeeee; text-align:center ;">게시판이름</th>
						<th width=100 style="background-color:#eeeeee; text-align:center ;">번호</th>
						<th width=350 style="background-color:#eeeeee; text-align:center ;">제목</th>					
						<th width=100 style="background-color:#eeeeee; text-align:center ;">작성자</th>
						<th width=100 style="background-color:#eeeeee; text-align:center ;">작성일</th>
					</tr>
					
				</thead>
				<tbody>

					<tr>
						<td>글번호</td>
						<td align="left">글이름(댓글수)	</td>
						<td>조회수</td>
						<td>작성자</td>
						<td>작성일</td>
					</tr>	

				</tbody>
			</table>
			<div align="center">

			</div>
			홈으로	댓글 목록
		</div>
	</div>
	<br><br><br>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>