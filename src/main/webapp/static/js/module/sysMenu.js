layui.define(["layer","jquery"],function (exports) {
	var $ = layui.$,element = layui.element;
	var obj = {
			loadMenu : function(){
				// 进入首页后执行的程序
				// 加载菜单
				$.post("/sys/menu/getMyMenu",function(data){
					$.each(data,function(index ,value){
						var li = $("<li>",{
							"class":"layui-nav-item"
						});
						if(value.list.length>0){
							obj.addMenu(li,value);
						}else{
							var aHtml=$("<a>",{
								"class":"menu",
								"data-value":value.url,
								"href":"javascript:;",
								"text":value.name,
								"click":function(){
									obj.loadHtml(value.url);
								}
							});
							li.append(aHtml);
						}
						$('#menuID').append(li);
					});
					element.render('nav');
				});
			},
			addMenu : function(objLi,value){
				objLi.append('<a href="javascript:;">'+value.name+'</a>');
				var ddObj = $("<dl>",{
					"class":"layui-nav-child"
				});
				$.each(value.list,function(index,valueChild){
					if(valueChild.list.length>0){
						var ddChild = $("<dd>",{});
						obj.addMenu(ddChild,valueChild);
						ddObj.append(ddChild);
					}else{
						var aHtml=$("<a>",{
							"class":"menu",
							"data-value":valueChild.url,
							"href":"javascript:;",
							"text":valueChild.name,
							"click":function(){
								obj.loadHtml(valueChild.url,valueChild.name,valueChild.code);
							}
						});
						ddObj.append(aHtml);
					}
				});
				objLi.append(ddObj);
			},
			loadHtml :function (url,name,code){
				var isExit = $("li[lay-id='"+code+"']");
				if(isExit.length>0){
					element.tabChange('demo', code);
				}else if(url){
					$.get(url+"/main", function(data){
						element.tabAdd('demo', {
							title: name,
							content: data, // 支持传入html
							id: code
						});
						element.tabChange('demo', code);
					});
				}
			}
	}
	exports("sysMenu",obj);
});