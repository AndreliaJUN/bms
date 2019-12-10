<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="static/layui/css/layui.css">
		<link rel="stylesheet" href="static/layui/css/modules/layer/default/layer.css">
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
 
		</style>
</head>
<body>
<% %>
<!-- 顶部开始 -->
		<ul class="layui-nav ">
			<li class="layui-nav-item">
				<a href="#" style="color: white;font-size: 22px;">个人中心</a>
			</li>
			
			<li class="layui-nav-item right">
				<a href=""><img src="//t.cn/RCzsdCq" class="layui-nav-img ">我</a>
				<dl class="layui-nav-child">
					<dd><a href="index.jsp">切换信号</a></dd>
					<dd><a href="index.jsp">退出账号</a></dd>
				</dl>
			</li>
		</ul>
		<!-- 顶部结束 -->
		<!-- 中部开始 -->
		<!-- 左侧菜单开始 -->
		<ul class="layui-nav layui-nav-tree" lay-filter="test" id="nav-bar">
			<li class="layui-nav-item ">
				<a href="borrow_book.jsp" target="zhuti">借阅图书</a>
				
			</li>
			<li class="layui-nav-item">
				<a href="return_book.jsp" target="zhuti">归还图书</a>
				
			</li>
			<li class="layui-nav-item">
				<a href="yuyue_book.jsp" target="zhuti">预约图书</a>
				
			</li>
			<li class="layui-nav-item">
				<a href="reborrow_book.jsp" target="zhuti">续借图书</a>
				
			</li>
			<li class="layui-nav-item">
				<a href="already_borrow.jsp" target="zhuti">借阅信息</a>
				
			</li>
		</ul>
		<!-- 左侧菜单结束 -->
		<!-- 右侧主体开始 -->
		<div class="iframe">
		<iframe frameborder="0" name="zhuti" ></iframe>
		</div>
		<!-- 右侧主体结束 -->
		<!-- 中部结束 -->
		<script src="static/layui/layui.all.js"></script>
</body>
</html>