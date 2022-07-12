
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
	<script>
	alert("로그인을 해주세요 !");
	history.back();
	</script>
 --%>

	<div class="container">
		<div class="row">
		<form method="post" action="writeAction.jsp" enctype="multipart/form-data" >
		
			<table class="table table-striped" style="text-align: center; border: 1px solid #dddddd">
			
				<thead>
					<tr>
						<th colspan="2" style="background-color:#eeeeee; text-align:center;">게시판 글쓰기 양식</th>
					</tr>
				</thead>
				
				<tbody>
					<tr>
						<td><input type="text" class="form-control" placeholder="글 제목" name="boardTitle" maxlength="50"> </td>
					</tr>

					<tr>
						<td><input type="text" class="form-control" placeholder="주최" name="provider" maxlength="50" value="제도 주최" > </td>
					</tr>

					<tr>	
						<td><textarea type="text" class="form-control" placeholder="글 내용" name="boardContent" maxlength="2048" style="height:350px;" ></textarea></td>
					</tr>
					<tr>	
						<td><input type="file" name="fileName"><input type=hidden name="boardCode"></td>
						
					</tr>
					
					</tbody>
			</table>
			<input type="submit" class="btn btn-primary pull-right" value="글쓰기">
		</form>

		</div>
	</div>
	<br><br><br>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>