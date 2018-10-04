<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<base href="<%=basePath%>">
<meta charset="utf-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="css/style.css" />
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
<script type="text/javascript">

	$(function(){
		//页面加载成功后加载数据列表
		flush();
		
		//查询的单击事件
		$("#btnFind").click(function(){
			$.ajax({
				type:"get",
				url:"dept/"+$("#txtName").val(),
				success:function(data){
					binData(data);
				}
			});
		});
	});
	
	//封装查询数据
	function flush(){
		$.ajax({
			type:"get",
			url:"dept",
			success:function(data){
				binData(data);
			}
		});
	}
	
	
	//将数据绑定到Table表格
	function binData(data){
				var html="";
				if(data.length<1){
					html="<tr><td colspan='4'>未查询到任何数据</td></tr>"
						$("#data").html(html);
				}else{
					for(var i=0;i<data.length;i++){
						var obj=data[i];
						html+="<tr><td><input type='checkbox'></td>";
						html+="<td>"+obj.deptName+"</td>";
						html+="<td>"+obj.note+"</td>";
						html+="<td><a href='javascript:void(0)' onclick='del("+obj.deptId+")'>删除</a>";
						html+= "&nbsp;<a href='javascript:void(0)' onclick='edit("+obj.deptId+")'>修改</a></td></tr>";
					}
					$("#data").html(html);
				}
	}
	
	//执行部门信息修改
	function edit(id){
		//这个是我自己写的跳转
		//href='jumps/"+obj.deptId+"?path=dept&fileName=update' 
		location.href="router?path=dept&fileName=edit&id="+id;
	}
	
	
	//执行部门信息删除
	function del(id){
		var uri="dept/"+id;
		$.ajax({
			type:"delete",
			url:uri,
			success:function(data){
				flush();
			}
		});
	}
	
</script>
</head>

<body>
	<a href="router?path=dept&fileName=add">添加</a>
	<div class="search">
		部门名称：<input id="txtName">
		<input type="button" id="btnFind" value="查询">	
	</div>
	<table class="grid">
		<thead>
			<tr>
				<th><input type="checkbox" id="chkAll"></th>
				<th>部门名称</th>
				<th>说明</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="data"></tbody>
	</table>
</body>
</html>