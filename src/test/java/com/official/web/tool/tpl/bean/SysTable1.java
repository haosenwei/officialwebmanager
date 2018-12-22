package com.official.web.tool.tpl.bean;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 表结构,表结构实体类
 * 
 * @author hsw
 *
 */
public class SysTable1 implements Serializable {

	
	/** 主键 主键 */
	private Long tableId;
	
	/** 表名称 表名称 */
	private String tableName;
	
	/** 菜单名字 菜单名字 */
	private String menuName;
	
	/** 链接地址 链接地址 */
	private String url;
	
	/** 上级节点 上级节点 */
	private Long pid;
	
	/** 菜单主键 菜单主键 */
	private Long menuId;
	
	/** 备注 备注 */
	private String comment;
	
	/** get 主键 主键 ***/
	public Long getTableId() {
		return tableId;
	}
	
	/** set 主键 主键 ***/
	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}
	/** get 表名称 表名称 ***/
	public String getTableName() {
		return tableName;
	}
	
	/** set 表名称 表名称 ***/
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/** get 菜单名字 菜单名字 ***/
	public String getMenuName() {
		return menuName;
	}
	
	/** set 菜单名字 菜单名字 ***/
	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/** get 链接地址 链接地址 ***/
	public String getUrl() {
		return url;
	}
	
	/** set 链接地址 链接地址 ***/
	public void setUrl(String url) {
		this.url = url;
	}
	/** get 上级节点 上级节点 ***/
	public Long getPid() {
		return pid;
	}
	
	/** set 上级节点 上级节点 ***/
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/** get 菜单主键 菜单主键 ***/
	public Long getMenuId() {
		return menuId;
	}
	
	/** set 菜单主键 菜单主键 ***/
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	/** get 备注 备注 ***/
	public String getComment() {
		return comment;
	}
	
	/** set 备注 备注 ***/
	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "SysTable [tableId=" + tableId + ", tableName=" + tableName + ", menuName=" + menuName + ", url=" + url
				+ ", pid=" + pid + ", menuId=" + menuId + ", comment=" + comment + "]";
	}
	
}