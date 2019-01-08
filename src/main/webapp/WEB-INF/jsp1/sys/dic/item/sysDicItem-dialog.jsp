<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>数据字典详情表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="sysDicItemDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {sysDicItem_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="sysDicItemDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="sysDicItemDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="sysDicItemDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="sysDicItemDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="sysDicItem" /> <span class="lbl"></span>
					</label></td>
					<td>主键</td>
					<td>分组id</td>
					<td>名称</td>
					<td>编码</td>
					<td>备注</td>
					<td>状态</td>
					<td>排序</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#sysDicItemDialog_aceAdd').on('click',function() {
		aceAdd("添加数据字典详情表","${server}sys/dic/item/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}sys/dic/item/doAdd?${_csrf.parameterName}=${_csrf.token}","sysDicItem_add_form","sysDicItemDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改数据字典详情表","${server}sys/dic/item/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}sys/dic/item/doEdit?${_csrf.parameterName}=${_csrf.token}","sysDicItem_edit_form","sysDicItemDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看数据字典详情表","${server}sys/dic/item/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'sysDicItemDialog',"${server}sys/dic/item/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "sysDicItem",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "groupId",className: "center"}, 
				{"data" : "code",className: "center"}, 
				{"data" : "name",className: "center"}, 
				{"data" : "remark",className: "center"}, 
				{"data" : "status",className: "center"}, 
				{"data" : "sort",className: "center"}, 
				{"data" : "sysDicItem",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("sysDicItemDialog","${server}sys/dic/item/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#sysDicItemDialog_aceSearch').on('click',function() {
		$('#sysDicItemDialog').DataTable().ajax.reload();
	});
</script>