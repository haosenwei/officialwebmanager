package com.official.web.origin.entity.sys;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ,null实体类
 * 
 * @author hsw
 *
 */
public class SysLog implements Serializable {

	
	/**  */
	private Long id;
	
	/**  */
	private String tableName;
	
	/**  */
	private Long valId;
	
	/**  */
	private String dataJson;
	
	/**  */
	private Date createTime = new Date() ;
	
	
	/** get  ***/
	public Long getId() {
		return id;
	}
	
	/** set  ***/
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get  ***/
	public String getTableName() {
		return tableName;
	}
	
	/** set  ***/
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	
	/** get  ***/
	public Long getValId() {
		return valId;
	}
	
	/** set  ***/
	public void setValId(Long valId) {
		this.valId = valId;
	}
	
	/** get  ***/
	public String getDataJson() {
		return dataJson;
	}
	
	/** set  ***/
	public void setDataJson(String dataJson) {
		this.dataJson = dataJson;
	}
	
	/** get  ***/
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	public Date getCreateTime() {
		return createTime;
	}
	
	/** set  ***/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
}