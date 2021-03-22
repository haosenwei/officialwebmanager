<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/g4m" prefix="o" %>

<title>${title}-${sessionScope.sysTitle}</title>
<style>
tbody .layui-table-cell{
    height:100px;
    line-height: 100px;
}
</style>
<div class="layui-row">
	<div class="layui-col-md12">
		<form class="layui-form" id="authRole_search_form" action="#">
			<div class="layui-row">
				<div class="layui-col-md3">
					<div class="layui-form-item">
						<label class="layui-form-label">输入框</label>
						<div class="layui-input-block">
							<input type="text" name="search_code" required lay-verify="required" placeholder="请输入标题" autocomplete="off" class="layui-input">
						</div>
					</div>
				</div>
				<div class="layui-col-md4">
					<a id="authRole_search_btn" class="layui-btn">搜索</a>
					<a id="authRole_reset" class="layui-btn">重置</a>
					<a id="authRole_add" class="layui-btn">新增</a> <a id="authRole_dels" class="layui-btn">删除</a>
				</div>
			</div>
		</form>
	</div>
	<div class="layui-col-md12">
		<table id="authRoleTable" lay-filter="authRoleTable"></table>
	</div>
</div>
<script>
	layui.use(['jquery', 'common' ], function() {
		var table = layui.table ,$ = layui.jquery, common = layui.common;
		var colNames = [[ //表头
			{
				checkbox : true
			},
            <c:forEach var="field" items="${fields}">
            { field : "${field.columnName}", title : "${field.comment}" ,height:120 },
            </c:forEach>
            { templet: '#img' },
            { templet: '#authRoleBarDemo' }
             ]];
		common.renderTable('authRole',"${server}${path}/search?${_csrf.parameterName}=${_csrf.token}",colNames);
		$(document).on('click', '#authRole_search_btn', function() {
			table.reload('authRoleTableTest', {
				where : common.getParam('authRole_search_form'),
				page : {
					curr : 0//重新从第 1 页开始
				}
			});
		});
        //监听表格复选框选择
        table.on('checkbox(authRoleTable)', function(obj){
            console.log(obj)
        });
        //监听工具条
        table.on('tool(authRoleTable)', function(obj){
            var data = obj.data;
            if(obj.event === 'detail'){
                common.addTab("${server}${path}/toEdit?${_csrf.parameterName}=${_csrf.token}&id="+data.id, 'authRole_edit', '编辑${title}');
            } else if(obj.event === 'del'){
              layer.confirm('真的删除行么', function(index){
                obj.del();
                layer.close(index);
              });
            } else if(obj.event === 'edit'){
                common.addTab("${server}${path}/toEdit?${_csrf.parameterName}=${_csrf.token}&id="+data.id, 'authRole_edit', '编辑${title}');
            }
          });
		$("#authRole_add").off('click').on('click', function(){
			common.addTab("${server}${path}/toAdd?${_csrf.parameterName}=${_csrf.token}", 'authRole_add', '新增${title}'); //url , code, name
		});
	});
</script>
<script type="text/html" id="authRoleBarDemo">
  <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script type="text/html" id="img">
<img src="https://i1.nsfile.com/avatar/920/896/96/571342723064401920/571343031635152896.jpg@!am" style="height:120px">
</script>
