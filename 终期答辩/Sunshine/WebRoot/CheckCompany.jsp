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
		<title>查看企业</title>
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
			<div class="centercontent tables">

				<div class="pageheader notab">
					<h1 class="pagetitle">
						<b>查看企业</b>
					</h1>
				</div>
				<!--pageheader-->

				<div id="contentwrapper" class="contentwrapper">
					<!--contenttitle-->
					<table cellpadding="0" cellspacing="0" border="0" class="stdtable"
						id="dyntable2">
						<colgroup>
							<col class="con0" />
							<col class="con1" />
							<col class="con0" />
							<col class="con1" />
						</colgroup>
						<thead>
							<tr>
								<th class="head0">
									公司名
								</th>
								<th class="head1">
									所属行业
								</th>
								<th class="head0">
									申请时间
								</th>
								<th class="head1">
									操作
								</th>
							</tr>
						</thead>
						<tfoot>
							<tr>
								<th class="head0">
									公司名
								</th>
								<th class="head1">
									所属行业
								</th>
								<th class="head0">
									申请时间
								</th>
								<th class="head1">
									操作
								</th>
							</tr>
						</tfoot>
						<tbody>
							<c:forEach items="${list}" var="u">
								<tr class="gradeX">
									<td>
										${u.company_name }
									</td>

									<td>
										<c:if test="${u.industry=='0'}">
									互联网
									</c:if>
										<c:if test="${u.industry=='1'}">
									金融
									</c:if>
										<c:if test="${u.industry=='2'}">
									电子商务
									</c:if>
										<c:if test="${u.industry=='3'}">
									房地产
									</c:if>
										<c:if test="${u.industry=='4'}">
									餐饮
									</c:if>
										<c:if test="${u.industry=='5'}">
									创业
									</c:if>
									</td>
									<td class="date">
										${u.create_time }
									</td>
									<td>
										<a href="CheckCompanyInfoServlet?id=${u.id }">查看详情</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
				<!--contentwrapper-->
			</div>
			<!-- centercontent -->
		</div>
		<!--bodywrapper-->
	</body>
</html>
