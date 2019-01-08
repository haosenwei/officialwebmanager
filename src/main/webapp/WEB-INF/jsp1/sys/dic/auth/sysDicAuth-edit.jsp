<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/g4m" prefix="o" %>
<form class="layui-form" action="#">
	<input name="" value="${sysDicAuth.}" type="hidden">
	<div class="layui-row">
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">主键</label>
				<div class="layui-input-block">
					<input type="text" name="id" placeholder="请输入主键" value="${sysDicAuth.id}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">fieldid</label>
				<div class="layui-input-block">
					<input type="text" name="sysMenuFieldId" placeholder="请输入fieldid" value="${sysDicAuth.sysMenuFieldId}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">数据字典项id</label>
				<div class="layui-input-block">
					<input type="text" name="sysDicItemId" placeholder="请输入数据字典项id" value="${sysDicAuth.sysDicItemId}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs12">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="sysDicAuth_edit">确定修改</button>
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
		form.on('submit(sysDicAuth_add)', function(data) {
			common.ajaxTableData("${server}sys/dic/auth/doEdit?${_csrf.parameterName}=${_csrf.token}",data.field);
			return false;
		});
		form.render();
	});
</script>