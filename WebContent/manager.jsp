<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理员主页</title>
<link rel="stylesheet" href="static/layui/css/layui.css">
<link rel="stylesheet"
	href="static/layui/css/modules/layer/default/layer.css">
<style>
html {
	width: 100%;
	height: 100%;
	overflow-x: hidden;
	overflow-y: auto;
}

.right {
	float: right;
}

.layui-nav-tree {
	background-color: #000000;
	position: absolute;
	height: 100%;
}

.layui-nav {
	background-color: #000000;
}

 iframe {
	margin-left: 200px;
	height: 100%;
	width: 100%;
	position:absolute;
} 
 .iframe{
			    height:1500px;
			    height:900px;
			} 
</style>
</head>
<body>
	<!-- 顶部开始 -->
	<ul class="layui-nav ">
		<li class="layui-nav-item"><a href="#"
			style="color: white; font-size: 22px;">管理员管理中心</a></li>

		<li class="layui-nav-item right"><a href=""><img
				src="//t.cn/RCzsdCq" class="layui-nav-img ">我</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="index.jsp">切换信号</a>
				</dd>
				<dd>
					<a href="index.jsp">退出账号</a>
				</dd>
			</dl></li>
	</ul>
	<!-- 顶部结束 -->
	<!-- 中部开始 -->
	<!-- 左侧菜单开始 -->
	<ul class="layui-nav layui-nav-tree" lay-filter="test">
		<li class="layui-nav-item "><a href="javascript:;">用户管理</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="delete_user.jsp" target="zhuti">删除用户</a>
				</dd>
				<dd>
					<a href="chakan_user.jsp" target="zhuti">查看用户</a>
				</dd>
			</dl></li>
		<li class="layui-nav-item"><a href="javascript:;">图书管理</a>
			<dl class="layui-nav-child">
				<dd>
					<a href="add_book.jsp" target="zhuti">增加图书</a>
				</dd>
				<dd>
					<a href="delete_book.jsp" target="zhuti">删除图书</a>
				</dd>
				<dd>
					<a href="modify_book1.jsp" target="zhuti">修改图书</a>
				</dd>
				<dd>
					<a href="chakan_book.jsp" target="zhuti">查看图书</a>
				</dd>
			</dl></li>
	</ul>
	<!-- 左侧菜单结束 -->
	<!-- 右侧主体开始 -->
	<div class="iframe">
		<iframe frameborder="0" name="zhuti"></iframe>
	</div>
	<!-- 右侧主体结束 -->
	<!-- 中部结束 -->
	<script src="static/layui/layui.all.js"></script>
</body>
</html>