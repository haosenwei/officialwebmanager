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
								${sysConfig.id}
							</td>
						
						
							<td width="25%">名称:</td>
							<td width="25%">
								${sysConfig.name}
							</td>
						</tr>
						<tr>
							<td width="25%">描述:</td>
							<td width="25%">
								${sysConfig.description}
							</td>
						
						
							<td width="25%">值:</td>
							<td width="25%">
								${sysConfig.val}
							</td>
						</tr>
						<tr>
							<td width="25%">类型:</td>
							<td width="25%">
								${sysConfig.type}
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