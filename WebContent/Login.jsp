<%@page import="javax.swing.text.StyledEditorKit.BoldAction"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>论坛</title>
<style type="text/css">
	*{margin: 0px;padding: 0px;}
	input{width:20%;text-align: right;}
</style>
</head>
<body>
	<div>
		<div  style="position:relative;background-color:#dddddd;Height:30px">
			<div style="width:100px;float:right;margin-right: 5%;margin-top: 2px;">	
				<form action="cancel.do">
					<input style="width: 50px" type="submit" value="注销">
				</form>
			</div>	
			<div style="float:left;margin-left:5%;font-size: large;margin-top:4px;">论坛</div>
			<div style="width:350px;float:right;margin-right: 5%;margin-top:4px;">
				<form action="login.do" method="post">
					账号<input type="text" name="username"/>
					密码<input type="password" name="password"/>
					<input style="float:right;" type="submit" value="登录"> 
				</form>
			</div>
		</div>
		
	</div>
</body>
</html>