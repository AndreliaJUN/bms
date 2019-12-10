<%@ page language="java"  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>注册页面</title>
<link rel="stylesheet" href="static/css/bootstrap.min.css">
		<script src="static/js/jquery.min.js"></script>
		<script src="static/js/bootstrap.min.js"></script>
		<style>
			body{
				background-image: url(static/img/background.jpg) ;
				height:100%;
				width: 100%;
				background-repeat: no-repeat;
				background-size: cover;
			}
			.page-container {
				margin: 250px auto 0 auto;
				background: rgba(0,0,0,.5);
				width: 600px;
				height: 500px;
			}
			h2 {
				font-size: 30px;
				font-weight: 700;
				text-shadow: 0 1px 4px rgba(0,0,0,.9);
				padding-top: 60px;
				color: white;
				text-align: center;
			}
			input {
				
				width: 400px;
				height: 50px;
				margin-top: 40px;
				padding: 0 15px;
				background: rgba(45,45,45,.3);
				border-radius: 6px;
				border: 1px solid #3d3d3d;
				border: 1px solid rgba(255,255,255,.25);
				box-shadow: 0 2px 3px 0 rga(0, 0, 0, .7)inset;
				font-family: sans-serif;
				font-size: 16px;
				color: #fff;
				text-shadow: 0 1px 2px rgba(0,0,0,.5);
			}
			 input:-moz-placeholder {
			color: #fff;
			}
			 input:-ms-input-placeholder {
			color: #fff;
			}
			 input:-webkit-input-placeholder {
			color: #fff;
			}
			input:focus {
				outline: none;
				-moz-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				-webkit-box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				box-shadow: 0 2px 3px 0 rgba(0,0,0,.1) inset, 0 2px 7px 0 rgba(0,0,0,.2);
			}
			
			button {
				cursor: pointer;
				width: 300px;
				height: 50px;
				margin-top: 50px;
				padding: 0;
				background: #ef4300;
				-moz-border-radius: 6px;
				-webkit-border-radius: 6px;
				border-radius: 6px;
				border: 1px solid #ff730e;
				-moz-box-shadow: 0 15px 30px 0 rgba(255,255,255,.25) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				-webkit-box-shadow: 0 15px 30px 0 rgba(255,255,255,.25) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				box-shadow: 0 15px 30px 0 rgba(255,255,255,.4) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				font-family:  Arial, sans-serif;
				font-size: 14px;
				font-weight: 700;
				color: #fff;
				text-shadow: 0 1px 2px rgba(0,0,0,.1);
				-o-transition: all .2s;
				-moz-transition: all .2s;
				-webkit-transition: all .2s;
				-ms-transition: all .2s;
			}
			
			button:hover {
				-moz-box-shadow: 0 15px 30px 0 rgba(255,255,255,.15) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				-webkit-box-shadow: 0 15px 30px 0 rgba(255,255,255,.15) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				box-shadow: 0 15px 30px 0 rgba(255,255,255,.15) inset, 0 2px 7px 0 rgba(0,0,0,.2);
			}
			button:active {
				-moz-box-shadow: 0 15px 30px 0 rgba(255,255,255,.15) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				-webkit-box-shadow: 0 15px 30px 0 rgba(255,255,255,.15) inset, 0 2px 7px 0 rgba(0,0,0,.2);
				box-shadow: 0 5px 8px 0 rgba(0,0,0,.1) inset, 0 1px 4px 0 rgba(0,0,0,.1);
				border: 0px solid #ef4300;
			}
			.register{
				margin-top: 25px;
				text-align: center;
			}
			span{
				color: #C0C0C0;
			}
		</style>
</head>
<body>
<div class="page-container">
			<h2>欢迎来到图书管理系统</h2>
			<form action="registerServlet" method="post" style="text-align: center;">
				<span class="glyphicon glyphicon-user"></span>&nbsp;
				<input type="text" name="name" class="username" placeholder="请输入用户名">
				<br>
				<span class="glyphicon glyphicon-lock"></span>
				<input type="password" name="password" class="password" placeholder="请输入密码">
				<br>
				<div class="button" style="text-align: center;"> <button type="submit">register</button></div>
				
			</form>
		</div>

</body>
</html>