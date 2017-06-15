<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
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
<style type="text/css">
.profile{
	width: 200px;
	height: 200px;
}
</style>
<script type="text/javascript">
$(function(){
	$("#update").click(function(){
		location.href="memberUpdate";
	});

	$("#delete").click(function(){
		location.href="memberDelete";
	});

	$("#management").click(function(){
		location.href="memberManagement";
	});
	
	$("#home").click(function(){
		location.href="../";
	});
});
</script>
</head>
<body>
	<h2>Member View</h2>
	<input type="text" name="id" value="${memberDTO.kind}" readonly="readonly">
	<h3>ID : ${memberDTO.id}</h3>
	<h3>NAME : ${memberDTO.name}</h3>
	<h3>PHONE : ${memberDTO.phone}</h3>
	<h3>IMG</h3>

	<c:if test="${memberDTO.getFname() ne ' '}">
		<p><img class="profile" src="${pageContext.request.contextPath}/resources/upload/member/${memberDTO.fname}"></p>
	</c:if>

	<c:if test="${memberDTO.getFname() eq ' '}">
		<p>사진이 없습니다.</p>
	</c:if>

	<div>
		<input type="button" class="btn btn-warning" value="UPDATE" id="update">
		<input type="button" class="btn btn-danger" value="DELETE" id="delete">

		<c:if test="${memberDTO.getKind() eq '관리자'}">
			<input type="button" class="btn btn-info" value="MANAGEMENT" id="management">
		</c:if>
		
		<input type="button" class="btn btn-success" value="HOME" id="home">
	</div>
</body>
</html>