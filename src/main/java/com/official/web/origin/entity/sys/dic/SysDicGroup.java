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
public class SysDicGroup implements Serializable {

	
	/** 主键 */
	private Long id;
	
	/** 名称 */
	private String name;
	
	/** 编码 */
	private String code;
	
	/** 状态 */
	private int status;
	
	/** 备注 */
	private String remark;
	
	/** 类型 */
	private int type;
	
	/** get 主键 ***/
	public Long getId() {
		return id;
	}
	
	/** set 主键 ***/
	public void setId(Long id) {
		this.id = id;
	}
	/** get 名称 ***/
	public String getName() {
		return name;
	}
	
	/** set 名称 ***/
	public void setName(String name) {
		this.name = name;
	}
	/** get 编码 ***/
	public String getCode() {
		return code;
	}
	
	/** set 编码 ***/
	public void setCode(String code) {
		this.code = code;
	}
	/** get 状态 ***/
	public int getStatus() {
		return status;
	}
	
	/** set 状态 ***/
	public void setStatus(int status) {
		this.status = status;
	}
	/** get 备注 ***/
	public String getRemark() {
		return remark;
	}
	
	/** set 备注 ***/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** get 类型 ***/
	public int getType() {
		return type;
	}
	
	/** set 类型 ***/
	public void setType(int type) {
		this.type = type;
	}
	
}