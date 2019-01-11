<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/g4m" prefix="o" %>

<title>菜单表-${sessionScope.sysTitle}</title>

<div class="layui-row">
	<div class="layui-col-md12">
		<form class="layui-form" id="sysMenu_search_form" action="#">
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
					<a id="sysMenu_search_btn" class="layui-btn">搜索</a>
					<a id="sysMenu_search_test" class="layui-btn">测试按钮</a>
					<a id="sysMenu_reset" class="layui-btn">重置</a>
					<a id="sysMenu_add" class="layui-btn">新增</a> <a id="sysMenu_dels" class="layui-btn">删除</a>
				</div>
			</div>
		</form>
	</div>
	<div class="layui-col-md12">
		<table id="sysMenuTable" lay-filter="sysMenuTable"></table>
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
			{ field : "code", title : "编码" },
			{ field : "typeDic", title : "类型" },
			{ field : "name", title : "菜单名称" },
			{ field : "pid", title : "上级节点" },
			{ field : "statusDic", title : "状态" },
			{ field : "url", title : "地址" },
			{ field : "path", title : "路径" },
			{ field : "icon", title : "图标" },
			{ field : "sort", title : "排序" },
			{ field : "remark", title : "备注" },
			{ field : "createTime", title : "创建时间" },
			{ field : "modifyUerId", title : "修改者" },
			{ field : "modifyTime", title : "修改时间" },
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
		common.renderTable('sysMenu',"${server}sys/menu/search?${_csrf.parameterName}=${_csrf.token}",colNames);
		$(document).on('click', '#sysMenu_search_btn', function() {
			table.reload('sysMenuTableTest', {
				where : common.getParam('sysMenu_search_form'),
				page : {
					curr : 0//重新从第 1 页开始
				}
			});
		});
		$("#sysMenu_add").off('click').on('click', function(){
			common.addTab("${server}sys/menu/toAdd?${_csrf.parameterName}=${_csrf.token}", 'sysMenu_add', '新增菜单表'); //url , code, name
		});
		$("#sysMenu_search_test").off('click').on('click', function(){
			common.openLayer("${server}selectDic",{'btn':['开始','关闭','3'],'yes':function(){
				alert("1");
			},'btn1':function(){
				alert(2);
				return false;
			},'btn2':function(){
				alert(3);
				return false;
			}}); //url , code, name
		});
	});
</script>