layui.define([ "layer", "jquery" ],
		function(exports) {
			var $ = layui.$, element = layui.element;
			var obj = {
				loadMenu : function() {
					// 进入首页后执行的程序
					// 加载菜单
					$.post("/sys/menu/getMyMenu", function(data) {
						$.each(data, function(index, value) {
							var li = $("<li>", {
								"class" : "layui-nav-item"
							});
							if (value.list.length > 0) {
								obj.addMenu(li, value);
							} else {
								obj.clickMenu(li, value,'li');
							}
							$('#menuID').append(li);
						});
						element.render('nav');
					});
				},
				clickMenu : function(li, value,type) {
					var code = obj.getUrlParam('code');
					var aHtml = $("<a>", {
						"class" : "menu",
						"data-value" : value.id,
						"href" : "javascript:;",
						"text" : value.name,
						"click" : function() {
							obj.loadHtml(value.id, value.name, value.code);
						}
					});
					if(type=='dd'){
						var dd = $("<dd>",{});
						dd.append(aHtml);
						li.append(dd);
					}else{
						li.append(aHtml);
					}
					if (code && value.code == code) {
						obj.loadHtml(value.id, value.name, value.code);
					}
				},
				addMenu : function(objLi, value) {
					objLi.append('<a href="javascript:;">' + value.name + '</a>');
					var ddObj = $("<dl>", {
						"class" : "layui-nav-child"
					});
					$.each(value.list, function(index, valueChild) {
						if (valueChild.list.length > 0) {
							var ddChild = $("<dd>", {});
							obj.addMenu(ddChild, valueChild);
							ddObj.append(ddChild);
						} else {
							// var aHtml=$("<a>",{
							// "class":"menu",
							// "data-value":valueChild.url,
							// "href":"javascript:;",
							// "text":valueChild.name,
							// "click":function(){
							// obj.loadHtml(valueChild.id,valueChild.name,valueChild.code);
							// }
							// });
							// ddObj.append(aHtml);
							obj.clickMenu(ddObj, valueChild,'dd');
						}
					});
					objLi.append(ddObj);
				},
				loadHtml : function(id, name, code) {
					var isExit = $("li[lay-id='" + code + "']");
					if (isExit.length > 0) {
						element.tabChange('demo', code);
					} else if (id) {
						$.get("menu/" + id + "/main", function(data) {
							element.tabAdd('demo', {
								title : name,
								content : data, // 支持传入html
								id : code
							});
							element.tabChange('demo', code);
						});
					}
					obj.UpdateUrlParam('code', code);
					// obj.changeURLArg(code);
				},
				changeURLArg : function(code) {
					var url = window.location.href;
					var arg = 'code';
					var arg_val = code;
					var pattern = arg + '=([^&]*)';
					var replaceText = arg + '=' + arg_val;
					if (url.match(pattern)) {
						var tmp = '/(' + arg + '=)([^&]*)/gi';
						tmp = url.replace(eval(tmp), replaceText);
						return tmp;
					} else {
						if (url.match('[\?]')) {
							return url + '&' + replaceText;
						} else {
							return url + '?' + replaceText;
						}
					}
					// return url+'\n'+arg+'\n'+arg_val;
					window.location.href = url + '\n' + arg + '\n' + arg_val;
				},
				// 添加 或者 修改 url中参数的值
				UpdateUrlParam : function(name, val) {
					var thisURL = document.location.href;
					// 如果 url中包含这个参数 则修改
					if (thisURL.indexOf(name + '=') > 0) {
						var v = obj.getUrlParam(name);
						if (v != null) {
							// 是否包含参数
							thisURL = thisURL.replace(name + '=' + v, name + '=' + val);
						} else {
							thisURL = thisURL.replace(name + '=', name + '=' + val);
						}
					} // 不包含这个参数 则添加
					else {
						if (thisURL.indexOf("?") > 0) {
							thisURL = thisURL + "&" + name + "=" + val;
						} else {
							thisURL = thisURL + "?" + name + "=" + val;
						}
					}
//					location.href = thisURL;
					window.history.pushState({}, "", thisURL);
				},
				getUrlParam : function(name) {
					var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)"); // 构造一个含有目标参数的正则表达式对象
					var r = window.location.search.substr(1).match(reg); // 匹配目标参数
					if (r != null) {
						return unescape(r[2]);
					}
					return null; // 返回参数值
				}
			}
			exports("sysMenu", obj);
		});