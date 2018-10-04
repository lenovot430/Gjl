<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>
	<script type="text/javascript">
		$(function(){
			
			/*测试使用字符串类型返回值*/
			
			$("#btnTest1").click(function(){
				
				$.ajax({
					
					type:"get",

					url:"test1",
					
					success:function(data){
						
						alert(data);
						
					}
					
				});
				
			});
			
			/*测试集合对象的返回值类型，Patch方法*/
			$("#btnTest2").click(function(){
				
				$.ajax({
					
					type:"post",
					
					url:"user",
					
					data:{_method:"patch"},
					
					success:function(data){
						
						alert(data);
						
					}
					
					
				});
				
			});
			
			/*测试提交处理，post方法*/
			$("#btnTest3").click(function(){
				
				$.ajax({
					
					type:"post",
					
					url:"user",
					
					data:{id:1,name:"Tom",gender:"true",tel:"6666666"},
					
					success:function(data){
						
						alert(data);
						
					}
					
				})
				
			});
			
			/*测试删除处理，delete方法*/
			$("#btnTest4").click(function(){
				
				$.ajax({
					
					type:"delete",
					
					url:"user/2",
					
					success:function(data){
						
						alert(data);
					}
					
				});
				
				
			});
			
			/*测试更新。put方法*/
			$("#btnTest5").click(function(){
				
				$.ajax({
					
					type:"post",
					
					url:"user",
					
					data:{_method:"put",id:"2",name:"Jerry",gender:"true",tel:"888888888"},
					
					success:function(data){
						
						alert(data);
						
					}
					
				})
				
			});
			
			/*测试按照Id查询数据，get方法*/
			$("#btnTest6").click(function(){
				
				$.ajax({
					
					type:"get",
					
					url:"user/56",
					
					success:function(data){
						
						alert(data);
						
					}
					
				});
				
			});
			
		});
	</script>
</head>
<body>

	<input type="button" id="btnTest1" value="test test">
	<input type="button" id="btnTest2" value="test list(method)">
	<input type="button" id="btnTest3" value="test add(post method)">
	<input type="button" id="btnTest4" value="test delete(delete method)">
	<input type="button" id="btnTest5" value="test update(put method)">
	<input type="button" id="btnTest6" value="test getById(get method)">

</body>
</html>