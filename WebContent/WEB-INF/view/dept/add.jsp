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
	//定义验证方法
	function validate(){
		return $("#form").validate({
			rules:{
				deptName:{
					required:true,
					minlength:2,
					maxlength:10
				}
			},
			messages:{
				deptName:{
					required:"部门名称不能为空",
					minlength:"部门名称最小长度为{0}个字符",
					maxlength:"部门名称最大长度为{0}个字符"
				}
			}
		});
	}
	
	//注册验证方法
	$(validate());
	
	//实现提交按钮
	$(function(){
		//执行添加操作
		$("#btnSave").click(function(){
			if(validate().form()){
				$.ajax({
					type:"post",
					data:{deptName:$("#deptName").val(),note:$("#note").val()},
					url:"dept",
					success:function(data){
						if(data=="success"){
							if(confirm("部门信息添加成功，是否继续")){
								clear();
							}else{
								location.href="router?path=dept&fileName=list";
							}
						}
					}
					
				});
			}
		});
		//重置按钮重置表单元素
		$("#btnReset").click(function(){
			clear();
		});
		
		$("#btnBack").click(function(){
			if($("#deptName").val()!=""){
				if(confirm("确定要返回上一级么？")){
				window.history.back();	
				}
			}else{
				window.history.back();	
			}
			
		});
		
	});
	
	function clear(){
		$("#deptName").val("");
		$("#note").val("");
	}
</script>
</head>
<body>
	<form id="form">
		<table class="table" width="90%">
			<tr>
				<td><em>*</em>部门名称</td>
				<td><input type="text" id="deptName" name="deptName"></td>
			</tr>
			<tr>
				<td>备注：</td>
				<td><textarea rows="6" cols="100" id="note"></textarea></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="button" id="btnSave" value="保存" />
					<input type="button" id="btnReset" value="清空" />
					<input type="button" id="btnBack" value="返回" />
				</td>
			</tr>
		</table>
	</form>
</body>
</html>