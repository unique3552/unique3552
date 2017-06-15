<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">
$(function(){	
	$("#delete").click(function(){
		var selectId = $(".selectId${memberDTO.id}").values();
		
		alert(selectId);
		/* 
		location.href="managementDelete?id="; */
	});
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
			<td>가입승인여부</td>
		</tr>
		<c:forEach items="${list}" var="memberDTO">
			<tr>
				<td>${memberDTO.id}</td>
				<td>${memberDTO.name}</td>
				<td>${memberDTO.birth}</td>
				<td>${memberDTO.address}</td>
				<td>${memberDTO.phone}</td>
				<td>${memberDTO.email}</td>
				<td>${memberDTO.grade}</td>
				<td>${memberDTO.kind}</td>
				<td>${memberDTO.joinDate}</td>
				<td>${memberDTO.joinState}</td>
				<td><input type="button" id="delete" name="${memberDTO.id}" value="X"></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>