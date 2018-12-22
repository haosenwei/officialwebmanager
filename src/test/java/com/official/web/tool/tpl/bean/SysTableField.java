package com.official.web.tool.tpl.bean;

import java.io.Serializable;


/**
 * 表字段,表字段实体类
 * 
 * @author hsw
 *
 */
public class SysTableField implements Serializable {

	private Long id;
	private Long menuId;
	private String columnName;
	private String dataType;
	private String columnType;
	private String flength;
	private String keyDic;
	private String jspTypeDic;
	private String comment;
	private String remark;
	private String listTypeDic;
	private String addTypeDic;
	private String viewTypeDic;
	private String editTypeDic;
	private String orderBy;
	private String defaultValue;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMenuId() {
		return menuId;
	}

	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	public String getDataType() {
		return dataType;
	}

	public void setDataType(String dataType) {
		this.dataType = dataType;
	}

	public String getColumnType() {
		return columnType;
	}

	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}

	public String getFlength() {
		return flength;
	}

	public void setFlength(String flength) {
		this.flength = flength;
	}

	public String getKeyDic() {
		return keyDic;
	}

	public void setKeyDic(String keyDic) {
		this.keyDic = keyDic;
	}

	public String getJspTypeDic() {
		return jspTypeDic;
	}

	public void setJspTypeDic(String jspTypeDic) {
		this.jspTypeDic = jspTypeDic;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getListTypeDic() {
		return listTypeDic;
	}

	public void setListTypeDic(String listTypeDic) {
		this.listTypeDic = listTypeDic;
	}

	public String getAddTypeDic() {
		return addTypeDic;
	}

	public void setAddTypeDic(String addTypeDic) {
		this.addTypeDic = addTypeDic;
	}

	public String getViewTypeDic() {
		return viewTypeDic;
	}

	public void setViewTypeDic(String viewTypeDic) {
		this.viewTypeDic = viewTypeDic;
	}

	public String getEditTypeDic() {
		return editTypeDic;
	}

	public void setEditTypeDic(String editTypeDic) {
		this.editTypeDic = editTypeDic;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getDefaultValue() {
		return defaultValue;
	}

	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}

	public String getFieldMenuName() {
		// TODO Auto-generated method stub
		return null;
	}

}