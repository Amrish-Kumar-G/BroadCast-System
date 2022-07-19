<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"  %>
<%@page import="com.broadcast.bean.ChatroomBean" %>
<%@page import="com.broadcast.database.LoginDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Success</title>
</head>
<body>
<table>
<% 
List<ChatroomBean> users=(List<ChatroomBean>)session.getAttribute("messageslist");
for(ChatroomBean chat:users){
	%>
	<tr><td><%=chat.getSender() %><%= chat.getMessage() %></td></tr>
<%	
}
%>
</table>
<div align="center">
<h1>success.....</h1>

</div>
</body>
</html>