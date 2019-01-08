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
								${authRoleMenu.id}
							</td>
						
						
							<td width="25%">菜单id:</td>
							<td width="25%">
								${authRoleMenu.menuId}
							</td>
						</tr>
						<tr>
							<td width="25%">角色id:</td>
							<td width="25%">
								${authRoleMenu.roleId}
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