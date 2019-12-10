<%@ page language="java" import="DataClass.Book" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>借阅图书</title>
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
  Book book=(Book)request.getAttribute("book");

%>
<table class="table">
	<caption>查找到该书</caption>
	<thead>
		<tr>
			<th>书名</th>
			<th>作者</th>
			<th>ISBN</th>
			<th>价格</th>
			<th>状态</th>
		</tr>
	</thead>
	<tbody>
		<tr class="active">
			<td><%=book.getBook_name() %></td>
			<td><%=book.getBook_author() %></td>
			<td><%=book.getBook_ISBN()%></td>
			<td><%=book.getBook_price() %></td>
			<td><%=book.getBook_state() %></td>
		</tr>
		
	</tbody>
</table>
<form action="borrowBookServlet2" method="post">
	<lable>是否要借该书？</lable>
    <label>
        <input type="radio" name="jieshu" id="optionsRadios1" value="yes"> 是
    </label>


   
	<button class="layui-btn" lay-submit lay-filter="formDemo">提交</button>
</form>
</body>
</html>