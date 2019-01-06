layui.define([ "layer", "jquery", "table" ], function(exports) {
	var $ = layui.$, element = layui.element, table = layui.table;
	var obj = {
		getParam : function(formId) {
			var param = $("#" + formId).serializeArray();
			var where = {};
			$.each(param, function(i, field) {
				where[field.name] = field.value;
			});
			return where;
		},
		addTab : function(url, code, name) {
			var isExit = $("li[lay-id='" + code + "']");
			if (isExit.length > 0) {
				element.tabChange('demo', code);
			} else if (url) {
				$.get(url, function(data) {
					element.tabAdd('demo', {
						title : name,
						content : data, // 支持传入html
						id : code
					});
					element.tabChange('demo', code);
				});
			}
		},
		renderTable : function(code, url, colNames) {
			table.render({
				id : code+'TableTest',
				elem : '#'+code+'Table',
				url : url // 数据接口
				,page : true // 开启分页
				,cols : colNames,
				method : 'post' // 如果无需自定义HTTP类型，可不加该参数
				,request : {
					pageName : 'curr' // 页码的参数名称，默认：page
					,limitName : 'length' // 每页数据量的参数名，默认：limit
				},
				response : {
					statusName : 'status' // 规定数据状态的字段名称，默认：code
					,countName : 'recordsTotal' // 规定数据总数的字段名称，默认：count
				},
				where : obj.getParam(code+'_search_form')
			});
		},
		ajaxTableData : function(url, param,callback) {
//			$('#'+name).validate();
//			if(!$('#'+name).valid()){
//				return false;
//			}
//			var param=$("#"+name).serialize();
			$.ajax({
				type:'POST',
				url: url,
				data: param,
				success: function(data){
					if(typeof callback  == 'function'){
						callback();
					}else{
						var msg = "操作成功";
						if(data.msg){
							msg = data.msg ;
						}
						layer.msg(msg);
					}
				},
				error: function(data){
					var msg = "操作成功";
					if(data.msg){
						msg = data.msg ;
					}
					layer.msg(msg);
				}
			});
		}
	};
	exports("common", obj);
});