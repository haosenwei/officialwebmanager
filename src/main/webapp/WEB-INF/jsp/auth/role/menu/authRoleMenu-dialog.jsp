<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>角色菜单-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="authRoleMenuDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {authRoleMenu_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="authRoleMenuDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="authRoleMenuDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="authRoleMenuDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="authRoleMenuDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="authRoleMenu" /> <span class="lbl"></span>
					</label></td>
					<td>主键</td>
					<td>菜单id</td>
					<td>角色id</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#authRoleMenuDialog_aceAdd').on('click',function() {
		aceAdd("添加角色菜单","${server}auth/role/menu/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}auth/role/menu/doAdd?${_csrf.parameterName}=${_csrf.token}","authRoleMenu_add_form","authRoleMenuDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改角色菜单","${server}auth/role/menu/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}auth/role/menu/doEdit?${_csrf.parameterName}=${_csrf.token}","authRoleMenu_edit_form","authRoleMenuDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看角色菜单","${server}auth/role/menu/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'authRoleMenuDialog',"${server}auth/role/menu/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "authRoleMenu",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "menuId",className: "center"}, 
				{"data" : "roleId",className: "center"}, 
				{"data" : "authRoleMenu",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("authRoleMenuDialog","${server}auth/role/menu/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#authRoleMenuDialog_aceSearch').on('click',function() {
		$('#authRoleMenuDialog').DataTable().ajax.reload();
	});
</script>