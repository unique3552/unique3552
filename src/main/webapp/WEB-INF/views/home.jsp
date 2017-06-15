<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
	<title>Home</title>
<script type="text/javascript">
	var message = '${message}';
	if(message != ''){
		alert(message);
	}
</script>
</head>
<body>
<h1>
	Hello world!  
</h1>
<P>  The time on the server is ${serverTime}. </P>

<c:if test="${memberDTO eq null }">
	<p><a class="btn btn-primary" href="./member/memberJoin">JOIN</a></p>
	<p><a class="btn btn-success" href="./member/memberLogin">LOGIN</a></p>
</c:if>

<c:if test="${memberDTO ne null }">
	<p>${memberDTO.name}</p>
	<p><a class="btn btn-warning" href="./member/memberLogout">Logout</a></p>
	<p><a class="btn btn-info" href="./member/memberView">View</a></p>
</c:if>

</body>
</html>
