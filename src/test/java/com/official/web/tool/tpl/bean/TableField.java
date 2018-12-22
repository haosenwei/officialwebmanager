package com.official.web.tool.tpl.bean;

import com.official.web.origin.entity.common.MysqlFieldType;

public class TableField {
	/** 字段名称-->user_name */
	private String field_name;

	/** java类型 **/
	private String javaType;

	/** java类型 **/
	private String javaTypeU;

	/** 字段备注-->年龄 **/
	private String comment;

	/*** 字段名称大写 */
	private String fieldNameU;

	/*** 字段名称大写 */
	private String fieldName;

	/*** 字段格式 */
	private String format;

	/*** 字段格式 */
	private String fieldMenuName;

	/*** 字段格式 */
	private Integer orderBy;

	/** 列表页面展示 列表页面展示 */
	private String listTypeDic;

	/** 新增页面展示 新增页面展示 */
	private String addTypeDic;

	/** 详情页面展示 详情页面展示 */
	private String viewTypeDic;

	/** 修改页面类型 修改页面类型 */
	private String editTypeDic;

	private String keyDic;

	public TableField(SysTableField sysTableField) {

		orderBy = Integer.valueOf(sysTableField.getOrderBy());

		field_name = sysTableField.getColumnName();
		fieldMenuName = (sysTableField.getComment()==null?"":sysTableField.getComment()).split(":")[0];
		comment = sysTableField.getComment();
		String fieldNameForm = sysTableField.getColumnName();
		String[] split = fieldNameForm.split("_");
		fieldNameU = "";
		for (String string : split) {
			fieldNameU += string.substring(0, 1).toUpperCase() + string.substring(1);
		}
		for (int i = 0; i < split.length; i++) {
			String string = split[i];
			if (i == 0) {
				fieldName = string;
				continue;
			}
			fieldName += string.substring(0, 1).toUpperCase() + string.substring(1);
		}
		javaType = MysqlFieldType.get(sysTableField.getDataType()).getJavaDataType();
		javaTypeU = MysqlFieldType.get(sysTableField.getDataType()).getMybatisDataType().toUpperCase();

		/** 列表页面展示 列表页面展示 */
		listTypeDic = sysTableField.getListTypeDic();

		/** 新增页面展示 新增页面展示 */
		addTypeDic = sysTableField.getAddTypeDic();

		/** 详情页面展示 详情页面展示 */
		viewTypeDic = sysTableField.getViewTypeDic();

		/** 修改页面类型 修改页面类型 */
		editTypeDic = sysTableField.getEditTypeDic();

		keyDic = sysTableField.getKeyDic();
	}

	public String getFormat() {
		if (javaType.toUpperCase().contains("TIME")) {
			return "@DateTimeFormat(pattern=\"yyyy-MM-dd HH:mm:ss\")";
		}
		return null;
	}

	public void setFormat(String format) {
		this.format = format;
	}

	public String getField_name() {
		return field_name;
	}

	public void setField_name(String field_name) {
		this.field_name = field_name;
	}

	public String getJavaType() {
		return javaType;
	}

	public void setJavaType(String javaType) {
		this.javaType = javaType;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getFieldNameU() {
		return fieldNameU;
	}

	public void setFieldNameU(String fieldNameU) {
		this.fieldNameU = fieldNameU;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public String getJavaTypeU() {
		return javaTypeU;
	}

	public void setJavaTypeU(String javaTypeU) {
		this.javaTypeU = javaTypeU;
	}

	public String getFieldMenuName() {
		return fieldMenuName;
	}

	public void setFieldMenuName(String fieldMenuName) {
		this.fieldMenuName = fieldMenuName;
	}

	public Integer getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(Integer orderBy) {
		this.orderBy = orderBy;
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

	public String getKeyDic() {
		return keyDic;
	}

	public void setKeyDic(String keyDic) {
		this.keyDic = keyDic;
	}

}
