
<%@page import="java.io.PrintWriter"%>
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

	<div class="well"> "갱우"님의 댓글 목록입니다.</div>
	
		<div class="container" style="height:auto; min-height:750px;">
		<div class="row">
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
				<thead>
					<tr>
						<th width=100 style="background-color:#eeeeee; text-align:center ;">게시판</th>
						<th width=400 style="background-color:#eeeeee; text-align:center ;">댓글내용</th>
						<th width=100 style="background-color:#eeeeee; text-align:center ;">작성일</th>
					</tr>
					
				</thead>
				<tbody>

					<tr>
						<td>게시글 번호</td>
						<td>게시글 내용</td>
						<td align="left">댓글 내용</td>
						<td>댓글 작성 날짜</td>
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