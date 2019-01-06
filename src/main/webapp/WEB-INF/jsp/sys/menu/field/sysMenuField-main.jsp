<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/g4m" prefix="o" %>

<title>菜单详情表-${sessionScope.sysTitle}</title>

<div class="layui-row">
	<div class="layui-col-md12">
		<form class="layui-form" id="sysMenuField_search_form" action="#">
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
					<a id="sysMenuField_search_btn" class="layui-btn">搜索</a>
					<a id="sysMenuField_reset" class="layui-btn">重置</a>
					<a id="sysMenuField_add" class="layui-btn">新增</a> <a id="sysMenuField_dels" class="layui-btn">删除</a>
				</div>
			</div>
		</form>
	</div>
	<div class="layui-col-md12">
		<table id="sysMenuFieldTable" lay-filter="sysMenuFieldTable"></table>
	</div>
</div>
<script>
	layui.use(['jquery', 'common' ], function() {
		var table = layui.table ,$ = layui.jquery, common = layui.common;
		var colNames = [ [ //表头
			{
				checkbox : true
			},
			{ field : "id", title : "" },
			{ field : "menuId", title : "表主键" },
			{ field : "columnName", title : "名称(英文),分隔符_" },
			{ field : "dataType", title : "字段类型" },
			{ field : "columnType", title : "字段类型" },
			{ field : "flength", title : "字段长度" },
			{ field : "keyDic", title : "主键标识" },
			{ field : "jspTypeDic", title : "页面类型" },
			{ field : "comment", title : "评论" },
			{ field : "remark", title : "备注" },
			{ field : "listTypeDic", title : "列表页面展示" },
			{ field : "addIsEdit", title : "新建页面是否可以修改" },
			{ field : "addTypeDic", title : "新增页面展示" },
			{ field : "viewTypeDic", title : "详情页面展示" },
			{ field : "editIsEdit", title : "修改页面是否可修改" },
			{ field : "editTypeDic", title : "修改页面类型" },
			{ field : "orderBy", title : "排序" },
			{ field : "defaultValue", title : "默认值" },
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
		common.renderTable('sysMenuField',"${server}sys/menu/field/search?${_csrf.parameterName}=${_csrf.token}",colNames);
		$(document).on('click', '#sysMenuField_search_btn', function() {
			table.reload('sysMenuFieldTableTest', {
				where : common.getParam('sysMenuField_search_form'),
				page : {
					curr : 0//重新从第 1 页开始
				}
			});
		});
		$("#sysMenuField_add").off('click').on('click', function(){
			common.addTab("${server}sys/menu/field/toAdd?${_csrf.parameterName}=${_csrf.token}", 'sysMenuField_add', '新增菜单详情表'); //url , code, name
		});
	});
</script>