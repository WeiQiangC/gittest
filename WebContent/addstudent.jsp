<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册学生</title>
<base href="${pageContext.request.contextPath }/">
</head>
<body>
	<div align="center">
		<form action="student/addStudent.do">
			<table>
				<tr>
					<td>姓名:</td>
					<td><input type="text" name="name"></td>
				</tr>
				<tr>
					<td>电话</td>
					<td><input type="text" name="telephone"></td>
				</tr>
				<tr>
					<td>邮箱</td>
					<td><input type="text" name="email"></td>
				</tr>
				<tr>
					<td><input type="submit" value="注册"></td>
				</tr>
			</table>
		</form>
	</div>
</body>
</html>