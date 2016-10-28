<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>论坛</title>
</head>
<style type="text/css">
	*{margin: 0px;padding: 0px;}
	a{text-decoration:none;padding-right: 10px;}
</style>
<body>
	<div>
		<div  style="position:relative;background-color:#dddddd;Height:30px">
			<div style="width:50px;float:right;margin-right: 5%;margin-top: 2px;">	
				<form action="/Web/bottom/0.do">
					<input style="width: 30px;" type="submit" value="返回">
				</form>
			</div>	
			<div style="width:50px;float:right;margin-right: 5%;margin-top: 2px;">	
				<form action="/Web/cancel.do">
					<input style="width: 30px;" type="submit" value="注销">
				</form>
			</div>	
			<div style="float:left;margin-left:5%;font-size: large;margin-top:4px;">
				论坛
			</div>
			<div style="float:right;margin-right: 5%;margin-top:4px;">
				<div style="float: right">${username}</div>
				<div style="float:right">欢迎用户：</div>
		  	</div>
	  	</div>
	  	<div>
	  		<form action="reput.do">
	  			帖子名称<input style="display: block;" type="text" name="title"/>
	  			帖子内容<textarea style="display: block;" rows="5" cols="50" name="context"></textarea>
	  			<input style="display: block;" type="submit" value="提交"/>
	  		</form>
	  	</div>
	</div>
</body>
</html>