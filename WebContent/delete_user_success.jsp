<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>删除用户成功</title>
		<link rel="stylesheet" href="static/layui/css/layui.css">
		<script type="text/javascript" src="static/js/jquery.min.js"></script>
		<style type="text/css">
		body{
				background-image: url(static/img/olia-gozha-J4kK8b9Fgj8-unsplash.jpg);
				background-size: cover;
				height:100%;
				width: 100%;
				background-repeat: no-repeat;
			}
			form{
				margin-top: 350px;width:600px;
				
			}
			/* input{
				width: 200px;
			} */
		</style>
		<script type="text/javascript">
			$(document).ready(function(){
				alert("删除用户成功！");
			})
		</script>
</head>
<body>
<form class="layui-form" action="deleteUserServlet" style="text-align:center;margin-left:100px;margin-top:350px;" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">名字</label>
				<div class="layui-input-block">
					<input type="text" name="user_name" required lay-verify="required" placeholder="请输入要删除的用户的名字" autocomplete="off" class="layui-input" style="width: 300px;">
				</div>
				</div>
				 <div class="layui-form-item">
    <div class="layui-input-block">
      <button class="layui-btn" lay-submit lay-filter="formDemo">删除</button>
      <button type="reset" class="layui-btn layui-btn-primary">重置</button>
    </div>
  </div>
		</form>

<div style="margin-top:100px;margin-left:300px"><p style="font-size:30px;font-style:italic;font-weight:lighter;">黑发不知勤学早，白首方悔读书迟。</p></div>
        <div  style="margin-top:60px;margin-left:700px"><p  style="font-size:30px;font-style:italic;font-weight:lighter;"> ———— 颜真卿</p></div>
</body>
</html>