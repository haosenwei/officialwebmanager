<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>菜单详情表-${sessionScope.sysTitle}</title>

<div class="layui-row">
	<div class="layui-col-md12">
		<form class="layui-form" id="sysMenu_search_form" action="#">
			<div class="layui-row">
				<div class="layui-col-md3">
					<div class="layui-form-item">
						<label class="layui-form-label">输入框</label>
						<div class="layui-input-block">
							<input type="text" name="search_columnName" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<a id="sysMenu_search_btn" class="layui-btn">搜索</a>
					<a id="sysMenu_reset" class="layui-btn">重置</a>
					<a id="sysMenu_add" class="layui-btn">新增</a>
					<a id="sysMenu_dels" class="layui-btn">删除</a>
				</div>
			</div>
		</form>
	</div>
	<div class="layui-col-md12">
		<table id="demo" lay-filter="test"></table>
	</div>
</div>
<script>
	layui.use(['table','jquery','common'], function() {
		var table = layui.table,$=layui.jquery,common=layui.common;
		//第一个实例
		table.render({
			id : 'idTest',
			elem : '#demo',
			url : '/sys/menu/field/search' //数据接口
			,page : true //开启分页
			,cols : [ [ //表头
			{
				checkbox : true
			}, {
				field : "id",
				LAY_CHECKED : false,
				type : 'radio',
				title : "id"
			}, {
				field : "id",
				title : "id"
			}, {
				field : "menuId",
				title : "menuId"
			}, {
				field : "columnName",
				title : "columnName"
			}, {
				field : "dataType",
				title : "dataType"
			}, {
				field : "columnType",
				title : "columnType"
			}, {
				field : "flength",
				title : "flength"
			}, {
				field : "keyDic",
				title : "keyDic"
			}, {
				field : "jspTypeDic",
				title : "jspTypeDic"
			}, {
				field : "comment",
				title : "comment"
			}, {
				field : "remark",
				title : "remark",
				templet: function(d){
			        return '<div class="layui-btn-group">'
			        +'<button class="layui-btn layui-btn-sm">'
			        +'<i class="layui-icon">&#xe654;</i>'
			        +'</button>'
			      +'<button class="layui-btn layui-btn-sm">'
			      +' <i class="layui-icon">&#xe642;</i>'
			        +'</button>'
			      +'<button class="layui-btn layui-btn-sm">'
			      +'<i class="layui-icon">&#xe640;</i>'
			        +' </button>'
			    +'</div>';
			      }
			} ] ],
			method : 'get' //如果无需自定义HTTP类型，可不加该参数
			,request : {
				pageName : 'curr' //页码的参数名称，默认：page
				,limitName : 'length' //每页数据量的参数名，默认：limit
			}
			,where: common.getParam('sysMenu_search_form')
		});
		$(document).on('click','#sysMenu_search_btn',function(){
			table.reload('idTest', {
				where: common.getParam('sysMenu_search_form')
				,page: {
					curr: 0 //重新从第 1 页开始
				}
			});
		});
		$(document).on('click','#sysMenu_add',function(){
			common.addTab('sys/menu/field/toAdd','sys_menu_filed_add','新增菜单详情');  //url , code, name
		});
	});
</script>