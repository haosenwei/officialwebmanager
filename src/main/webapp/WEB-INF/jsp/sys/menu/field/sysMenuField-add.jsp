<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<form class="form-horizontal" id="sysMenuField_add_form" role="form">
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-id">:</label>
				<div class="col-sm-9">
					<input id="form-field-id" name="id" value="${sysMenuField.id}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-menuId">表主键:</label>
				<div class="col-sm-9">
					<input id="form-field-menuId" name="menuId" value="${sysMenuField.menuId}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-columnName">名称(英文),分隔符_:</label>
				<div class="col-sm-9">
					<input id="form-field-columnName" name="columnName" value="${sysMenuField.columnName}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-dataType">字段类型:</label>
				<div class="col-sm-9">
					<input id="form-field-dataType" name="dataType" value="${sysMenuField.dataType}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-columnType">字段类型:</label>
				<div class="col-sm-9">
					<input id="form-field-columnType" name="columnType" value="${sysMenuField.columnType}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-flength">字段长度:</label>
				<div class="col-sm-9">
					<input id="form-field-flength" name="flength" value="${sysMenuField.flength}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-keyDic">主键标识:</label>
				<div class="col-sm-9">
					<input id="form-field-keyDic" name="keyDic" value="${sysMenuField.keyDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-jspTypeDic">页面类型:</label>
				<div class="col-sm-9">
					<input id="form-field-jspTypeDic" name="jspTypeDic" value="${sysMenuField.jspTypeDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-comment">评论:</label>
				<div class="col-sm-9">
					<input id="form-field-comment" name="comment" value="${sysMenuField.comment}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-remark">备注:</label>
				<div class="col-sm-9">
					<input id="form-field-remark" name="remark" value="${sysMenuField.remark}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-listTypeDic">列表页面展示:</label>
				<div class="col-sm-9">
					<input id="form-field-listTypeDic" name="listTypeDic" value="${sysMenuField.listTypeDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-addIsEdit">新建页面是否可以修改:</label>
				<div class="col-sm-9">
					<input id="form-field-addIsEdit" name="addIsEdit" value="${sysMenuField.addIsEdit}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-addTypeDic">新增页面展示:</label>
				<div class="col-sm-9">
					<input id="form-field-addTypeDic" name="addTypeDic" value="${sysMenuField.addTypeDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-viewTypeDic">详情页面展示:</label>
				<div class="col-sm-9">
					<input id="form-field-viewTypeDic" name="viewTypeDic" value="${sysMenuField.viewTypeDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-editIsEdit">修改页面是否可修改:</label>
				<div class="col-sm-9">
					<input id="form-field-editIsEdit" name="editIsEdit" value="${sysMenuField.editIsEdit}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-editTypeDic">修改页面类型:</label>
				<div class="col-sm-9">
					<input id="form-field-editTypeDic" name="editTypeDic" value="${sysMenuField.editTypeDic}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-orderBy">排序:</label>
				<div class="col-sm-9">
					<input id="form-field-orderBy" name="orderBy" value="${sysMenuField.orderBy}" class="form-control" type="text">
				</div>
			</div>
		</div>
	
	
		<div class="col-xs-6">
			<div class="form-group">
				<label class="col-sm-3 control-label no-padding-right" for="form-field-defaultValue">默认值:</label>
				<div class="col-sm-9">
					<input id="form-field-defaultValue" name="defaultValue" value="${sysMenuField.defaultValue}" class="form-control" type="text">
				</div>
			</div>
		</div>
	</div>

</form>