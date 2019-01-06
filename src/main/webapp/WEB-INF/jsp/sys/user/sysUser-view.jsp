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
								${sysUser.id}
							</td>
						
						
							<td width="25%">姓名:</td>
							<td width="25%">
								${sysUser.name}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.code}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.username}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.password}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.email}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.tel}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.age}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.sysOrgId}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.ownerId}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.createTime}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.modifyTime}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysUser.modifyUserId}
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