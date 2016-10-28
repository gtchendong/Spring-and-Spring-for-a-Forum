<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@page import="com.chen.bean.model.Reply"%>
<%@page import="java.util.List"%>
<%@page import="java.text.SimpleDateFormat" %>
<%@page import="java.sql.Date" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>论坛</title>
<style type="text/css">
	*{margin: 0px;padding: 0px;}
	a{text-decoration:none;padding-right: 10px;}
	.date{font-size:10px;text-align:right;}
	.title{font-size:10px}
	.context{}
</style>
</head>
<body>
	<div>
		<div  style="position:relative;background-color:#dddddd;Height:30px">
			<div style="width:100px;float:right;margin-right: 5%;margin-top: 2px;">	
				<form action="/Web/bottom/0.do">
					<input style="width: 50px" type="submit" value="返回首页">
				</form>
			</div>	
			<div style="width:100px;float:right;margin-right: 5%;margin-top: 2px;">	
				<form action="/Web/cancel.do">
					<input style="width: 50px" type="submit" value="注销">
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
		<div style="width:70%;margin:0 auto;">
			<%for(Object ms:(List<?>)request.getAttribute("reply")){
				Reply re=(Reply)ms;
				out.write("<div class=\"title\">");
				out.write(re.getTitle());
				out.write("</div>");
				out.write("<div id=\"context\">");
				out.write(re.getContext());
				out.write("</div>");
				out.write("<div class=\"date\">");
				out.write(re.getUsername());
				out.write("</div>");
				pageContext.setAttribute("title",re.getTitle());
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd,HH:mm:ss");
				out.write("<div class=\"date\">");
				out.write(sdf.format((Object)re.getDatetime()));
				out.write("</div>");
				out.write("<div style=\"width:100%;border-bottom:1px solid #eeeeee;margin: 0 auto;\"></div>");
				out.write("<br/>");
			}%>
		</div>
		<div>
			<div style="width:70%;margin:0 auto;">
				<form action="/Web/reply/replymessage.do" method="get">
					<label><%=pageContext.getAttribute("title")%></label>
					<br>
					<input type="hidden" name="title" value=<%=pageContext.getAttribute("title")%>>
					<br>
					<textarea rows="9" cols="100" name="context"></textarea>
					<br>
					<input type="submit" value="提交"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>