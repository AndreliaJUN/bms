<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>增加图书成功</title>
<link rel="stylesheet" type="text/css" href="static/layui/css/layui.css" />
<script src="static/js/jquery.min.js"></script>
<script type="text/javascript">
			$(document).ready(function(){
				alert("增加图书成功！");
			})
		</script>
		<style>body{
				background-image: url(static/img/olia-gozha-J4kK8b9Fgj8-unsplash.jpg);
				background-size: cover;
				height:100%;
				width: 100%;
				background-repeat: no-repeat;
			}</style>
</head>
<body>
<form class="layui-form" action="addBookServlet" style="text-align: center; margin-top: 300px;width:600px;" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">书名</label>
				<div class="layui-input-block">
					<input type="text" name="book_name" required lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">作者</label>
				<div class="layui-input-block">
					<input type="text" name="author" required lay-verify="required" placeholder="请输入书名" autocomplete="off" class="layui-input">
				</div>
			</div>
<div class="layui-form-item">
				<label class="layui-form-label">ISBN</label>
				<div class="layui-input-block">
					<input type="text" name="ISBN" required lay-verify="required" placeholder="请输入ISBN" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">价格</label>
				<div class="layui-input-block">
					<input type="text" name="price" required lay-verify="required" placeholder="请输入价格" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<input type="text" name="state" required lay-verify="required" placeholder="请输入状态" autocomplete="off" class="layui-input">
				</div>
			</div>
				<div class="layui-form-item">
					<div class="layui-input-block">
						<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
						<button type="reset" class="layui-btn layui-btn-primary">重置</button>
					</div>
				</div>
				</div>
				
		</form>
</body>
</html>