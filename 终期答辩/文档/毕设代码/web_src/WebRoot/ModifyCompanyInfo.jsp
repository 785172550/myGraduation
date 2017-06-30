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
		<title>修改企业信息</title>
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
								<form action="ModifyCompanyInfoServlet?id=${company.id }&companyname=${company.company_name}" method="post"  enctype="multipart/form-data">
									
									<h4><b>您要修改的公司为：<i>${company.company_name}</i></b></h4>
									
									<br>
									<br>
								<center>
								<h3><b>填写修改内容</b></h3>
								<br>
								</br>
								</center>
									<br>
									<b>所属行业：</b>
									<select name="industry" id="industry" >
										<option value="0" selected="selected">
											互联网
										</option>
										<option value="1">
											金融
										</option>
										<option value="2">
											电子商务
										</option>
										<option value="3">
											餐饮
										</option>
										<option value="4">
											房地产
										</option>
										<option value="5">
											创业
										</option>
										<option value="6">
											其他
										</option>
									</select>
									<br />
									<br />
									<b>经营范围：</b>
									<input type="text" name="business_scope" style="width:267px;height=5px"
										id="business_scope" />
									<br />
									<br />
									<b>公司经度：</b>
									<input type="text" name="address_longitude" style="width:267px;height=5px"
										id="address_longitude" />
									<br />
									<br />
									<b>公司纬度：</b>
									<input type="text" name="address_latitude" style="width:267px;height=5px"
										id="address_latitude" />
									<br />
									<br />
									<b>图片展示</b>：
									<input type="file" name="show_image1" id="show_image1"  />
									<br /><br />
									<input type="file" name="show_image2" id="show_image2"  />
									<br /><br />
									<input type="file" name="show_image3" id="show_image3"  />
									<br /><br />
									<b>公司简介：</b>
									<br />
									<textarea id="show_page" name="show_page" rows="15" cols="80">
                        			</textarea>
									<br />
									<br>
										<input type="submit" value="确认修改" style="width:267px;height=5px"/>
									<br>
									<br>
									<br>

								</form>
							</div>
						</div>
					</div>
				</div>
				<!-- centercontent -->
			</div>
			<!--bodywrapper-->
	</body>
</html>
