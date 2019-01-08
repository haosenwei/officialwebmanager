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
public class SysDicAuth implements Serializable {

	
	/** 主键 */
	private Long id;
	
	/** fieldid */
	private Long sysMenuFieldId;
	
	/** 数据字典项id */
	private Long sysDicItemId;
	
	
	/** get 主键 ***/
	public Long getId() {
		return id;
	}
	
	/** set 主键 ***/
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get fieldid ***/
	public Long getSysMenuFieldId() {
		return sysMenuFieldId;
	}
	
	/** set fieldid ***/
	public void setSysMenuFieldId(Long sysMenuFieldId) {
		this.sysMenuFieldId = sysMenuFieldId;
	}
	
	/** get 数据字典项id ***/
	public Long getSysDicItemId() {
		return sysDicItemId;
	}
	
	/** set 数据字典项id ***/
	public void setSysDicItemId(Long sysDicItemId) {
		this.sysDicItemId = sysDicItemId;
	}
	
}