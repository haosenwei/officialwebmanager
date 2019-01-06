<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysConfigDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysConfig_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysConfigDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysConfigDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysConfigDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysConfigDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysConfig" /> <span class="lbl"></span>
					</label></td>
					<td>主键</td>
					<td>名称</td>
					<td>描述</td>
					<td>值</td>
					<td>类型</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#sysConfigDialog_aceAdd').on('click',function() {
		aceAdd("添加","${server}sys/config/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}sys/config/doAdd?${_csrf.parameterName}=${_csrf.token}","sysConfig_add_form","sysConfigDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改","${server}sys/config/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}sys/config/doEdit?${_csrf.parameterName}=${_csrf.token}","sysConfig_edit_form","sysConfigDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看","${server}sys/config/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysConfigDialog',"${server}sys/config/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "sysConfig",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "name",className: "center"}, 
				{"data" : "description",className: "center"}, 
				{"data" : "val",className: "center"}, 
				{"data" : "type",className: "center"}, 
				{"data" : "sysConfig",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysConfigDialog","${server}sys/config/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysConfigDialog_aceSearch').on('click',function() {
		$('#sysConfigDialog').DataTable().ajax.reload();
	});
</script>