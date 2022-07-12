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
		<div class="container" style="height:auto;" >
		<div class="row">
			<table class="table">
				<thead>
					<tr>
						<th width=200 style="background-color: #c2f595;">일반 게시판</th>
						<th width=200 style="background-color: #c2f595;">은행 혜택 모음</th>
						<th width=200 style="background-color: #c2f595;">국가 제도 모음</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td>1</td>
						<td>2</td>
						<td>3</td>
						<td>4</td>
						<td>5</td>
						<td>6</td>
					</tr>


				</tbody>
			</table>
		</div>
	</div>
	<%-- Carousel --%>

	<div class="container" style="height:auto; min-height:550px;" >
		<div id="myCarousel" class="carousel slide" data-ride="carousel" style="height:auto; max-height:500;">
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>
			<div class="carousel-inner">
				<div class="item active">
					<a href="bank.jsp"><img src="image/그림1.jpg" height=500 class="img-responsive center-block "/></a>
				</div>
				<div class="item">
					<a href="jedo.jsp"><img src="image/그림2.jpg" height=500 class="img-responsive center-block" /></a>
				</div>			
				<div class="item">
					<a href="view.jsp?boardNO=3&&boardCode=제도"><img src="image/그림3.jpg" height=500 class="img-responsive center-block" /></a>
				</div>			
			</div>				
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span>
			</a>
			<a class="right carousel-control" href="#myCarousel" data-slide="next">
				<span class="glyphicon glyphicon-chevron-right"></span>
			</a>		

		</div>
	</div>


	<%@include file="./includes/footer.jsp" %>
	<script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
	<script src="js/bootstrap.js"></script>
</body>
</html>