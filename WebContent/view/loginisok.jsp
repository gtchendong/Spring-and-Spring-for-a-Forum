<%@page import="com.chen.bean.service.TestService"%>
<%@page import="org.springframework.web.context.support.WebApplicationContextUtils"%>
<%@page import="org.springframework.context.ApplicationContext"%>
<%@page import="com.chen.bean.model.Message"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>论坛</title>
<style type="text/css">
	*{margin: 0px;padding: 0px;}
	a{text-decoration:none;padding-right: 10px;}
</style>
</head>
<body>
	<div>
		<div  style="position:relative;background-color:#dddddd;Height:30px">
			<div style="width:50px;float:right;margin-right: 5%;margin-top: 2px;">
				<form  action="/Web/register.do">
					<input style="width: 30px;" type="submit" value="发帖" >
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
		<div style="width: 960px;margin:0 auto;background-color:#ffffff;">
			<%for(Object ms:(List<?>)session.getAttribute("list")){
				Message me=(Message)ms;
				out.write("<div>");
				out.write("<div style=\"float:right;width:10%;margin-top: 40px\"><a href=\"middle/"+me.getUsername()+".do\">");
				out.write(me.getUsername());
				out.write("</a></div>");
				out.write("<div style=\"width:100%;border-bottom:1px solid #eeeeee;margin: 0 auto;\"></div>");
				out.write("<div style=\"float:right;width:70%;margin-top: 40px\" ><a href=\"middle/"+me.getTitle()+".do\">");
				if(me.getContext().length()<=10){
					out.write(me.getContext());
				}else{
					out.write(me.getContext().substring(0, 10));
				}
				out.write("</a></div>");
				out.write("<div style=\"width:100%;border-bottom:1px solid #eeeeee;margin: 0 auto;\"></div>");
				out.write("<div style=\"float:right;width:20%;margin-top: 40px\"><a href=\"middle/"+me.getTitle()+".do\">");
				out.write(me.getTitle());
				out.write("</a></div>");
				out.write("</div>");
				out.write("<div style=\"clear:both\"></div>");
			 }%>
		</div>
		<div>
			<div style="width:300px;margin:0 auto;"><a href=<%=request.getContextPath()+"/bottom/0.do"%>>首页</a>&lt;<a href=<%=request.getContextPath()+"/bottom/1.do"%>><%=(int)session.getAttribute("pageid")%></a><a href=<%=request.getContextPath()+"/bottom/2.do"%>><%=(int)session.getAttribute("pageid")+1%></a><a href=<%=request.getContextPath()+"/bottom/3.do"%>><%=(int)session.getAttribute("pageid")+2%></a><a href=<%=request.getContextPath()+"/bottom/4.do"%>><%=(int)session.getAttribute("pageid")+3%></a>&gt;<div style="display: inline;">共记<%=session.getAttribute("pagelast") %>条,<%=(int)session.getAttribute("pagelast")/10+1%>页</div></div>
		</div>
	</div>
</body>
</html>