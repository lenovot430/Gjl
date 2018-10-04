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
		//定义验证方法
		function validate(){
			return $("#form").validate({
				rules:{
					deptName:{
						required:true,
						minlength:2,
						maxlength:50
					}
				},
			messages:{
				deptName:{
					required:"部门名称不能为空",
					minlength:"部门名称的最小长度为{0}个字符",
					maxlength:"部门名称的最大长度为{1}个字符"
				}
			}
			});
		}
		//注册验证方法
		$(validate());
		
		//实现提交按钮
		$(function(){
			$.ajax({
				type:"post",
				url:"dept/"+${id},
				data:{_method:"PATCH"},
				success:function(data){
					$("#deptName").val(data.deptName);
					$("#note").val(data.note);
				}
			});
			
			//执行添加操作
			$("#btnSave").click(function(){
				if(validate().form()){
					$.ajax({
						type:"post",
						url:"dept",
						data:{_method:"put",deptId:${id},deptName:$("#deptName").val(),note:$("#note").val()},
						success:function(data){
							if(data=="success"){
								alert("信息修改成功");
								location.href="router?path=dept&fileName=list";
							}
						}
					});
				}
			});
			
			//返回上一级
			$("#btnClose").click(function(){
				if(confirm("您确认要放弃修改吗"))
					window.history.back();
			});
		});
		
		
		/**
		* 清空表单内所有元素的内容
		*/
		function clear(){
			$("#deptName").val("");
			$("#note").val("");
		}
	</script>
</head>
<body>
	<form action="" id="form">
		<table class="table" width="90%">
			<tr>
				<th><em>*</em>&nbsp;部门名称：</th>
				<td><input name="deptName" id="deptName" /></td>
			</tr>
			<tr>
				<th>备注：</th>
				<td><textarea rows="6" cols="100" id="note"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="btnSave" value="保存" />
					<input type="button" id="btnReset" value="清空" disabled="disabled" />
					<input type="button" id="btnClose" value="返回" />
				</td>	
			</tr>
		</table>
	</form>
</body>
</html>