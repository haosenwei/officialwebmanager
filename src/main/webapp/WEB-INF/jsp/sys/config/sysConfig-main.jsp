<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/g4m" prefix="o" %>

<title>系统配置表-${sessionScope.sysTitle}</title>

<div class="layui-row">
	<div class="layui-col-md12">
		<form class="layui-form" id="sysConfig_search_form" action="#">
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
					<a id="sysConfig_search_btn" class="layui-btn">搜索</a>
					<a id="sysConfig_reset" class="layui-btn">重置</a>
					<a id="sysConfig_add" class="layui-btn">新增</a> <a id="sysConfig_dels" class="layui-btn">删除</a>
				</div>
			</div>
		</form>
	</div>
	<div class="layui-col-md12">
		<table id="sysConfigTable" lay-filter="sysConfigTable"></table>
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
			{ field : "name", title : "名称" },
			{ field : "description", title : "描述" },
			{ field : "val", title : "值" },
			{ field : "type", title : "类型" },
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
		common.renderTable('sysConfig',"${server}sys/config/search?${_csrf.parameterName}=${_csrf.token}",colNames);
		$(document).on('click', '#sysConfig_search_btn', function() {
			table.reload('sysConfigTableTest', {
				where : common.getParam('sysConfig_search_form'),
				page : {
					curr : 0//重新从第 1 页开始
				}
			});
		});
		$("#sysConfig_add").off('click').on('click', function(){
			common.addTab("${server}sys/config/toAdd?${_csrf.parameterName}=${_csrf.token}", 'sysConfig_add', '新增系统配置表'); //url , code, name
		});
	});
</script>