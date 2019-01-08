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

					<td>表名称</td>
					<td>菜单名字</td>
					<td>链接地址</td>
					<td>上级节点</td>

					<td>备注</td>
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
		aceEdit(id,"修改表字段","${server}sys/tablefield/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}sys/tablefield/doEdit?${_csrf.parameterName}=${_csrf.token}","sysTableField_edit_form","sysTableFieldMain");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看表字段","${server}sys/tablefield/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysTableFieldMain',"${server}sys/tablefield/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columns=[
				{"data" : "tableId",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "tableName",className: "center"}, 
				{"data" : "menuName",className: "center"}, 
				{"data" : "url",className: "center"}, 
				{"data" : "pid",className: "center"}, 
				{"data" : "comment",className: "center"}, 
				{"data" : "tableId",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysTableFieldMain","${server}sys/tablefield/search?${_csrf.parameterName}=${_csrf.token}",columns);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysTableFieldMain_aceSearch').on('click',function() {
		$('#sysTableFieldMain').DataTable().ajax.reload();
	});
	//添加
	$('#sysTableFieldMain_aceAdd').on('click',function() {
		aceAdd("添加表字段","${server}sys/tablefield/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}sys/tablefield/doAdd?${_csrf.parameterName}=${_csrf.token}","sysTableField_add_form","sysTableFieldMain");
	});
	//批量删除
	$('#sysTableFieldMain_aceDels').on('click',function() {
		aceDels("确定删除？","${server}sys/tablefield/dels?${_csrf.parameterName}=${_csrf.token}","sysTableFieldMain");
	});
</script>