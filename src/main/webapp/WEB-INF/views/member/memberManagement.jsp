<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
$(function(){
	$("delete").click(function(){
		var selectId = $(this).attr("name");
		
		alert(selectId);
		/* 
		location.href="managementDelete?id="; */
	})
});
</script>
</head>
<body>

	<table class="table table-hover">
		<tr>
			<td>아이디</td>
			<td>이름</td>
			<td>생년월일</td>
			<td>주소</td>
			<td>전화</td>
			<td>E-mail</td>
			<td>등급</td>
			<td>가입유형</td>
			<td>가입날짜</td>
			<td>가입승인여부</td>
		</tr>

		<c:forEach items="${list}" var="man">
			<tr>
				<td>${man.id}</td>
				<td>${man.name}</td>
				<td>${man.birth}</td>
				<td>${man.address}</td>
				<td>${man.phone}</td>
				<td>${man.email}</td>
				<td>${man.grade}</td>
				<td>${man.kind}</td>
				<td>${man.joinDate}</td>
				<td>${man.joinState}</td>
				<td><input type="button" id="delete" name="${man.id}" value="X"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>