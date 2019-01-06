<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-xs-12">
	<div class="table-responsive">
			<form id="input_form" class="form-horizontal" role="form">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
												<tr>
							<td width="25%">id:</td>
							<td width="25%">
								${authRole.id}
							</td>
						
						
							<td width="25%">编码:</td>
							<td width="25%">
								${authRole.code}
							</td>
						</tr>
						<tr>
							<td width="25%">名称:</td>
							<td width="25%">
								${authRole.name}
							</td>
						
						
							<td width="25%">主要职责:</td>
							<td width="25%">
								${authRole.majorDuty}
							</td>
						</tr>
						<tr>
							<td width="25%">备注:</td>
							<td width="25%">
								${authRole.remark}
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