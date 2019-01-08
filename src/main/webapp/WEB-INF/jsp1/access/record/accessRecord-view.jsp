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
								${accessRecord.id}
							</td>
						
						
							<td width="25%">请求url:</td>
							<td width="25%">
								${accessRecord.requestUrl}
							</td>
						</tr>
						<tr>
							<td width="25%">请求资源:</td>
							<td width="25%">
								${accessRecord.requestUri}
							</td>
						
						
							<td width="25%">查询参数:</td>
							<td width="25%">
								${accessRecord.queryString}
							</td>
						</tr>
						<tr>
							<td width="25%">访问者ip:</td>
							<td width="25%">
								${accessRecord.remoteAddr}
							</td>
						
						
							<td width="25%">访问者的主机:</td>
							<td width="25%">
								${accessRecord.remoteHost}
							</td>
						</tr>
						<tr>
							<td width="25%">访问者浏览器:</td>
							<td width="25%">
								${accessRecord.browser}
							</td>
						
						
							<td width="25%">访问者浏览器版本:</td>
							<td width="25%">
								${accessRecord.browserVersion}
							</td>
						</tr>
						<tr>
							<td width="25%">操作系统:</td>
							<td width="25%">
								${accessRecord.operatingSystem}
							</td>
						
						
							<td width="25%">访问时间:</td>
							<td width="25%">
								${accessRecord.browsingTime}
							</td>
						</tr>

					</tbody>
				</table>
			 </form>
		</div>
	</div>
</div>