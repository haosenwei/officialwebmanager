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
								${sysDicAuth.id}
							</td>
						
						
							<td width="25%">fieldid:</td>
							<td width="25%">
								${sysDicAuth.sysMenuFieldId}
							</td>
						</tr>
						<tr>
							<td width="25%">数据字典项id:</td>
							<td width="25%">
								${sysDicAuth.sysDicItemId}
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