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
								${sysLog.id}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysLog.tableName}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysLog.valId}
							</td>
						
						
							<td width="25%">:</td>
							<td width="25%">
								${sysLog.dataJson}
							</td>
						</tr>
						<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysLog.createTime}
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