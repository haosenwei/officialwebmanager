<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>角色表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="authRoleDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {authRole_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="authRoleDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="authRoleDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="authRoleDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="authRoleDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="authRole" /> <span class="lbl"></span>
					</label></td>
					<td>id</td>
					<td>编码</td>
					<td>名称</td>
					<td>主要职责</td>
					<td>备注</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#authRoleDialog_aceAdd').on('click',function() {
		aceAdd("添加角色表","${server}auth/role/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}auth/role/doAdd?${_csrf.parameterName}=${_csrf.token}","authRole_add_form","authRoleDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改角色表","${server}auth/role/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}auth/role/doEdit?${_csrf.parameterName}=${_csrf.token}","authRole_edit_form","authRoleDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看角色表","${server}auth/role/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'authRoleDialog',"${server}auth/role/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "authRole",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "code",className: "center"}, 
				{"data" : "name",className: "center"}, 
				{"data" : "majorDuty",className: "center"}, 
				{"data" : "remark",className: "center"}, 
				{"data" : "authRole",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("authRoleDialog","${server}auth/role/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#authRoleDialog_aceSearch').on('click',function() {
		$('#authRoleDialog').DataTable().ajax.reload();
	});
</script>