<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<title>开始使用layui</title>
<link rel="stylesheet" href="/static/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">layui 后台布局</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="javascript:;"> <img
						src="http://t.cn/RCzsdCq" class="layui-nav-img"> 贤心
				</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">基本资料</a>
						</dd>
						<dd>
							<a href="">安全设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="">退了</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" id="menuID" lay-filter="test">
					<%-- <c:forEach items="${menu}" var="obj">
						<li class="layui-nav-item">
							<c:if test="${obj.list==null || fn:length(obj.list)==0}">
							<a class="menu" data-value="${obj.url}" href="javascript:;">${obj.name}</a>
							</c:if>
							<c:if test="${obj.list!=null && fn:length(obj.list)!=0}">
								<a class="menu" href="javascript:;">${obj.name}</a>
								<dl class="layui-nav-child">
								<c:forEach items="${obj.list}" var="itemObj">
									<dd>
									<c:if test="${itemObj.list==null || fn:length(itemObj.list)==0}">
										<a class="menu" href="javascript:;">${itemObj.name}</a>
									</c:if>
									<c:if test="${itemObj.list!=null && fn:length(itemObj.list)!=0}">
										<a class="menu" data-value="${itemObj.url}" href="javascript:;">${itemObj.name}</a>
										<dl class="layui-nav-child"> 
										<c:forEach items="${itemObj.list}" var="itemObjChild">
											<dd>
											<a class="menu" data-value="${itemObjChild.url}" href="javascript:;">${itemObjChild.name}</a>
											</dd>
									    </c:forEach>
										</dl>
									</c:if>
									</dd>
							    </c:forEach>
								</dl>
							</c:if>
						</li>
					</c:forEach> --%>
				</ul>
			</div>
		</div>
		<div class="layui-body">
			<!-- 内容主体区域 -->
			<div style="padding: 15px;">
				<div class="layui-tab" lay-allowClose="true" lay-filter="demo">
					<ul class="layui-tab-title">
						<li class="layui-this">网站设置</li>
					</ul>
					<div class="layui-tab-content">
						<div class="layui-tab-item layui-show">1</div>
					</div>
				</div>
			</div>
		</div>

		<div class="layui-footer">
			<!-- 底部固定区域 -->
			© layui.com - 底部固定区域
		</div>
	</div>

	<script src="/static/layui/layui.js"></script>
	<script>
		//一般直接写在一个js文件中
		layui.config({
			base : '/static/js/module/'
		}).use([ 'layer', 'form', 'element','sysMenu'],
		function() {
			var sysMenu = layui.sysMenu;
			sysMenu.loadMenu();
		});
	</script>
</body>
</html>