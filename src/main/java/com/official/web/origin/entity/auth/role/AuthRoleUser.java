package com.official.web.origin.entity.auth.role;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ,null实体类
 * 
 * @author hsw
 *
 */
public class AuthRoleUser implements Serializable {

	
	/**  */
	private Long id;
	
	/** 用户id */
	private Long userId;
	
	/** 角色 */
	private Long roleId;
	
	
	/** get  ***/
	public Long getId() {
		return id;
	}
	
	/** set  ***/
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 用户id ***/
	public Long getUserId() {
		return userId;
	}
	
	/** set 用户id ***/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	
	/** get 角色 ***/
	public Long getRoleId() {
		return roleId;
	}
	
	/** set 角色 ***/
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}