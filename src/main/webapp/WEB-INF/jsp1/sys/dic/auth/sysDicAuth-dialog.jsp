<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>菜单字典权限-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysDicAuthDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysDicAuth_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysDicAuthDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysDicAuthDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysDicAuthDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysDicAuthDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysDicAuth" /> <span class="lbl"></span>
					</label></td>
					<td>主键</td>
					<td>fieldid</td>
					<td>数据字典项id</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#sysDicAuthDialog_aceAdd').on('click',function() {
		aceAdd("添加菜单字典权限","${server}sys/dic/auth/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}sys/dic/auth/doAdd?${_csrf.parameterName}=${_csrf.token}","sysDicAuth_add_form","sysDicAuthDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改菜单字典权限","${server}sys/dic/auth/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}sys/dic/auth/doEdit?${_csrf.parameterName}=${_csrf.token}","sysDicAuth_edit_form","sysDicAuthDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看菜单字典权限","${server}sys/dic/auth/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysDicAuthDialog',"${server}sys/dic/auth/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "sysDicAuth",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "sysMenuFieldId",className: "center"}, 
				{"data" : "sysDicItemId",className: "center"}, 
				{"data" : "sysDicAuth",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysDicAuthDialog","${server}sys/dic/auth/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysDicAuthDialog_aceSearch').on('click',function() {
		$('#sysDicAuthDialog').DataTable().ajax.reload();
	});
</script>