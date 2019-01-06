<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/g4m" prefix="o" %>
<form class="layui-form" action="#">
	<div class="layui-row">
			<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">主键</label>
				<div class="layui-input-block">
					<input type="text" name="id" placeholder="请输入主键" value="${sysDicItem.id}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">分组id</label>
				<div class="layui-input-block">
					<input type="text" name="groupId" placeholder="请输入分组id" value="${sysDicItem.groupId}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">名称</label>
				<div class="layui-input-block">
					<input type="text" name="code" placeholder="请输入名称" value="${sysDicItem.code}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">编码</label>
				<div class="layui-input-block">
					<input type="text" name="name" placeholder="请输入编码" value="${sysDicItem.name}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<input type="text" name="remark" placeholder="请输入备注" value="${sysDicItem.remark}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<input type="text" name="status" placeholder="请输入状态" value="${sysDicItem.status}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">排序</label>
				<div class="layui-input-block">
					<input type="text" name="sort" placeholder="请输入排序" value="${sysDicItem.sort}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs12">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="sysDicItem_add">立即提交</button>
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
		form.on('submit(sysDicItem_add)', function(data) {
			common.ajaxTableData("${server}sys/dic/item/doAdd?${_csrf.parameterName}=${_csrf.token}",data.field);
			return false;
		});
		form.render();
	});
</script>