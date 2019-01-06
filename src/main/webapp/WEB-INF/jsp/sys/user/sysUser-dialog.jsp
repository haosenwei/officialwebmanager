<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>用户表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysUserDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysUser_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysUserDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysUserDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysUserDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysUserDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysUser" /> <span class="lbl"></span>
					</label></td>
					<td>id</td>
					<td>姓名</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
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
	$('#sysUserDialog_aceAdd').on('click',function() {
		aceAdd("添加用户表","${server}sys/user/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}sys/user/doAdd?${_csrf.parameterName}=${_csrf.token}","sysUser_add_form","sysUserDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改用户表","${server}sys/user/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}sys/user/doEdit?${_csrf.parameterName}=${_csrf.token}","sysUser_edit_form","sysUserDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看用户表","${server}sys/user/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysUserDialog',"${server}sys/user/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "sysUser",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "name",className: "center"}, 
				{"data" : "code",className: "center"}, 
				{"data" : "username",className: "center"}, 
				{"data" : "password",className: "center"}, 
				{"data" : "email",className: "center"}, 
				{"data" : "tel",className: "center"}, 
				{"data" : "age",className: "center"}, 
				{"data" : "sysOrgId",className: "center"}, 
				{"data" : "ownerId",className: "center"}, 
				{"data" : "createTime",className: "center"}, 
				{"data" : "modifyTime",className: "center"}, 
				{"data" : "modifyUserId",className: "center"}, 
				{"data" : "sysUser",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysUserDialog","${server}sys/user/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysUserDialog_aceSearch').on('click',function() {
		$('#sysUserDialog').DataTable().ajax.reload();
	});
</script>