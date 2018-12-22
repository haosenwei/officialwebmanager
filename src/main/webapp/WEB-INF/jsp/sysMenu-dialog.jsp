<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>菜单表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysMenuDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysMenu_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysMenuDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysMenuDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysMenuDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysMenuDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysMenu" /> <span class="lbl"></span>
					</label></td>
					<td></td>
					<td>编码</td>
					<td>类型</td>
					<td>菜单名称</td>
					<td>上级节点</td>
					<td>状态</td>
					<td>地址</td>
					<td>路径</td>
					<td>图标</td>
					<td>排序</td>
					<td>备注</td>
					<td>创建时间</td>
					<td>修改者</td>
					<td>修改时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#sysMenuDialog_aceAdd').on('click',function() {
		aceAdd("添加菜单表","${server}toAdd?${_csrf.parameterName}=${_csrf.token}","${server}doAdd?${_csrf.parameterName}=${_csrf.token}","sysMenu_add_form","sysMenuDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改菜单表","${server}toEdit?${_csrf.parameterName}=${_csrf.token}","${server}doEdit?${_csrf.parameterName}=${_csrf.token}","sysMenu_edit_form","sysMenuDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看菜单表","${server}toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysMenuDialog',"${server}del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "sysMenu",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "code",className: "center"}, 
				{"data" : "typeDic",className: "center"}, 
				{"data" : "name",className: "center"}, 
				{"data" : "pid",className: "center"}, 
				{"data" : "statusDic",className: "center"}, 
				{"data" : "url",className: "center"}, 
				{"data" : "path",className: "center"}, 
				{"data" : "icon",className: "center"}, 
				{"data" : "sort",className: "center"}, 
				{"data" : "remark",className: "center"}, 
				{"data" : "createTime",className: "center"}, 
				{"data" : "modifyUerId",className: "center"}, 
				{"data" : "modifyTime",className: "center"}, 
				{"data" : "sysMenu",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysMenuDialog","${server}search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysMenuDialog_aceSearch').on('click',function() {
		$('#sysMenuDialog').DataTable().ajax.reload();
	});
</script>