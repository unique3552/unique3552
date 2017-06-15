<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
	<h2>Member Login</h2>
	<form action="memberLogin" method="post">
		<table class="table table-hover" style="width: 300px">
			<tr>
				<td>ID <input type="text" class="form-control" name="id"></td>
			</tr>
			<tr>
				<td>PW <input type="password" class="form-control" name="password"></td>
			</tr>
		</table>
		
		<input class="btn btn-success" type="submit" value="login">
	</form>
</body>
</html>