<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>  
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>
<script type="text/javascript">

	function validation(){
		return $("#form").validate({
			rules:{
				account:{
					required:true,
					minlength:2
				},
				pwd:{
					required:true,
					minlength:6
				}
			},
			messages:{
				account:{
					required:"用户名不能为空",
					minlength:"用户名长度最小为{0}"
				},
				pwd:{
					required:"密码不能为空",
					minlength:"密码长度最小为{0}"
				}
			}
		});
	}
	
	//注册验证方法
	$(validation());
	
	$(function(){
		$("#btnSubmit").click(function(){
			if(validation().form()){
				$.ajax({
					type:"post",
					url:"login/"+$("#account").val()+"/"+$("#pwd").val(),
					success:function(data){
						if(data=="success"){
							location.href="router?path=../&fileName=index";
						}else{
							alert(data)
						}
					}
				});
			}
		});
	});
</script>
</head>
	<body>
		<form action="" id="form">
			<table>
				<tr>
					<th>账号：</th>
					<td><input type="text" id="account" name="account"></td>
				</tr>
				<tr>
					<th>密码：</th>
					<td><input type="text" id="pwd" name="pwd"></td>
				</tr>
				<tr>
					<th colspan="2">
						<input type="button" id="btnSubmit" value="提交">
					</th>
				</tr>
			</table>
		</form>
	</body>
</html>