<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>日志表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysLogDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysLog_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysLogDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysLogDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysLogDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysLogDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysLog" /> <span class="lbl"></span>
					</label></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#sysLogDialog_aceAdd').on('click',function() {
		aceAdd("添加日志表","${server}sys/log/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}sys/log/doAdd?${_csrf.parameterName}=${_csrf.token}","sysLog_add_form","sysLogDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改日志表","${server}sys/log/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}sys/log/doEdit?${_csrf.parameterName}=${_csrf.token}","sysLog_edit_form","sysLogDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看日志表","${server}sys/log/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysLogDialog',"${server}sys/log/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "sysLog",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "tableName",className: "center"}, 
				{"data" : "valId",className: "center"}, 
				{"data" : "dataJson",className: "center"}, 
				{"data" : "createTime",className: "center"}, 
				{"data" : "sysLog",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysLogDialog","${server}sys/log/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysLogDialog_aceSearch').on('click',function() {
		$('#sysLogDialog').DataTable().ajax.reload();
	});
</script>