<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/g4m" prefix="o" %>
<form class="layui-form" action="#">
	<input name="id" value="${authRole.id}" type="hidden">
	<div class="layui-row">
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">编码</label>
				<div class="layui-input-block">
					<input type="text" name="code" placeholder="请输入编码" value="${authRole.code}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" placeholder="请输入名称" value="${authRole.name}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">主要职责</label>
				<div class="layui-input-block">
					<input type="text" name="majorDuty" placeholder="请输入主要职责" value="${authRole.majorDuty}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<input type="text" name="remark" placeholder="请输入备注" value="${authRole.remark}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs12">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="authRole_edit">确定修改</button>
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
		form.on('submit(authRole_edit)', function(data) {
		    console.log(data.field);
			common.doEdit("authRole","${server}auth/role/doEdit?${_csrf.parameterName}=${_csrf.token}",data.field);
			return false;
		});
		form.render();
	});
</script>