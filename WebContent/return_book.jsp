<%@ page language="java" import="DAO.RecordDao,DataClass.Record,DataClass.User,java.util.ArrayList,java.util.List" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>还书</title>
<link rel="stylesheet" href="static/layui/css/layui.css">
<link rel="stylesheet" href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css">  
	<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
<style>body{
				background-image: url(static/img/olia-gozha-J4kK8b9Fgj8-unsplash.jpg);
				background-size: cover;
				height:100%;
				width: 100%;
				background-repeat: no-repeat;
			}</style>
</head>
<body>
<%
User user=(User)this.getServletContext().getAttribute("user");

 String user_name=user.getUser_name();
 
 RecordDao dao=new RecordDao();
 List<Record>rcd=new ArrayList<Record>();
 rcd=dao.Find(user_name);
 %>
 <table class="table">
	<caption>借阅记录</caption>
	<thead>
		<tr>
			<th>书名</th>
			<th>ISBN</th>
			<th>用户</th>
			<th>借书时间</th>
			<th>还书时间</th>
			<th>还书状态</th>
			
		</tr>
	</thead>
	<tbody>
	<%for(Record r:rcd){ %>
		<tr class="active">
		
			<td><%=r.getBook_name() %></td>
			<td><%=r.getBook_ISBN() %></td>
			<td><%=r.getUser_name() %></td>
			<td><%=r.getBorrow_date() %></td>
			<td><%=r.getReturn_date() %></td>
			<td><%=r.gethuan() %></td>
		</tr>
		<% }%>
	</tbody>
</table>
<form class="layui-form" action="returnBookServlet" method="post" style="text-align:center; margin-top: 30px;margin-left:10px; width:480px;">
			<div class="layui-form-item">
				<label class="layui-form-label">书号ISBN</label>
				<div class="layui-input-block">
					<input type="text" name="ISBN" required lay-verify="required" placeholder="请输入所还图书的书号ISBN" autocomplete="off" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="formDemo">归还</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</form>
		
</body>
</html>