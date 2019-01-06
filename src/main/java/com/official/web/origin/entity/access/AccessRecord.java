package com.official.web.origin.entity.access;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * ,null实体类
 * 
 * @author hsw
 *
 */
public class AccessRecord implements Serializable {

	
	/** 主键 */
	private int id;
	
	/** 请求url */
	private String requestUrl;
	
	/** 请求资源 */
	private String requestUri;
	
	/** 查询参数 */
	private String queryString;
	
	/** 访问者ip */
	private String remoteAddr;
	
	/** 访问者的主机 */
	private String remoteHost;
	
	/** 访问者浏览器 */
	private String browser;
	
	/** 访问者浏览器版本 */
	private String browserVersion;
	
	/** 操作系统 */
	private String operatingSystem;
	
	/** 访问时间 */
	private Date browsingTime;
	
	/** get 主键 ***/
	public int getId() {
		return id;
	}
	
	/** set 主键 ***/
	public void setId(int id) {
		this.id = id;
	}
	/** get 请求url ***/
	public String getRequestUrl() {
		return requestUrl;
	}
	
	/** set 请求url ***/
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}
	/** get 请求资源 ***/
	public String getRequestUri() {
		return requestUri;
	}
	
	/** set 请求资源 ***/
	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}
	/** get 查询参数 ***/
	public String getQueryString() {
		return queryString;
	}
	
	/** set 查询参数 ***/
	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
	/** get 访问者ip ***/
	public String getRemoteAddr() {
		return remoteAddr;
	}
	
	/** set 访问者ip ***/
	public void setRemoteAddr(String remoteAddr) {
		this.remoteAddr = remoteAddr;
	}
	/** get 访问者的主机 ***/
	public String getRemoteHost() {
		return remoteHost;
	}
	
	/** set 访问者的主机 ***/
	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}
	/** get 访问者浏览器 ***/
	public String getBrowser() {
		return browser;
	}
	
	/** set 访问者浏览器 ***/
	public void setBrowser(String browser) {
		this.browser = browser;
	}
	/** get 访问者浏览器版本 ***/
	public String getBrowserVersion() {
		return browserVersion;
	}
	
	/** set 访问者浏览器版本 ***/
	public void setBrowserVersion(String browserVersion) {
		this.browserVersion = browserVersion;
	}
	/** get 操作系统 ***/
	public String getOperatingSystem() {
		return operatingSystem;
	}
	
	/** set 操作系统 ***/
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	/** get 访问时间 ***/
	public Date getBrowsingTime() {
		return browsingTime;
	}
	
	/** set 访问时间 ***/
	public void setBrowsingTime(Date browsingTime) {
		this.browsingTime = browsingTime;
	}
	
}