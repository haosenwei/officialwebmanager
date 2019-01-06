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
								${authRoleUser.id}
							</td>
						
						
							<td width="25%">用户id:</td>
							<td width="25%">
								${authRoleUser.userId}
							</td>
						</tr>
						<tr>
							<td width="25%">角色:</td>
							<td width="25%">
								${authRoleUser.roleId}
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