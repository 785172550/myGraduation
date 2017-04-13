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
		<title>修改项目信息</title>
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

		<style>
.date-picker-wp {
	display: none;
	position: absolute;
	background: #f1f1f1;
	left: 40px;
	top: 40px;
	border-top: 4px solid #3879d9;
}

.date-picker-wp table {
	border: 1px solid #ddd;
}

.date-picker-wp td {
	background: #fafafa;
	width: 22px;
	height: 18px;
	border: 1px solid #ccc;
	font-size: 12px;
	text-align: center;
}

.date-picker-wp td.noborder {
	border: none;
	background: none;
}

.date-picker-wp td a {
	color: #1c93c4;
	text-decoration: none;
}

.strong {
	font-weight: bold
}

.hand {
	cursor: pointer;
	color: #3879d9
}
</style>
		<script type="text/javascript">
	var DatePicker = function() {
		var $ = function(i) {
			return document.getElementById(i)
		}, addEvent = function(o, e, f) {
			o.addEventListener ? o.addEventListener(e, f, false) : o
					.attachEvent('on' + e, function() {
						f.call(o)
					})
		}, getPos = function(el) {
			for ( var pos = {
				x : 0,
				y : 0
			}; el; el = el.offsetParent) {
				pos.x += el.offsetLeft;
				pos.y += el.offsetTop;
			}
			return pos;
		}
		var init = function(n, config) {
			window[n] = this;
			Date.prototype._fd = function() {
				var d = new Date(this);
				d.setDate(1);
				return d.getDay()
			};
			Date.prototype._fc = function() {
				var d1 = new Date(this), d2 = new Date(this);
				d1.setDate(1);
				d2.setDate(1);
				d2.setMonth(d2.getMonth() + 1);
				return (d2 - d1) / 86400000;
			};
			this.n = n;
			this.config = config;
			this.D = new Date;
			this.el = $(config.inputId);
			this.el.title = this.n + 'DatePicker';
			this.update();
			this.bind();
		}
		init.prototype = {
			update : function(y, m) {
				var con = [], week = [ 'Su', 'Mo', 'Tu', 'We', 'Th', 'Fr', 'Sa' ], D = this.D, _this = this;
				fn = function(a, b) {
					return '<td title="' + _this.n
							+ 'DatePicker" class="noborder hand" onclick="'
							+ _this.n + '.update(' + a + ')">' + b + '</td>'
				}, _html = '<table cellpadding=0 cellspacing=2>';
				y && D.setYear(D.getFullYear() + y);
				m && D.setMonth(D.getMonth() + m);
				var year = D.getFullYear(), month = D.getMonth() + 1, date = D
						.getDate();
				for ( var i = 0; i < week.length; i++)
					con.push('<td title="' + this.n
							+ 'DatePicker" class="noborder">' + week[i]
							+ '</td>');
				for ( var i = 0; i < D._fd(); i++)
					con
							.push('<td title="' + this.n + 'DatePicker" class="noborder"> </td>');
				for ( var i = 0; i < D._fc(); i++)
					con.push('<td class="hand" onclick="' + this.n
							+ '.fillInput(' + year + ', ' + month + ', '
							+ (i + 1) + ')">' + (i + 1) + '</td>');
				var toend = con.length % 7;
				if (toend != 0)
					for ( var i = 0; i < 7 - toend; i++)
						con.push('<td class="noborder"> </td>');
				_html += '<tr>' + fn("-1, null", "<<") + fn("null, -1", "<")
						+ '<td title="' + this.n
						+ 'DatePicker" colspan=3 class="strong">' + year + '/'
						+ month + '/' + date + '</td>' + fn("null, 1", ">")
						+ fn("1, null", ">>") + '</tr>';
				for ( var i = 0; i < con.length; i++)
					_html += (i == 0 ? '<tr>' : i % 7 == 0 ? '</tr><tr>' : '')
							+ con[i] + (i == con.length - 1 ? '</tr>' : '');
				!!this.box ? this.box.innerHTML = _html : this.createBox(_html);
			},
			fillInput : function(y, m, d) {
				var s = this.config.seprator || '/';
				this.el.value = y + s + m + s + d;
				this.box.style.display = 'none';
			},
			show : function() {
				var s = this.box.style, is = this.mask.style;
				s['left'] = is['left'] = getPos(this.el).x + 'px';
				s['top'] = is['top'] = getPos(this.el).y + this.el.offsetHeight
						+ 'px';
				s['display'] = is['display'] = 'block';
				is['width'] = this.box.offsetWidth - 2 + 'px';
				is['height'] = this.box.offsetHeight - 2 + 'px';
			},
			hide : function() {
				this.box.style.display = 'none';
				this.mask.style.display = 'none';
			},
			bind : function() {
				var _this = this;
				addEvent(document, 'click', function(e) {
					e = e || window.event;
					var t = e.target || e.srcElement;
					if (t.title != _this.n + 'DatePicker') {
						_this.hide()
					} else {
						_this.show()
					}
				})
			},
			createBox : function(html) {
				var box = this.box = document.createElement('div'), mask = this.mask = document
						.createElement('iframe');
				box.className = this.config.className || 'datepicker';
				mask.src = 'javascript:false';
				mask.frameBorder = 0;
				box.style.cssText = 'position:absolute;display:none;z-index:9999';
				mask.style.cssText = 'position:absolute;display:none;z-index:9998';
				box.title = this.n + 'DatePicker';
				box.innerHTML = html;
				document.body.appendChild(box);
				document.body.appendChild(mask);
				return box;
			}
		}
		return init;
	}();
	onload = function() {
		new DatePicker('_DatePicker_demo', {
			inputId : 'date-input-atom',
			className : 'date-picker-wp',
			seprator : '-'
		});
		new DatePicker('_demo2', {
			inputId : 'demo2',
			className : 'date-picker-wp'
		})
	}
</script>

		<script type="text/javascript" src="js/jquery-1.4.2.min.js"></script>
		<script type="text/javascript"
			src="xheditor/xheditor-1.1.6-zh-cn.min.js"></script>
		<script type="text/javascript">
	$(document).ready(function() {
		//初始化xhEditor编辑器插件
			$('#xh_editor').xheditor( {
				tools : 'full',//工具栏按钮全要
				skin : 'default',//皮肤
				upMultiple : false,//上传数量限制
				upImgUrl : "/xh/UploadFileSvt",//上传图片位置
				upImgExt : "jpg,jpeg,gif,bmp,png",//上传文件类型限制
				onUpload : insertUpload

			});
			//xbhEditor编辑器图片上传回调函数
			function insertUpload(msg) {
				var _msg = msg.toString();
				var _picture_name = _msg.substring(_msg.lastIndexOf("/") + 1);
				var _picture_path = Substring(_msg);
				$("#xh_editor").append(_msg);
			}
			//处理服务器返回到回调函数的字符串内容,格式是JSON的数据格式.
			function Substring(s) {
				return s.substring(s.substring(0, s.lastIndexOf("/"))
						.lastIndexOf("/"), s.length);
			}
		});
</script>

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
			<div class="centercontent">
				<div class="pageheader">
					<div class="profiletitle"></div>
					<!--pageheader-->
					<div id="contentwrapper" class="contentwrapper">
						<div class="two_third last profile_wrapper">
							<div id="profile" class="subcontent">
								<form action="ModifyProjectInfoServlet?id=${id }" method="post"
									enctype="multipart/form-data">
									<center>
										<h3>
											<b>修改项目信息</b>
										</h3>
									</center>
									<br />
									<br />
									<b>项目标题：</b>
									<input type="text" name="title" id="title"
										style="width: 267px;" />
									<br>
									<br>
									<b>开始时间：</b>
									<input type="text" id="date-input-atom" name ="time" style="width: 267px;" />
									<br>
									<br>
									<b>封面图片：</b>
									<input type="file" name="cover_image" id="cover_image"
										style="width: 267px;" />
									<br>
									<br>
									<b>项目详情：</b>
									<br />
									<br />
									<textarea id="xh_editor" name="details_page"
										style="width: 600px; height: 400px">
	  								</textarea>
									<br />
									<br />

									<input type="submit" value="确认修改" style="width: 267px;" />
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
