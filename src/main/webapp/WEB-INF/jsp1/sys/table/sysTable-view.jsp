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
								${sysTable.tableName}
							</td>
						
						
							<td width="25%">菜单名字:</td>
							<td width="25%">
								${sysTable.menuName}
							</td>
						</tr>
						<tr>
							<td width="25%">链接地址:</td>
							<td width="25%">
								${sysTable.url}
							</td>
						
						
							<td width="25%">上级节点:</td>
							<td width="25%">
								${sysTable.pid}
							</td>
						</tr>
												<tr>
							<td width="25%">备注:</td>
							<td width="25%">
								${sysTable.comment}
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