<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
		<title>查看公司信息</title>
		<link rel="stylesheet" href="css/style.default.css" type="text/css" />
		<script type="text/javascript" src="js/plugins/jquery-1.7.min.js"></script>
		<script type="text/javascript"
			src="js/plugins/jquery-ui-1.8.16.custom.min.js"></script>
		<script type="text/javascript" src="js/plugins/jquery.cookie.js"></script>
		<script type="text/javascript"
			src="js/plugins/jquery.dataTables.min.js"></script>
		<script type="text/javascript" src="js/plugins/jquery.uniform.min.js"></script>
		<script type="text/javascript" src="js/custom/general.js"></script>
		<script type="text/javascript" src="js/custom/tables.js"></script>
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
							<img height=110px width=100px src="images/thumbs/logo.png" alt="" />
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


			<div class="centercontent">
				<div class="pageheader">
					<div class="profiletitle"></div>
					<!--pageheader-->
					<div id="contentwrapper" class="contentwrapper">
						<div class="two_third last profile_wrapper">
							<div id="profile" class="subcontent">
								<div class="contenttitle2">
									<h3>
										公司基本信息
									</h3>
								</div>
								<!--contenttitle-->

								<!-- 获取从ExamineAccount的账号，并将其flag位改为1，提取相应的信息。 -->
								<div class="profile_about">
									<p>
										公司名称：${company.company_name }
									</p>
									<p>
										所属行业：
										<c:if test="${company.industry=='0'}">
									互联网
									</c:if>
										<c:if test="${company.industry=='1'}">
									金融
									</c:if>
										<c:if test="${company.industry=='2'}">
									电子商务
									</c:if>
										<c:if test="${company.industry=='3'}">
									房地产
									</c:if>
										<c:if test="${company.industry=='4'}">
									餐饮
									</c:if>
										<c:if test="${company.industry=='5'}">
									创业
									</c:if>
									</p>
									<p>
										经营范围：${company.business_scope }
									</p>
									<p>
										公司经度：${company.address_longitude }
									</p>
									<p>
										公司纬度： ${company.address_latitude }
									</p>
								</div>
								<!--recentblog-->
								<br clear="all" />
								<div class="contenttitle2">
									<h3>
										公司照片展示
									</h3>
								</div>
								<!--contenttitle-->
								<ul class="recentshots">
									<c:forEach items="${pathlist}" var="u">
										<li>
											<img width="200px" height="150px" src="${u }" alt="" />
										</li>
									</c:forEach>

								</ul>
								<br clear="all" />
								<div class="contenttitle2">
									<h3>
										公司简介
									</h3>
								</div>
								<!--contenttitle-->
								<div class="recentblog">
									<p>
										${company.introduction }
									</p>
								</div>
								
								<br />
								<br />
							</div>
						</div>
					</div>
				</div>
				<!-- centercontent -->
			</div>
			<!--bodywrapper-->
	</body>
</html>
