<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<title>访问记录表-${sessionScope.sysTitle}</title>

<div class="row">
	<div class="col-xs-12">
		<div class="row">
			<form id="accessRecordDialog_search_form" role="form" >
				<div class="col-md-2">
				<div class="form-group" >
					  <input type="text" class="form-control" onkeypress="if(event.keyCode==13) {accessRecord_aceSearch.click();return false;}"  name="search_name" placeholder="名称"  />
				</div>
				</div>
				<div class="col-md-2">
				<div class="form-group">
			        <button type="button" id="accessRecordDialog_aceSearch" class="btn btn-info btn-sm" data-rel="tooltip" title="查询" >
						<span class="ace-icon fa fa-search icon-on-right bigger-110" ></span>
					</button>
					<button type="button" id="accessRecordDialog_aceAdd" class="btn btn-info btn-sm  btn-success" data-rel="tooltip" title="添加">
						<span class="ace-icon fa fa-plus  icon-on-right bigger-110"  ></span>
					</button>
					<button type="button" id="accessRecordDialog_aceDels" class="btn btn-info btn-sm  btn-pink" data-rel="tooltip" title="删除">
						<span class="ace-icon fa fa-trash-o  icon-on-right bigger-110" ></span>
					</button>
				</div>
				</div>
			</form>
		</div>
		<!-- 查询条件 -->
	</div>
	<div class="col-xs-12">
		<table id="accessRecordDialog" class="table table-striped table-bordered table-hover" >
			<thead>
				<tr class="center">
					<td><label class="pos-rel"> <input type="checkbox" class="ace" name="accessRecord" /> <span class="lbl"></span>
					</label></td>
					<td>主键</td>
					<td>请求url</td>
					<td>请求资源</td>
					<td>查询参数</td>
					<td>访问者ip</td>
					<td>访问者的主机</td>
					<td>访问者浏览器</td>
					<td>访问者浏览器版本</td>
					<td>操作系统</td>
					<td>访问时间</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody></tbody>
		</table>
	</div>
</div>
<script type="text/javascript">

	//添加
	$('#accessRecordDialog_aceAdd').on('click',function() {
		aceAdd("添加访问记录表","${server}access/record/toAdd?${_csrf.parameterName}=${_csrf.token}","${server}access/record/doAdd?${_csrf.parameterName}=${_csrf.token}","accessRecord_add_form","accessRecordDialog");
	});
	//修改
	function aceEditf(id) {
		aceEdit(id,"修改访问记录表","${server}access/record/toEdit?${_csrf.parameterName}=${_csrf.token}","${server}access/record/doEdit?${_csrf.parameterName}=${_csrf.token}","accessRecord_edit_form","accessRecordDialog");
	}
	//查看
	function aceViewf(id) {
		aceView(id,"查看访问记录表","${server}access/record/toView?${_csrf.parameterName}=${_csrf.token}");
	}
	
	//删除
	function aceDelF(id) {
		aceDel(id , 'accessRecordDialog',"${server}access/record/del?${_csrf.parameterName}=${_csrf.token}");
	}
	
	$('.page-content-area').ace_ajax('loadScripts',[],function() {
		var columnsDialog=[
				{"data" : "accessRecord",className: "center","createdCell" : function(td, cellData,rowData, row,col) {
					createCheckCell(td, cellData,rowData, row,col);
					}
				},
				{"data" : "id",className: "center"}, 
				{"data" : "requestUrl",className: "center"}, 
				{"data" : "requestUri",className: "center"}, 
				{"data" : "queryString",className: "center"}, 
				{"data" : "remoteAddr",className: "center"}, 
				{"data" : "remoteHost",className: "center"}, 
				{"data" : "browser",className: "center"}, 
				{"data" : "browserVersion",className: "center"}, 
				{"data" : "operatingSystem",className: "center"}, 
				{"data" : "browsingTime",className: "center"}, 
				{"data" : "accessRecord",className: "center","createdCell":function(td, cellData,rowData, row,col){
					createCellAuth(td, cellData,rowData, row,col);
					}
				}
			];
		initMainTable("accessRecordDialog","${server}access/record/search?${_csrf.parameterName}=${_csrf.token}",columnsDialog);
		$('.page-content-area').ace_ajax('stopLoading', true);
	})
	
	//分页检索
	$('#accessRecordDialog_aceSearch').on('click',function() {
		$('#accessRecordDialog').DataTable().ajax.reload();
	});
</script>