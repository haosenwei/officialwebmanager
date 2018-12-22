<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="form-horizontal" id="sysMenu_edit_form" role="form">
	<input name="" value="${sysMenu.}" type="hidden">
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-id">:</label>
				<div class="col-sm-9">
					<input id="form-field-id" name="id" value="${sysMenu.id}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-code">编码:</label>
				<div class="col-sm-9">
					<input id="form-field-code" name="code" value="${sysMenu.code}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-typeDic">类型:</label>
				<div class="col-sm-9">
					<input id="form-field-typeDic" name="typeDic" value="${sysMenu.typeDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-name">菜单名称:</label>
				<div class="col-sm-9">
					<input id="form-field-name" name="name" value="${sysMenu.name}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-pid">上级节点:</label>
				<div class="col-sm-9">
					<input id="form-field-pid" name="pid" value="${sysMenu.pid}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-statusDic">状态:</label>
				<div class="col-sm-9">
					<input id="form-field-statusDic" name="statusDic" value="${sysMenu.statusDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-url">地址:</label>
				<div class="col-sm-9">
					<input id="form-field-url" name="url" value="${sysMenu.url}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-path">路径:</label>
				<div class="col-sm-9">
					<input id="form-field-path" name="path" value="${sysMenu.path}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-icon">图标:</label>
				<div class="col-sm-9">
					<input id="form-field-icon" name="icon" value="${sysMenu.icon}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-sort">排序:</label>
				<div class="col-sm-9">
					<input id="form-field-sort" name="sort" value="${sysMenu.sort}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-remark">备注:</label>
				<div class="col-sm-9">
					<input id="form-field-remark" name="remark" value="${sysMenu.remark}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-createTime">创建时间:</label>
				<div class="col-sm-9">
					<input id="form-field-createTime" name="createTime" value="${sysMenu.createTime}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-modifyUerId">修改者:</label>
				<div class="col-sm-9">
					<input id="form-field-modifyUerId" name="modifyUerId" value="${sysMenu.modifyUerId}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-modifyTime">修改时间:</label>
				<div class="col-sm-9">
					<input id="form-field-modifyTime" name="modifyTime" value="${sysMenu.modifyTime}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>

</form>