package com.official.web.origin.entity.auth;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ,null实体类
 * 
 * @author hsw
 *
 */
public class AuthRole implements Serializable {

	
	/** id */
	private Long id;
	
	/** 编码 */
	private String code;
	
	/** 名称 */
	private String name;
	
	/** 主要职责 */
	private String majorDuty;
	
	/** 备注 */
	private String remark;
	
	
	/** get id ***/
	public Long getId() {
		return id;
	}
	
	/** set id ***/
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 编码 ***/
	public String getCode() {
		return code;
	}
	
	/** set 编码 ***/
	public void setCode(String code) {
		this.code = code;
	}
	
	/** get 名称 ***/
	public String getName() {
		return name;
	}
	
	/** set 名称 ***/
	public void setName(String name) {
		this.name = name;
	}
	
	/** get 主要职责 ***/
	public String getMajorDuty() {
		return majorDuty;
	}
	
	/** set 主要职责 ***/
	public void setMajorDuty(String majorDuty) {
		this.majorDuty = majorDuty;
	}
	
	/** get 备注 ***/
	public String getRemark() {
		return remark;
	}
	
	/** set 备注 ***/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	
}