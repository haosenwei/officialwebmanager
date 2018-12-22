package com.official.web.tool.tpl.bean;

import java.util.ArrayList;
import java.util.List;

public class TableInfo {
	/** 表名 **/
	private String table_name; // sys_role
	
	/** 表名 **/
	private String tableName; // sysRole
	
	/** 表名 **/
	private String tableNameU; // sysRole

	/** 表中文名字 **/
	private String menuName; // 系统菜单
	
	
	private String javaFileSuffix;  //   = sys/ 
	
	private String namespageSuffix;  //   =.sys
	
	private String jspFileSuffix;  //     =sys/role/

	/** 菜单链接 **/
	private String url; // sys/role

	/** 作者 **/
	private String author; // hsw
	
	/** 评论 **/
	private String comment;

	private List<TableField> list = new ArrayList<TableField>();

	public String getTable_name() {
		return table_name;
	}

	public void setTable_name(String table_name) {
		this.table_name = table_name;
	}

	public String getTableName() {
		String result = "";
		String[] split = getTable_name().split("_");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			if (i == 0) {
				result += string;
				continue;
			}
			result += string.substring(0, 1).toUpperCase() + string.substring(1);
		}
		return result; 
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public String getTableNameU() {
		String result = "";
		String[] split = getTable_name().split("_");
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			result += string.substring(0, 1).toUpperCase() + string.substring(1);
		}
		return result; 
	}

	public void setTableNameU(String tableNameU) {
		this.tableNameU = tableNameU;
	}

	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}
	/** return  sys/ **/
	public String getJavaFileSuffix() {
		String result = "";
		String[] split = getUrl().split("/");
		for (int i = 0; i < split.length-1; i++) {
			result+=split[i]+"/";
		}
		return result;
	}

	public void setJavaFileSuffix(String javaFileSuffix) {
		this.javaFileSuffix = javaFileSuffix;
	}
	/**return .sys **/
	public String getNamespageSuffix() {
		String result = "";
		String[] split = getUrl().split("/");
		for (int i = 0; i < split.length-1; i++) {
			result+="."+split[i];
		}
		return result;
	}

	public void setNamespageSuffix(String namespageSuffix) {
		this.namespageSuffix = namespageSuffix;
	}
	/**return sys/role/**/
	public String getJspFileSuffix() {
		String result = "";
		String[] split = getUrl().split("/");
		for (int i = 0; i < split.length; i++) {
			result+=split[i]+"/";
		}
		return result;
	}

	public void setJspFileSuffix(String jspFileSuffix) {
		this.jspFileSuffix = jspFileSuffix;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public List<TableField> getList() {
		return list;
	}

	public void setList(List<TableField> list) {
		this.list = list;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}
}
