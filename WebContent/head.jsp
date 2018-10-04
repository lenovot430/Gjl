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
	$(function(){
		$("#btnOut").click(function(){
			$.ajax({
				type:"post",
				url:"logout",
				success:function(data){
					if(data="success"){
						window.top.location.href="router?path=..&fileName=login"
					}
				}
			});
		});
	});
</script>
</head>
	<body>
		欢迎您，${user.userName }<br/>
		<br/>
		<a id="btnOut" href="#">注销</a>
	</body>	
</html>