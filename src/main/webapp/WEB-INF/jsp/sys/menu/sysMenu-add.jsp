<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="/g4m" prefix="o" %>
<form class="layui-form" action="#">
	<div class="layui-row">
			<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label"></label>
				<div class="layui-input-block">
					<input type="text" name="id" placeholder="请输入" value="${sysMenu.id}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">编码</label>
				<div class="layui-input-block">
					<input type="text" name="code" placeholder="请输入编码" value="${sysMenu.code}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">类型</label>
				<div class="layui-input-block">
					<input type="text" name="typeDic" placeholder="请输入类型" value="${sysMenu.typeDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">菜单名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" placeholder="请输入菜单名称" value="${sysMenu.name}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">上级节点</label>
				<div class="layui-input-block">
					<input type="text" name="pid" placeholder="请输入上级节点" value="${sysMenu.pid}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">状态</label>
				<div class="layui-input-block">
					<input type="text" name="statusDic" placeholder="请输入状态" value="${sysMenu.statusDic}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">地址</label>
				<div class="layui-input-block">
					<input type="text" name="url" placeholder="请输入地址" value="${sysMenu.url}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">路径</label>
				<div class="layui-input-block">
					<input type="text" name="path" placeholder="请输入路径" value="${sysMenu.path}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">图标</label>
				<div class="layui-input-block">
					<input type="text" name="icon" placeholder="请输入图标" value="${sysMenu.icon}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">排序</label>
				<div class="layui-input-block">
					<input type="text" name="sort" placeholder="请输入排序" value="${sysMenu.sort}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">备注</label>
				<div class="layui-input-block">
					<input type="text" name="remark" placeholder="请输入备注" value="${sysMenu.remark}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">创建时间</label>
				<div class="layui-input-block">
					<input type="text" name="createTime" placeholder="请输入创建时间" value="${sysMenu.createTime}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">修改者</label>
				<div class="layui-input-block">
					<input type="text" name="modifyUerId" placeholder="请输入修改者" value="${sysMenu.modifyUerId}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs6">
			<div class="layui-form-item">
				<label class="layui-form-label">修改时间</label>
				<div class="layui-input-block">
					<input type="text" name="modifyTime" placeholder="请输入修改时间" value="${sysMenu.modifyTime}" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
		<div class="layui-col-xs12">
			<div class="layui-form-item">
				<div class="layui-input-block">
					<button class="layui-btn" lay-submit lay-filter="sysMenu_add">立即提交</button>
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
		form.on('submit(sysMenu_add)', function(data) {
			common.ajaxTableData("${server}sys/menu/doAdd?${_csrf.parameterName}=${_csrf.token}",data.field);
			return false;
		});
		form.render();
	});
</script>