<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<form action="form">
		<table class="table">
			<tr>
				<th><em>*</em>账号：</th>
				<td>
					<input type="text" id="account" name="account">
				</td>
			</tr>
			<tr>
				<th><em>*</em>密码：</th>
				<td>
					<input type="text" id="pwd">
				</td>
			</tr>
			<tr>
				<th><em>*</em>昵称：</th>
				<td>
					<input type="text" id="nikeName">
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="提交" id="btnAdd">
					<input type="button" value="重置"  id="btnReset">
				</td>
			</tr>
		</table>
	</form>
	
	<script type="text/javascript">
		//验证方法
			//定义方法执行表单验证
			function validate(){
			return $("#from").validate({
				rules:{
					account:{
						required:true,
						minlength:2,
						maxlength:10
					}
				},
				message:{
					account:{
						required:true,
						minlength:"至少输入{0}个字符"
					}
				}
			});
		}
	</script>
</body>
</html>