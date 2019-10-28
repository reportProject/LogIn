<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="sec"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet" media="screen">
<script
	src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h1>학생 첫 페이지</h1>
		<hr />

		<table class="table table-bordered" style="width: 500px;">
			<tr>
				
				<td>로그인ID</td>
				<td><sec:authentication property="student.studentId" /></td>
			</tr>
			<tr>
				<td>이름</td>
				<td><sec:authentication property="student.student_name" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><sec:authentication property="student.student_email" /></td>
			</tr>
		</table>
		<!-- "user/logout_processing" 부분은, SecurityConfig.java 에서 설정한, 로그아웃 처리 URL과 일치해야 한다. -->
		<a class="btn btn-default" href="logout_processing">로그아웃</a>
	</div>
</body>
</html>
