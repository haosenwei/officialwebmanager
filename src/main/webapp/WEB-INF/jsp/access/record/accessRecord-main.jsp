<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/g4m" prefix="o" %>

<title>访问记录表-${sessionScope.sysTitle}</title>

<div class="layui-row">
	<div class="layui-col-md12">
		<form class="layui-form" id="accessRecord_search_form" action="#">
			<div class="layui-row">
				<div class="layui-col-md3">
					<div class="layui-form-item">
						<label class="layui-form-label">输入框</label>
						<div class="layui-input-block">
							<input type="text" name="search_code" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<a id="accessRecord_search_btn" class="layui-btn">搜索</a>
					<a id="accessRecord_reset" class="layui-btn">重置</a>
					<a id="accessRecord_add" class="layui-btn">新增</a> <a id="accessRecord_dels" class="layui-btn">删除</a>
				</div>
			</div>
		</form>
	</div>
	<div class="layui-col-md12">
		<table id="accessRecordTable" lay-filter="accessRecordTable"></table>
	</div>
</div>
<script>
	layui.use(['jquery', 'common' ], function() {
		var table = layui.table ,$ = layui.jquery, common = layui.common;
		var colNames = [ [ //表头
			{
				checkbox : true
			},
			{ field : "id", title : "主键" },
			{ field : "requestUrl", title : "请求url" },
			{ field : "requestUri", title : "请求资源" },
			{ field : "queryString", title : "查询参数" },
			{ field : "remoteAddr", title : "访问者ip" },
			{ field : "remoteHost", title : "访问者的主机" },
			{ field : "browser", title : "访问者浏览器" },
			{ field : "browserVersion", title : "访问者浏览器版本" },
			{ field : "operatingSystem", title : "操作系统" },
			{ field : "browsingTime", title : "访问时间" },
			{
				templet : function(d) {
					return '<div class="layui-btn-group">'
							+ '<button class="layui-btn layui-btn-sm">'
							+ '<i class="layui-icon">&#xe654;</i>'
							+ '</button>'
							+ '<button class="layui-btn layui-btn-sm">'
							+ ' <i class="layui-icon">&#xe642;</i>'
							+ '</button>'
							+ '<button class="layui-btn layui-btn-sm">'
							+ '<i class="layui-icon">&#xe640;</i>'
							+ ' </button>' + '</div>';
				}
			} ] ];
		common.renderTable('accessRecord',"${server}access/record/search?${_csrf.parameterName}=${_csrf.token}",colNames);
		$(document).on('click', '#accessRecord_search_btn', function() {
			table.reload('accessRecordTableTest', {
				where : common.getParam('accessRecord_search_form'),
				page : {
					curr : 0//重新从第 1 页开始
				}
			});
		});
		$("#accessRecord_add").off('click').on('click', function(){
			common.addTab("${server}access/record/toAdd?${_csrf.parameterName}=${_csrf.token}", 'accessRecord_add', '新增访问记录表'); //url , code, name
		});
	});
</script>