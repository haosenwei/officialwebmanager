<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>菜单详情表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysMenuFieldDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysMenuField_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysMenuFieldDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysMenuFieldDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysMenuFieldDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysMenuFieldDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysMenuField" /> <span class="lbl"></span>
					</label></td>
					<td></td>
					<td>表主键</td>
					<td>名称(英文),分隔符_</td>
					<td>字段类型</td>
					<td>字段类型</td>
					<td>字段长度</td>
					<td>主键标识</td>
					<td>页面类型</td>
					<td>评论</td>
					<td>备注</td>
					<td>列表页面展示</td>
					<td>新建页面是否可以修改</td>
					<td>新增页面展示</td>
					<td>详情页面展示</td>
					<td>修改页面是否可修改</td>
					<td>修改页面类型</td>
					<td>排序</td>
					<td>默认值</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#sysMenuFieldDialog_aceAdd').on('click',function() {
		aceAdd("添加菜单详情表","${server}sys/menu/field/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}sys/menu/field/doAdd?${_csrf.parameterName}=${_csrf.token}","sysMenuField_add_form","sysMenuFieldDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改菜单详情表","${server}sys/menu/field/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}sys/menu/field/doEdit?${_csrf.parameterName}=${_csrf.token}","sysMenuField_edit_form","sysMenuFieldDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看菜单详情表","${server}sys/menu/field/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysMenuFieldDialog',"${server}sys/menu/field/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "sysMenuField",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "menuId",className: "center"}, 
				{"data" : "columnName",className: "center"}, 
				{"data" : "dataType",className: "center"}, 
				{"data" : "columnType",className: "center"}, 
				{"data" : "flength",className: "center"}, 
				{"data" : "keyDic",className: "center"}, 
				{"data" : "jspTypeDic",className: "center"}, 
				{"data" : "comment",className: "center"}, 
				{"data" : "remark",className: "center"}, 
				{"data" : "listTypeDic",className: "center"}, 
				{"data" : "addIsEdit",className: "center"}, 
				{"data" : "addTypeDic",className: "center"}, 
				{"data" : "viewTypeDic",className: "center"}, 
				{"data" : "editIsEdit",className: "center"}, 
				{"data" : "editTypeDic",className: "center"}, 
				{"data" : "orderBy",className: "center"}, 
				{"data" : "defaultValue",className: "center"}, 
				{"data" : "sysMenuField",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysMenuFieldDialog","${server}sys/menu/field/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysMenuFieldDialog_aceSearch').on('click',function() {
		$('#sysMenuFieldDialog').DataTable().ajax.reload();
	});
</script>