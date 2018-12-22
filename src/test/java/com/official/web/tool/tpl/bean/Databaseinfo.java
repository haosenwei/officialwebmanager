package com.official.web.tool.tpl.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tables")
public class Databaseinfo {
	/**
	 * 网站前缀 com.go4mi
	 */
	private String prefix;

	/**
	 * 网站前缀 com/go4mi/
	 */
	private String filePrefix;

	/**
	 * 数据库地址
	 */
	private String jdbcurl;
	/**
	 * 数据库用户名
	 */
	private String username;
	/**
	 * 数据库密码
	 */
	private String password;
	/**
	 * java文件路径
	 */
	private String javapath;
	
	/*** jsp页面路径 */
	private String jsppath;
	
	/*** 数据库驱动 */
	private String drivername;

	/*** 作者  */
	private String author;

	/*** return com/go4mi/ **/
	public String getFilePrefix() {
		String result = "";
		String[] split = prefix.split("\\.");
		for (String string : split) {
			result += string + "/";
		}
		return result;
	}

	public void setFilePrefix(String filePrefix) {
		this.filePrefix = filePrefix;
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getJdbcurl() {
		return jdbcurl;
	}

	public void setJdbcurl(String jdbcurl) {
		this.jdbcurl = jdbcurl;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getJavapath() {
		return javapath;
	}

	public void setJavapath(String javapath) {
		this.javapath = javapath;
	}

	public String getJsppath() {
		return jsppath;
	}

	public void setJsppath(String jsppath) {
		this.jsppath = jsppath;
	}

	public String getDrivername() {
		return drivername;
	}

	public void setDrivername(String drivername) {
		this.drivername = drivername;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}