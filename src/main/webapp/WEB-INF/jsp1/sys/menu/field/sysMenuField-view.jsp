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
								${sysMenuField.id}
							</td>
						
						
							<td width="25%">表主键:</td>
							<td width="25%">
								${sysMenuField.menuId}
							</td>
						</tr>
						<tr>
							<td width="25%">名称(英文),分隔符_:</td>
							<td width="25%">
								${sysMenuField.columnName}
							</td>
						
						
							<td width="25%">字段类型:</td>
							<td width="25%">
								${sysMenuField.dataType}
							</td>
						</tr>
						<tr>
							<td width="25%">字段类型:</td>
							<td width="25%">
								${sysMenuField.columnType}
							</td>
						
						
							<td width="25%">字段长度:</td>
							<td width="25%">
								${sysMenuField.flength}
							</td>
						</tr>
						<tr>
							<td width="25%">主键标识:</td>
							<td width="25%">
								${sysMenuField.keyDic}
							</td>
						
						
							<td width="25%">页面类型:</td>
							<td width="25%">
								${sysMenuField.jspTypeDic}
							</td>
						</tr>
						<tr>
							<td width="25%">评论:</td>
							<td width="25%">
								${sysMenuField.comment}
							</td>
						
						
							<td width="25%">备注:</td>
							<td width="25%">
								${sysMenuField.remark}
							</td>
						</tr>
						<tr>
							<td width="25%">列表页面展示:</td>
							<td width="25%">
								${sysMenuField.listTypeDic}
							</td>
						
						
							<td width="25%">新建页面是否可以修改:</td>
							<td width="25%">
								${sysMenuField.addIsEdit}
							</td>
						</tr>
						<tr>
							<td width="25%">新增页面展示:</td>
							<td width="25%">
								${sysMenuField.addTypeDic}
							</td>
						
						
							<td width="25%">详情页面展示:</td>
							<td width="25%">
								${sysMenuField.viewTypeDic}
							</td>
						</tr>
						<tr>
							<td width="25%">修改页面是否可修改:</td>
							<td width="25%">
								${sysMenuField.editIsEdit}
							</td>
						
						
							<td width="25%">修改页面类型:</td>
							<td width="25%">
								${sysMenuField.editTypeDic}
							</td>
						</tr>
						<tr>
							<td width="25%">排序:</td>
							<td width="25%">
								${sysMenuField.orderBy}
							</td>
						
						
							<td width="25%">默认值:</td>
							<td width="25%">
								${sysMenuField.defaultValue}
							</td>
						</tr>

					</tbody>
				</table>
			 </form>
		</div>
	</div>
</div>