<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0" />
		<title>增加用户</title>
		<link rel="stylesheet" href="css/style.default.css" type="text/css" />
		<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
		<script type="text/javascript"
			src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
		<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
		<script type="text/javascript" src="js/plugins/jquery.bxSlider.min.js"></script>
		<script type="text/javascript" src="js/custom/general.js"></script>
		<script type="text/javascript" src="js/custom/profile.js"></script>
		<!--[if IE 9]>
    <link rel="stylesheet" media="screen" href="css/style.ie9.css"/>
<![endif]-->
		<!--[if IE 8]>
    <link rel="stylesheet" media="screen" href="css/style.ie8.css"/>
<![endif]-->
		<!--[if lt IE 9]>
	<script src="js/plugins/css3-mediaqueries.js"></script>
<![endif]-->
	</head>
	<body class="withvernav">

		<div class="bodywrapper">
			<div class="topheader">
				<div class="left">
					<h1 class="logo">
						企业信息聚合平台.
						<span>Admin</span>
					</h1>
					<span class="slogan">后台管理系统</span>

					
					<!--search-->
					<br clear="all" />
				</div>
				<!--left-->

				<div class="right">
					<!--<div class="notification">
                <a class="count" href="ajax/notifications.html"><span>9</span></a>
        	</div>-->
					<div class="userinfo">
						<img src="images/thumbs/logo.png"
							style="width: 30px; heith: 23px;" alt="" />
						<span>管理员</span>
					</div>
					<!--userinfo-->

					<div class="userinfodrop">
						<div class="avatar">
							<img height=100px width=100px src="images/thumbs/logo.png" alt="" />
							<div class="changetheme">
								切换主题:
								<br />
								<a class="default"></a>
								<a class="blueline"></a>
								<a class="greenline"></a>
								<a class="contrast"></a>
								<a class="custombg"></a>
							</div>
						</div>
						<!--avatar-->
						<div class="userdata">
							<h4>
								Sunshine
							</h4>
							<span class="email">420625682@qq.com</span>
							<ul>
								<li>
									<a href="dashboard.jsp">编辑资料</a>
								</li>
								<li>
									<a href="dashboard.jsp">账号设置</a>
								</li>
								<li>
									<a href="dashboard.jsp">帮助</a>
								</li>
								<li>
									<a href="index.jsp">退出</a>
								</li>
							</ul>
						</div>
						<!--userdata-->
					</div>
					<!--userinfodrop-->
				</div>
				<!--right-->
			</div>
			<!--topheader-->

			<div class="header">
				<ul class="headermenu">
					<li class="current">
						<a href="dashboard.jsp"><span class="icon icon-flatscreen"></span>首页</a>
					</li>
				</ul>
			</div>
			<!--header-->

			<div class="vernav2 iconmenu">

				<ul>
					<li>
						<a href="#formsub" class="editor">用户管理</a>
						<span class="arrow"></span>
						<ul id="formsub">

							<li>
								<a href="CheckUserServlet">查看</a>
							</li>


							<li>
								<a href="ShowModifyUserServlet">修改</a>
							</li>


							<li>
								<a href="AddUser.jsp">增加</a>
							</li>
							<li>
								<a href="ShowDeleteUserServlet">删除</a>
							</li>
						</ul>
					</li>

					<li>
						<a href="#error" class="error">企业管理</a>
						<span class="arrow"></span>
						<ul id="error">
							<li>
								<a href="CheckCompanyServlet">查看</a>
							</li>
							<li>
								<a href="ShowModifyCompanyServlet">修改</a>
							</li>
							<li>
								<a href="AddCompany.jsp">增加</a>
							</li>
							<li>
								<a href="ShowDeleteCompanyServlet">删除</a>
							</li>
						</ul>
					</li>
					<li>
						<a href="#addons" class="addons">项目管理</a>
						<span class="arrow"></span>
						<ul id="addons">
							<li>
								<a href="CheckProjectServlet">查看</a>
							</li>
							<li>
								<a href="ShowModifyProjectServlet">修改</a>
							</li>
							<li>
								<a href="AddProject.jsp">增加</a>
							</li>
							<li>
								<a href="ShowDeleteProjectServlet">删除</a>
							</li>
						</ul>
					</li>
				</ul>
				<a class="togglemenu"></a>
				<br />
				<br />
			</div>
			<!--leftmenu-->
			<!--header-->

			
			<!--header-->
			<div class="centercontent">
				<div class="pageheader">
					<div class="profiletitle"></div>
					<!--pageheader-->
					<div id="contentwrapper" class="contentwrapper">
						<div class="two_third last profile_wrapper">
							<div id="profile" class="subcontent">
							    <center><h3><b>填写用户注册信息</b></h3>
							    <br>
							    <br>
									<br>
								<form action="AddUserServlet" method="post">
									<b>账号：</b>
									<input type="text" name="username" id="username" style="width:142px;height=5px" />
									<br>
									<br>

									<b>密码：</b> 
									<input type="password" name="password" id="password" style="width:150px;height=20px" />
									<br>
									<br>
									<b>姓名：</b>
									<input type="text" name="name" id="name" style="width:142px;height=20px"/>
									<br>
									<br>
									<b>性别：</b>
									<input type="radio" value="0" name="sex" id="sex" checked="checked" />
									男&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									
									<input type="radio" value="1" name="sex" id="sex" />
									女&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
									<br>
									<br>
									<b>地址：</b>
									<input type="text" name="address" id="address" style="width:142px;height=20px"/>
									<br>
									<br>
									<b>电话：</b>
									<input type="text" name="phonenumber" id="phonenumber" style="width:142px;height=20px"/>
									<br>
									<br>
									<input type="submit" value="添加" style="width:200px;height=211px"/>
								</form>
								</center>
							</div>
						</div>
					</div>
				</div>
				<!-- centercontent -->
			</div>
			<!--bodywrapper-->
	</body>
</html>
