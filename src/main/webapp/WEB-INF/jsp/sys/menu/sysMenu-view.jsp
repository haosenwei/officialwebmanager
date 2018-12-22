<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<div class="row">
	<div class="col-xs-12">
	<div class="table-responsive">
			<form id="input_form" class="form-horizontal" role="form">
				<table class="table table-striped table-bordered table-hover">
					<tbody>
												<tr>
							<td width="25%">:</td>
							<td width="25%">
								${sysMenu.id}
							</td>
						
						
							<td width="25%">编码:</td>
							<td width="25%">
								${sysMenu.code}
							</td>
						</tr>
						<tr>
							<td width="25%">类型:</td>
							<td width="25%">
								${sysMenu.typeDic}
							</td>
						
						
							<td width="25%">菜单名称:</td>
							<td width="25%">
								${sysMenu.name}
							</td>
						</tr>
						<tr>
							<td width="25%">上级节点:</td>
							<td width="25%">
								${sysMenu.pid}
							</td>
						
						
							<td width="25%">状态:</td>
							<td width="25%">
								${sysMenu.statusDic}
							</td>
						</tr>
						<tr>
							<td width="25%">地址:</td>
							<td width="25%">
								${sysMenu.url}
							</td>
						
						
							<td width="25%">路径:</td>
							<td width="25%">
								${sysMenu.path}
							</td>
						</tr>
						<tr>
							<td width="25%">图标:</td>
							<td width="25%">
								${sysMenu.icon}
							</td>
						
						
							<td width="25%">排序:</td>
							<td width="25%">
								${sysMenu.sort}
							</td>
						</tr>
						<tr>
							<td width="25%">备注:</td>
							<td width="25%">
								${sysMenu.remark}
							</td>
						
						
							<td width="25%">创建时间:</td>
							<td width="25%">
								${sysMenu.createTime}
							</td>
						</tr>
						<tr>
							<td width="25%">修改者:</td>
							<td width="25%">
								${sysMenu.modifyUerId}
							</td>
						
						
							<td width="25%">修改时间:</td>
							<td width="25%">
								${sysMenu.modifyTime}
							</td>
						</tr>

					</tbody>
				</table>
			 </form>
		</div>
	</div>
</div>