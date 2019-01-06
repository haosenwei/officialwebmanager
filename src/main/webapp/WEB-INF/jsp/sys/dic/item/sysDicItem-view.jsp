<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-xs-12">
	<div class="table-responsive">
			<form id="input_form" class="form-horizontal" role="form">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
												<tr>
							<td width="25%">主键:</td>
							<td width="25%">
								${sysDicItem.id}
							</td>
						
						
							<td width="25%">分组id:</td>
							<td width="25%">
								${sysDicItem.groupId}
							</td>
						</tr>
						<tr>
							<td width="25%">名称:</td>
							<td width="25%">
								${sysDicItem.code}
							</td>
						
						
							<td width="25%">编码:</td>
							<td width="25%">
								${sysDicItem.name}
							</td>
						</tr>
						<tr>
							<td width="25%">备注:</td>
							<td width="25%">
								${sysDicItem.remark}
							</td>
						
						
							<td width="25%">状态:</td>
							<td width="25%">
								${sysDicItem.status}
							</td>
						</tr>
						<tr>
							<td width="25%">排序:</td>
							<td width="25%">
								${sysDicItem.sort}
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