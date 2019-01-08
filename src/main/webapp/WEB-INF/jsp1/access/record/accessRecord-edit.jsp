<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/g4m" prefix="o" %>
<form class="layui-form" action="#">
	<input name="" value="${accessRecord.}" type="hidden">
	<div class="layui-row">
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">主键</label>
				<div class="layui-input-block">
					<input type="text" name="id" placeholder="请输入主键" value="${accessRecord.id}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">请求url</label>
				<div class="layui-input-block">
					<input type="text" name="requestUrl" placeholder="请输入请求url" value="${accessRecord.requestUrl}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">请求资源</label>
				<div class="layui-input-block">
					<input type="text" name="requestUri" placeholder="请输入请求资源" value="${accessRecord.requestUri}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">查询参数</label>
				<div class="layui-input-block">
					<input type="text" name="queryString" placeholder="请输入查询参数" value="${accessRecord.queryString}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">访问者ip</label>
				<div class="layui-input-block">
					<input type="text" name="remoteAddr" placeholder="请输入访问者ip" value="${accessRecord.remoteAddr}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">访问者的主机</label>
				<div class="layui-input-block">
					<input type="text" name="remoteHost" placeholder="请输入访问者的主机" value="${accessRecord.remoteHost}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">访问者浏览器</label>
				<div class="layui-input-block">
					<input type="text" name="browser" placeholder="请输入访问者浏览器" value="${accessRecord.browser}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">访问者浏览器版本</label>
				<div class="layui-input-block">
					<input type="text" name="browserVersion" placeholder="请输入访问者浏览器版本" value="${accessRecord.browserVersion}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">操作系统</label>
				<div class="layui-input-block">
					<input type="text" name="operatingSystem" placeholder="请输入操作系统" value="${accessRecord.operatingSystem}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">访问时间</label>
				<div class="layui-input-block">
					<input type="text" name="browsingTime" placeholder="请输入访问时间" value="${accessRecord.browsingTime}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs12">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="accessRecord_edit">确定修改</button>
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
		form.on('submit(accessRecord_add)', function(data) {
			common.ajaxTableData("${server}access/record/doEdit?${_csrf.parameterName}=${_csrf.token}",data.field);
			return false;
		});
		form.render();
	});
</script>