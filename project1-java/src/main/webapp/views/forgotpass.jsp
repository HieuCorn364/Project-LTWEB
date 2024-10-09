<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="forgot" method="post">
		<label>Tên Đăng Nhập</label> <input placeholder="tên đăng nhập" name="usernamef">
		<label>Email </label> <input placeholder="email xác nhận đã đăng ký" name="emailf">
		<label>Mật khẩu mới </label> <input placeholder="mật khẩu mới" name="passf">
		<button class="w-100 btn btn-lg btn-primary" type="submit">Quên mật khẩu</button>
	</form>
</body>
</html>