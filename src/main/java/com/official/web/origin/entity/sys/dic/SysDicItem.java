package com.official.web.origin.entity.sys.dic;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ,null实体类
 * 
 * @author hsw
 *
 */
public class SysDicItem implements Serializable {

	
	/** 主键 */
	private Long id;
	
	/** 分组id */
	private Long groupId;
	
	/** 名称 */
	private String code;
	
	/** 编码 */
	private String name;
	
	/** 备注 */
	private String remark;
	
	/** 状态 */
	private int status;
	
	/** 排序 */
	private int sort;
	
	
	/** get 主键 ***/
	public Long getId() {
		return id;
	}
	
	/** set 主键 ***/
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 分组id ***/
	public Long getGroupId() {
		return groupId;
	}
	
	/** set 分组id ***/
	public void setGroupId(Long groupId) {
		this.groupId = groupId;
	}
	
	/** get 名称 ***/
	public String getCode() {
		return code;
	}
	
	/** set 名称 ***/
	public void setCode(String code) {
		this.code = code;
	}
	
	/** get 编码 ***/
	public String getName() {
		return name;
	}
	
	/** set 编码 ***/
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 备注 ***/
	public String getRemark() {
		return remark;
	}
	
	/** set 备注 ***/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
	/** get 状态 ***/
	public int getStatus() {
		return status;
	}
	
	/** set 状态 ***/
	public void setStatus(int status) {
		this.status = status;
	}
	
	/** get 排序 ***/
	public int getSort() {
		return sort;
	}
	
	/** set 排序 ***/
	public void setSort(int sort) {
		this.sort = sort;
	}
	
}