layui.define(["layer","jquery"],function (exports) {
	var $ = layui.$,element = layui.element;
	var obj = {
		getParam : function(formId){
			var param = $("#"+formId).serializeArray();
			var where = {};
			$.each(param, function(i, field){
				where[field.name] = field.value;
			});
			return where;
		},
		addTab:function(url , code, name){
			var isExit = $("li[lay-id='"+code+"']");
			if(isExit.length>0){
				element.tabChange('demo', code);
			}else if(url){
				$.get(url, function(data){
					element.tabAdd('demo', {
						title: name,
						content: data, // 支持传入html
						id: code
					});
					element.tabChange('demo', code);
				});
			}
		}
	};
	exports("common",obj);
});