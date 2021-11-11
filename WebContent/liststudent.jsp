<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<base href="${pageContext.request.contextPath }/">
<title>浏览学生</title>

<script type="text/javascript" src="js/jquery-3.6.0.js"></script>
<script type="text/javascript">
		$(function(){
			loadStudentDate();
			$("#btnLoader").click(function(){
				loadStudentDate()
			})
		})
		
		function loadStudentDate(){
			$.ajax({
				url:"student/querystudent.do",
				type:"post",
				dataType:"json",
				success:function(data){
					$("#info").html("");
					$.each(data,function(i,n){
						//相当于拼接成一个append
						$("#info").append("<tr>")
							.append("<td>" + n.name + "</td>")
							.append("<td>" + n.telephone + "</td>")
							.append("<td>" + n.email + "</td>")
							.append("<tr>")
					})
				}
			})
		}
</script>
</head>
<body>
	<div align="center">
		<table border="1px">
			<thead>
				<tr>
					<td>姓名</td>
					<td>电话</td>
					<td>邮箱</td>
				</tr>
			</thead>
			<tbody id="info">
			</tbody>
		</table>
		<input type="button" id="btnLoader" value="查询数据">
	</div>
</body>
</html>