<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>用户角色表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="authRoleUserDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {authRoleUser_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="authRoleUserDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="authRoleUserDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="authRoleUserDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="authRoleUserDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="authRoleUser" /> <span class="lbl"></span>
					</label></td>
					<td></td>
					<td>用户id</td>
					<td>角色</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#authRoleUserDialog_aceAdd').on('click',function() {
		aceAdd("添加用户角色表","${server}auth/role/user/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}auth/role/user/doAdd?${_csrf.parameterName}=${_csrf.token}","authRoleUser_add_form","authRoleUserDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改用户角色表","${server}auth/role/user/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}auth/role/user/doEdit?${_csrf.parameterName}=${_csrf.token}","authRoleUser_edit_form","authRoleUserDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看用户角色表","${server}auth/role/user/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'authRoleUserDialog',"${server}auth/role/user/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "authRoleUser",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "userId",className: "center"}, 
				{"data" : "roleId",className: "center"}, 
				{"data" : "authRoleUser",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("authRoleUserDialog","${server}auth/role/user/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#authRoleUserDialog_aceSearch').on('click',function() {
		$('#authRoleUserDialog').DataTable().ajax.reload();
	});
</script>