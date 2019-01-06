<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/g4m" prefix="o" %>
<form class="layui-form" action="#">
	<input name="" value="${sysMenuField.}" type="hidden">
	<div class="layui-row">
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<input type="text" name="id" placeholder="请输入" value="${sysMenuField.id}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">表主键</label>
				<div class="layui-input-block">
					<input type="text" name="menuId" placeholder="请输入表主键" value="${sysMenuField.menuId}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">名称(英文),分隔符_</label>
				<div class="layui-input-block">
					<input type="text" name="columnName" placeholder="请输入名称(英文),分隔符_" value="${sysMenuField.columnName}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">字段类型</label>
				<div class="layui-input-block">
					<input type="text" name="dataType" placeholder="请输入字段类型" value="${sysMenuField.dataType}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">字段类型</label>
				<div class="layui-input-block">
					<input type="text" name="columnType" placeholder="请输入字段类型" value="${sysMenuField.columnType}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">字段长度</label>
				<div class="layui-input-block">
					<input type="text" name="flength" placeholder="请输入字段长度" value="${sysMenuField.flength}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">主键标识</label>
				<div class="layui-input-block">
					<input type="text" name="keyDic" placeholder="请输入主键标识" value="${sysMenuField.keyDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">页面类型</label>
				<div class="layui-input-block">
					<input type="text" name="jspTypeDic" placeholder="请输入页面类型" value="${sysMenuField.jspTypeDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">评论</label>
				<div class="layui-input-block">
					<input type="text" name="comment" placeholder="请输入评论" value="${sysMenuField.comment}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<input type="text" name="remark" placeholder="请输入备注" value="${sysMenuField.remark}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">列表页面展示</label>
				<div class="layui-input-block">
					<input type="text" name="listTypeDic" placeholder="请输入列表页面展示" value="${sysMenuField.listTypeDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">新建页面是否可以修改</label>
				<div class="layui-input-block">
					<input type="text" name="addIsEdit" placeholder="请输入新建页面是否可以修改" value="${sysMenuField.addIsEdit}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">新增页面展示</label>
				<div class="layui-input-block">
					<input type="text" name="addTypeDic" placeholder="请输入新增页面展示" value="${sysMenuField.addTypeDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">详情页面展示</label>
				<div class="layui-input-block">
					<input type="text" name="viewTypeDic" placeholder="请输入详情页面展示" value="${sysMenuField.viewTypeDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">修改页面是否可修改</label>
				<div class="layui-input-block">
					<input type="text" name="editIsEdit" placeholder="请输入修改页面是否可修改" value="${sysMenuField.editIsEdit}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">修改页面类型</label>
				<div class="layui-input-block">
					<input type="text" name="editTypeDic" placeholder="请输入修改页面类型" value="${sysMenuField.editTypeDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">排序</label>
				<div class="layui-input-block">
					<input type="text" name="orderBy" placeholder="请输入排序" value="${sysMenuField.orderBy}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">默认值</label>
				<div class="layui-input-block">
					<input type="text" name="defaultValue" placeholder="请输入默认值" value="${sysMenuField.defaultValue}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs12">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="sysMenuField_edit">确定修改</button>
					<button type="reset" class="layui-btn layui-btn-primary">重置</button>
				</div>
			</div>
		</div>
	</div>
</form>

<script>
	//Demo
	layui.use(['form','common'], function() {
		var form = layui.form,common = layui.common;
		//监听提交
		form.on('submit(sysMenuField_add)', function(data) {
			common.ajaxTableData("${server}sys/menu/field/doEdit?${_csrf.parameterName}=${_csrf.token}",data.field);
			return false;
		});
		form.render();
	});
</script>