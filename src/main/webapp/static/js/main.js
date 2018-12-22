
function loadMenu(){
	//进入首页后执行的程序
	//加载菜单
	$.post("/sys/menu/getMyMenu",function(data){
		$.each(data,function(index ,value){
			var li = $("<li>",{
				"class":"layui-nav-item"
			});
			if(value.list.length>0){
				addMenu(li,value);
			}else{
				var aHtml=$("<a>",{
					"class":"menu",
					"data-value":value.url,
					"href":"javascript:;",
					"text":value.name,
					"click":function(){
						loadHtml(value.url);
					}
				});
				li.append(aHtml);
			}
			$('#menuID').append(li);
		});
	});
	function addMenu(obj,value){
		obj.append('<a href="javascript:;">'+value.name+'</a>');
		var ddObj = $("<dl>",{
			"class":"layui-nav-child"
		});
		$.each(value.list,function(index,valueChild){
			if(valueChild.list.length>0){
				var ddChild = $("<dd>",{});
				addMenu(ddChild,valueChild);
				ddObj.append(ddChild);
			}else{
				var aHtml=$("<a>",{
					"class":"menu",
					"data-value":valueChild.url,
					"href":"javascript:;",
					"text":valueChild.name,
					"click":function(){
						loadHtml(valueChild.url,valueChild.name,valueChild.code);
					}
				});
				ddObj.append(aHtml);
//				ddObj.append('<dd><a class="menu" data-value="'+valueChild.url+'" href="javascript:loadHtml(this);">'+valueChild.name+'</a></dd>');
			}
		});
		obj.append(ddObj);
	};
}
function loadHtml(url,name,code){
	var isExit = $("li[lay-id='"+code+"']");
	if(isExit.length>0){
		layui.use(['element'], function(){
			var element = layui.element;
			element.tabChange('demo', code);
//			element.tabAdd('demo', {
//				title: '选项卡的标题',
//				content: data, //支持传入html
//				id: 11414
//			});
		});
	}else if(url){
		$.get(url+"/main", function(data){
			layui.use(['element'], function(){
				var element = layui.element;
				element.tabAdd('demo', {
					title: name,
					content: data, //支持传入html
					id: code
				});
				element.tabChange('demo', code);
			});
		});
	}
}
