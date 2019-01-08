<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-xs-12">
	<div class="table-responsive">
			<form id="input_form" class="form-horizontal" role="form">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
												<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysTableField.id}
							</td>
						
						
							<td width="25%">表主键:</td>
							<td width="25%">
								${sysTableField.menuId}
							</td>
						</tr>
						<tr>
							<td width="25%">字段名称:</td>
							<td width="25%">
								${sysTableField.columnName}
							</td>
						
						
							<td width="25%">字段类型:</td>
							<td width="25%">
								${sysTableField.dataType}
							</td>
						</tr>
						<tr>
							<td width="25%">字段类型:</td>
							<td width="25%">
								${sysTableField.columnType}
							</td>
						
						
							<td width="25%">字段长度:</td>
							<td width="25%">
								${sysTableField.flength}
							</td>
						</tr>
						<tr>
							<td width="25%">主键标识:</td>
							<td width="25%">
								${sysTableField.keyDic}
							</td>
						
						
							<td width="25%">页面类型:</td>
							<td width="25%">
								${sysTableField.jspTypeDic}
							</td>
						</tr>
						<tr>
							<td width="25%">评论:</td>
							<td width="25%">
								${sysTableField.comment}
							</td>
						
						
							<td width="25%">备注:</td>
							<td width="25%">
								${sysTableField.remark}
							</td>
						</tr>
						<tr>
							<td width="25%">列表页面展示:</td>
							<td width="25%">
								${sysTableField.listTypeDic}
							</td>
						
						
							<td width="25%">新增页面展示:</td>
							<td width="25%">
								${sysTableField.addTypeDic}
							</td>
						</tr>
						<tr>
							<td width="25%">详情页面展示:</td>
							<td width="25%">
								${sysTableField.viewTypeDic}
							</td>
						
						
							<td width="25%">修改页面类型:</td>
							<td width="25%">
								${sysTableField.editTypeDic}
							</td>
						</tr>
						<tr>
							<td width="25%">排序:</td>
							<td width="25%">
								${sysTableField.orderBy}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysTableField.defaultValue}
							</td>
						</tr>

					</tbody>
				</table>
			 </form>
		</div>
	</div>
</div>