<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript" src="js/jquery.validate.min.js"></script>

	<script type="text/javascript">
		$(function(){
			$(drop());
			$(select());
			
			//提交数据
			$("#btnSave").click(function(){
				alert($("#deptId").val());
				$.ajax({
					type:"post",
					url:"user",
					data:{_method:"put",userId:${id},userName:$("#userName").val(),account:$("#account").val(),pwd:$("#pwd").val(),
						deptId:$("#deptId").val(),tel:$("#tel").val(),role:$("#role").val(),state:$("#state").val()	
					},
					success:function(data){
						if(data="success"){
							location.href="router?path=user&fileName=list";
						}
					}
				});	
			});
			$("#btnBack").click(function(){
				window.history.back();
			});
			
		});
		
		//执行数据下拉框的绑定
		function drop(){
			$.ajax({
				type:"get",
				url:"dept",
				success:function(data){
					var html="";
					for(var i=0;i<data.length;i++){
						var obj=data[i];
						html+="<option value='"+obj.deptId+"'>"+obj.deptName+"</option>"
					}
					$().append("<option value='0'>--请选择--</option>");
					$("#deptId").append(html);
				}
			});
		}
		
		//执行数据信息的查询（按照Id）
		function select(){
			$.ajax({
				type:"PATCH",
				url:"user/"+${id},
				success:function(data){
					$("#userName").val(data.userName);
					$("#account").val(data.account);
					$("#pwd").val(data.pwd);
					$("#deptId").val(data.deptId);
					$("#tel").val(data.tel);
					$("#role").val(data.role);
					$("#state").val(data.state);
				}
			});
		}
	</script>
</head>
<body>
	<form action="" id="form">
		<table>
				<tr>
					<th>用户名：</th>
					<td><input id="userName"></td>
				</tr>
				<tr>
					<th>账号：</th>
					<td><input id="account"></td>
				</tr>
				<tr>
					<th>密码：</th>
					<td><input id="pwd"></td>
				</tr>
				<tr>
					<th>部门：</th>
					<td>
						<select id="deptId">
						</select>
					</td>
				</tr>
				<tr>
					<th>手机号：</th>
					<td><input id="tel"></td>
				</tr>
				<tr>
					<th>角色：</th>
					<td>
						<select id="role">
							<option value="staff">普通用户</option>
							<option value="admin">管理员</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>状态：</th>
					<td>
						<select id="state">
							<option value="1">在职</option>
							<option value="2">停职</option>
							<option value="3">离职</option>	
						</select>
					</td>
				</tr>
				<tr>
					<th><input type="button" id="btnSave" value="保存" /></th>
					<th><input type="button" id="btnBack" value="返回" /></th>
				</tr>
		</table>
	</form>
</body>
</html>