<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
body {
	font-family: Arial, sans-serif;
	background-color: #f4f4f4;
	display: flex;
	justify-content: center;
	align-items: center;
	height: 100vh;
	margin: 0;
}

.login-container {
	background: #fff;
	padding: 20px;
	border-radius: 8px;
	box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
	width: 300px;
}

.login-container h2 {
	margin: 0 0 20px 0;
}

.login-container input {
	width: 100%;
	padding: 10px;
	margin: 5px 0;
	border: 1px solid #ddd;
	border-radius: 4px;
}

.login-container input[type="submit"] {
	background-color: #28a745;
	color: #fff;
	border: none;
	cursor: pointer;
}

.login-container input[type="submit"]:hover {
	background-color: #218838;
}
</style>
</head>
<body>
	<div class="login-container">
		<h2>Đăng Nhập</h2>
		<form action="login" method="post">
			<label for="username">Tài khoản:</label> 
				<input type="text" id="username" name ="username" required> 
			<label for="password">Mật khẩu:</label> 
				<input type="password" id="password" name="password" required> 
			<input type="submit" value="Đăng Nhập">
		</form>
	</div>
</body>
</html>

