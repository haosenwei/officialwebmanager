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
public class AuthRoleMenu implements Serializable {

	
	/** 主键 */
	private Long id;
	
	/** 菜单id */
	private Long menuId;
	
	/** 角色id */
	private Long roleId;
	
	
	/** get 主键 ***/
	public Long getId() {
		return id;
	}
	
	/** set 主键 ***/
	public void setId(Long id) {
		this.id = id;
	}
	
	/** get 菜单id ***/
	public Long getMenuId() {
		return menuId;
	}
	
	/** set 菜单id ***/
	public void setMenuId(Long menuId) {
		this.menuId = menuId;
	}
	
	/** get 角色id ***/
	public Long getRoleId() {
		return roleId;
	}
	
	/** set 角色id ***/
	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}
	
}