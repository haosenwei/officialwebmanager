<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/g4m" prefix="o" %>
<form class="layui-form" action="#">
	<div class="layui-row">
	    <o:input type="1" value="1" fieldName="id" fieldComment="主键" required="false"/>
	    <o:input type="2" value="1" fieldName="password" fieldComment="密码" required="false"/>
	    <o:input type="3" value="1" fieldName="name" fieldComment="名称" required="false"/>
	    <o:input type="4" value="1" fieldName="select" fieldComment="选择" required="false"/>
	    <o:input type="5" value="1" fieldName="open" fieldComment="开关" required="false"/>
	    <o:input type="6" value="1" fieldName="radio" fieldComment="单选" required="false"/>
		<div class="layui-col-xs12">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="authRole_add">立即提交</button>
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
		form.on('submit(authRole_add)', function(data) {
			common.ajaxTableData("${server}auth/role/doAdd?${_csrf.parameterName}=${_csrf.token}",data.field);
			return false;
		});
		form.render();
	});
</script>