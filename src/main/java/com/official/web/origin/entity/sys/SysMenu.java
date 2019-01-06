package com.official.web.origin.entity.sys;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ,1实体类
 * 
 * @author hsw
 *
 */
public class SysMenu implements Serializable {

	
	/**  */
	private Long id;
	
	/** 编码 */
	private String code;
	
	/** 类型 */
	private String typeDic;
	
	/** 菜单名称 */
	private String name;
	
	/** 上级节点 */
	private Long pid;
	
	/** 状态 */
	private String statusDic;
	
	/** 地址 */
	private String url;
	
	/** 路径 */
	private String path;
	
	/** 图标 */
	private String icon;
	
	/** 排序 */
	private int sort;
	
	/** 备注 */
	private String remark;
	
	/** 创建时间 */
	private Date createTime;
	
	/** 修改者 */
	private Long modifyUerId;
	
	/** 修改时间 */
	private Date modifyTime;
	
	/** get  ***/
	public Long getId() {
		return id;
	}
	
	/** set  ***/
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
	/** get 类型 ***/
	public String getTypeDic() {
		return typeDic;
	}
	
	/** set 类型 ***/
	public void setTypeDic(String typeDic) {
		this.typeDic = typeDic;
	}
	/** get 菜单名称 ***/
	public String getName() {
		return name;
	}
	
	/** set 菜单名称 ***/
	public void setName(String name) {
		this.name = name;
	}
	/** get 上级节点 ***/
	public Long getPid() {
		return pid;
	}
	
	/** set 上级节点 ***/
	public void setPid(Long pid) {
		this.pid = pid;
	}
	/** get 状态 ***/
	public String getStatusDic() {
		return statusDic;
	}
	
	/** set 状态 ***/
	public void setStatusDic(String statusDic) {
		this.statusDic = statusDic;
	}
	/** get 地址 ***/
	public String getUrl() {
		return url;
	}
	
	/** set 地址 ***/
	public void setUrl(String url) {
		this.url = url;
	}
	/** get 路径 ***/
	public String getPath() {
		return path;
	}
	
	/** set 路径 ***/
	public void setPath(String path) {
		this.path = path;
	}
	/** get 图标 ***/
	public String getIcon() {
		return icon;
	}
	
	/** set 图标 ***/
	public void setIcon(String icon) {
		this.icon = icon;
	}
	/** get 排序 ***/
	public int getSort() {
		return sort;
	}
	
	/** set 排序 ***/
	public void setSort(int sort) {
		this.sort = sort;
	}
	/** get 备注 ***/
	public String getRemark() {
		return remark;
	}
	
	/** set 备注 ***/
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/** get 创建时间 ***/
	public Date getCreateTime() {
		return createTime;
	}
	
	/** set 创建时间 ***/
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	/** get 修改者 ***/
	public Long getModifyUerId() {
		return modifyUerId;
	}
	
	/** set 修改者 ***/
	public void setModifyUerId(Long modifyUerId) {
		this.modifyUerId = modifyUerId;
	}
	/** get 修改时间 ***/
	public Date getModifyTime() {
		return modifyTime;
	}
	
	/** set 修改时间 ***/
	public void setModifyTime(Date modifyTime) {
		this.modifyTime = modifyTime;
	}
	
}