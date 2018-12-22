<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-xs-12">
	<div class="table-responsive">
			<form id="input_form" class="form-horizontal" role="form">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
																		<tr>
							<td width="25%">表名称:</td>
							<td width="25%">
								${sysTableField.tableName}
							</td>
						
						
							<td width="25%">菜单名字:</td>
							<td width="25%">
								${sysTableField.menuName}
							</td>
						</tr>
						<tr>
							<td width="25%">链接地址:</td>
							<td width="25%">
								${sysTableField.url}
							</td>
						
						
							<td width="25%">上级节点:</td>
							<td width="25%">
								${sysTableField.pid}
							</td>
						</tr>
												<tr>
							<td width="25%">备注:</td>
							<td width="25%">
								${sysTableField.comment}
							</td>
						
						<td></td>
						<td></td>
						</tr>
					</tbody>
				</table>
			 </form>
		</div>
	</div>
</div>