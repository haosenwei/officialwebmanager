package com.official.web.origin.entity.sys.menu;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * 菜单详情表,1实体类
 * 
 * @author hsw
 *
 */
public class SysMenuField implements Serializable {

	
	/**  */
	private Long id;
	
	/** 表主键 */
	private Long menuId;
	
	/** 名称(英文),分隔符_ */
	private String columnName;
	
	/** 字段类型 */
	private String dataType;
	
	/** 字段类型 */
	private String columnType;
	
	/** 字段长度 */
	private String flength;
	
	/** 主键标识 */
	private String keyDic;
	
	/** 页面类型 */
	private String jspTypeDic;
	
	/** 评论 */
	private String comment;
	
	/** 备注 */
	private String remark;
	
	/** 列表页面展示 */
	private String listTypeDic;
	
	/** 新建页面是否可以修改 */
	private String addIsEdit;
	
	/** 新增页面展示 */
	private String addTypeDic;
	
	/** 详情页面展示 */
	private String viewTypeDic;
	
	/** 修改页面是否可修改 */
	private String editIsEdit;
	
	/** 修改页面类型 */
	private String editTypeDic;
	
	/** 排序 */
	private String orderBy;
	
	/** 默认值 */
	private String defaultValue;
	
	/** get  ***/
	public Long getId() {
		return id;
	}
	
	/** set  ***/
	public void setId(Long id) {
		this.id = id;
	}
	/** get 表主键 ***/
	public Long getMenuId() {
		return menuId;
	}
	
	/** set 表主键 ***/
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	/** get 名称(英文),分隔符_ ***/
	public String getColumnName() {
		return columnName;
	}
	
	/** set 名称(英文),分隔符_ ***/
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	/** get 字段类型 ***/
	public String getDataType() {
		return dataType;
	}
	
	/** set 字段类型 ***/
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	/** get 字段类型 ***/
	public String getColumnType() {
		return columnType;
	}
	
	/** set 字段类型 ***/
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	/** get 字段长度 ***/
	public String getFlength() {
		return flength;
	}
	
	/** set 字段长度 ***/
	public void setFlength(String flength) {
		this.flength = flength;
	}
	/** get 主键标识 ***/
	public String getKeyDic() {
		return keyDic;
	}
	
	/** set 主键标识 ***/
	public void setKeyDic(String keyDic) {
		this.keyDic = keyDic;
	}
	/** get 页面类型 ***/
	public String getJspTypeDic() {
		return jspTypeDic;
	}
	
	/** set 页面类型 ***/
	public void setJspTypeDic(String jspTypeDic) {
		this.jspTypeDic = jspTypeDic;
	}
	/** get 评论 ***/
	public String getComment() {
		return comment;
	}
	
	/** set 评论 ***/
	public void setComment(String comment) {
		this.comment = comment;
	}
	/** get 备注 ***/
	public String getRemark() {
		return remark;
	}
	
	/** set 备注 ***/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** get 列表页面展示 ***/
	public String getListTypeDic() {
		return listTypeDic;
	}
	
	/** set 列表页面展示 ***/
	public void setListTypeDic(String listTypeDic) {
		this.listTypeDic = listTypeDic;
	}
	/** get 新建页面是否可以修改 ***/
	public String getAddIsEdit() {
		return addIsEdit;
	}
	
	/** set 新建页面是否可以修改 ***/
	public void setAddIsEdit(String addIsEdit) {
		this.addIsEdit = addIsEdit;
	}
	/** get 新增页面展示 ***/
	public String getAddTypeDic() {
		return addTypeDic;
	}
	
	/** set 新增页面展示 ***/
	public void setAddTypeDic(String addTypeDic) {
		this.addTypeDic = addTypeDic;
	}
	/** get 详情页面展示 ***/
	public String getViewTypeDic() {
		return viewTypeDic;
	}
	
	/** set 详情页面展示 ***/
	public void setViewTypeDic(String viewTypeDic) {
		this.viewTypeDic = viewTypeDic;
	}
	/** get 修改页面是否可修改 ***/
	public String getEditIsEdit() {
		return editIsEdit;
	}
	
	/** set 修改页面是否可修改 ***/
	public void setEditIsEdit(String editIsEdit) {
		this.editIsEdit = editIsEdit;
	}
	/** get 修改页面类型 ***/
	public String getEditTypeDic() {
		return editTypeDic;
	}
	
	/** set 修改页面类型 ***/
	public void setEditTypeDic(String editTypeDic) {
		this.editTypeDic = editTypeDic;
	}
	/** get 排序 ***/
	public String getOrderBy() {
		return orderBy;
	}
	
	/** set 排序 ***/
	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}
	/** get 默认值 ***/
	public String getDefaultValue() {
		return defaultValue;
	}
	
	/** set 默认值 ***/
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	
}