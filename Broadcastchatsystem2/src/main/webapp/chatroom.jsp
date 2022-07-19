<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.*"  %>
<%@page import="com.broadcast.bean.ChatroomBean" %>
<%@page import="com.broadcast.database.LoginDao" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css">  
</head>
<body>
<h1>Chat Room</h1>
<div>
<div class="container" >
<div style="background-color:yellow; height:300px;">
<p class="center" style="text-align:center;"> hello <span id="chatname"></span></p>
<p id="chatbox"><p>hello</p>
<table>
<% 
List<ChatroomBean> users=(List<ChatroomBean>)session.getAttribute("messageslist");
for(ChatroomBean chat:users){
	%>
	<tr><td><%=chat.getSender() %>:<%= chat.getMessage() %></td></tr>
<%	
}
%>
</p>
</table>
</div>
<form id="form" action="chatroom" method="post">  
              <div class="form-group">   
                <input type="text" class="form-control text" id="message" name="message" placeholder="Write message">  
                <!-- <small id="emailHelp" class="form-text text-muted"> We'll never share your email with anyone else. </small>   -->
              </div>
		<button type="submit" class="btn btn-primary forbutton" id="submit" > send </button>
</form>
</div>
</div>
</body>
</html>