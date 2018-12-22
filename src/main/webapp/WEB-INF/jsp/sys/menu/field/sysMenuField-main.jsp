<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<title>菜单详情表-${sessionScope.sysTitle}</title>

<div class="layui-row">
	<div class="layui-col-md12">
		<div class="layui-form-item">
			<div class="layui-inline">
				<label class="layui-form-label">范围</label>
				<div class="layui-input-inline" style="width: 100px;">
					<input type="text" name="price_min" placeholder="￥" autocomplete="off" class="layui-input">
				</div>
				<div class="layui-form-mid">-</div>
				<div class="layui-input-inline" style="width: 100px;">
					<input type="text" name="price_max" placeholder="￥" autocomplete="off" class="layui-input">
				</div>
			</div>

			<div class="layui-inline">
				<label class="layui-form-label">密码</label>
				<div class="layui-input-inline" style="width: 100px;">
					<input type="password" name="" autocomplete="off" class="layui-input">
				</div>
			</div>
		</div>
	</div>
	<div class="layui-col-md12">
		<table id="demo" lay-filter="test"></table>
	</div>
</div>
<script>
	layui.use('table', function() {
		var table = layui.table;
		//第一个实例
		table.render({
			id: 'id',
			elem : '#demo',
			height : 500,
			url : '/sys/menu/field/search' //数据接口
			, page : true //开启分页
			, cols : [[ //表头
				{checkbox: true},
			{field : "id"           ,LAY_CHECKED:false,type:'radio',title : "id" 		   },   
			{field : "id"           ,title : "id" 		   },   
			{field : "menuId"       ,title : "menuId"      },   
			{field : "columnName"   ,title : "columnName"  },   
			{field : "dataType"     ,title : "dataType"    },   
			{field : "columnType"   ,title : "columnType"  },   
			{field : "flength"      ,title : "flength"     },   
			{field : "keyDic"       ,title : "keyDic"      },
			{field : "jspTypeDic"   ,title : "jspTypeDic"  },
			{field : "comment"      ,title : "comment"     },
			{field : "remark"       ,title : "remark"      }
			                                 
			
			
			]]
			,method: 'get' //如果无需自定义HTTP类型，可不加该参数
			,request: {
				pageName: 'offset' //页码的参数名称，默认：page
			   ,limitName: 'length' //每页数据量的参数名，默认：limit
			}

		});
	});
</script>