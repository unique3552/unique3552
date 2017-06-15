<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<title>Insert title here</title>

<script type="text/javascript" src="${pageContext.request.contextPath}/resources/script/join.js"></script>

</head>
<body>
	<h2>Member Join</h2>
	<form action="memberJoin" name="frm" id="frm" method="POST" enctype="multipart/form-data">
		<table class="table table-hover" style="width: 300px">
			<tr>
				<td>ID:<input type="text" class="form-control" name="id" id="id" required="required">
				<br><span id="id_result"></span></td>
			</tr>
			<tr>
				<td>PW:<input type="text" class="form-control" name="password" id="pw1">
				<br><p id="pw_result1"></p></td>
			</tr>
			<tr>
				<td>PW Check:<input type="text" class="form-control" id="pw2">
				<br><p id="pw_result2"></p></td>
			</tr>
			<tr>
				<td>NAME:<input type="text" class="form-control" name="name" value="2"></td>
			</tr>
			<tr>
				<td>DATE<input type="date" class="form-control" name="birth" value=1991-03-07></td>
			</tr>
			<tr>
				<td>ADDRESS<input type="text" class="form-control" name="address" value="2"></td>
			</tr>
			<tr>
				<td>PHONE<input type="text" class="form-control" name="phone" value="2"></td>
			</tr>
			<tr>
				<td>EMAIL<input type="email" class="form-control" name="email" value="1@test.com"></td>
			</tr>
			<tr>
				<td>KIND<input type="text" class="form-control" name="kind" value="2"></td>
			</tr>
			<tr>
				<td>GRADE<input type="text" class="form-control" name="grade" value="2"></td>
			</tr>
			<tr>
				<td>IMG<input type="file" class="form-control" name="f1"></td>
			</tr>
		</table>

		<input type="number" name="likes" readonly="readonly" hidden="hidden" value=0>
		<input type="number" name="point" readonly="readonly" hidden="hidden" value=0>
		<input type="number" name="avaliableLikes" readonly="readonly" hidden="hidden" value=0>
		<input type="number" name="joinState" readonly="readonly" hidden="hidden" value=0>

		<input type="button" id="btn" class="btn btn-success" value="가입">
	</form>
	
</body>
</html>