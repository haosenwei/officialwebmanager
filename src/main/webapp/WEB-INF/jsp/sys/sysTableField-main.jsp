<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>表字段-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysTableFieldMain_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysTableFieldMain_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysTableFieldMain_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysTableFieldMain_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysTableFieldMain_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysTableFieldMain" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysTableField" /> <span class="lbl"></span>
					</label></td>
					<td></td>
					<td>表主键</td>
					<td>字段名称</td>
					<td>字段类型</td>
					<td>字段类型</td>
					<td>字段长度</td>
					<td>主键标识</td>
					<td>页面类型</td>
					<td>评论</td>
					<td>备注</td>
					<td>列表页面展示</td>
					<td>新增页面展示</td>
					<td>详情页面展示</td>
					<td>修改页面类型</td>
					<td>排序</td>
					<td></td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//修改
	function aceEditf(id) {
		aceEdit(id,"修改表字段","${server}systoEdit?${_csrf.parameterName}=${_csrf.token}","${server}sysdoEdit?${_csrf.parameterName}=${_csrf.token}","sysTableField_edit_form","sysTableFieldMain");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看表字段","${server}systoView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysTableFieldMain',"${server}sysdel?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columns=[
				{"data" : "",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
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
				{"data" : "addTypeDic",className: "center"}, 
				{"data" : "viewTypeDic",className: "center"}, 
				{"data" : "editTypeDic",className: "center"}, 
				{"data" : "orderBy",className: "center"}, 
				{"data" : "defaultValue",className: "center"}, 
				{"data" : "",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysTableFieldMain","${server}syssearch?${_csrf.parameterName}=${_csrf.token}",columns);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysTableFieldMain_aceSearch').on('click',function() {
		$('#sysTableFieldMain').DataTable().ajax.reload();
	});
	//添加
	$('#sysTableFieldMain_aceAdd').on('click',function() {
		aceAdd("添加表字段","${server}systoAdd?${_csrf.parameterName}=${_csrf.token}","${server}sysdoAdd?${_csrf.parameterName}=${_csrf.token}","sysTableField_add_form","sysTableFieldMain");
	});
	//批量删除
	$('#sysTableFieldMain_aceDels').on('click',function() {
		aceDels("确定删除？","${server}sysdels?${_csrf.parameterName}=${_csrf.token}","sysTableFieldMain");
	});
</script>