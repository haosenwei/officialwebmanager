package com.official.web.tool.tpl.bean;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "tpl")
public class Tpl {
	private String prefix;
	private String author;
	private String javaPath;
	private String jspPath;

	public String getFilePrefix() {
		return prefix.replace(".", "/");
	}

	public String getPrefix() {
		return prefix;
	}

	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}

	public String getAuthor() {
		return author;
	}

	public String getJavaPath() {
		return javaPath;
	}

	public void setJavaPath(String javaPath) {
		this.javaPath = javaPath;
	}

	public String getJspPath() {
		return jspPath;
	}

	public void setJspPath(String jspPath) {
		this.jspPath = jspPath;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	@Override
	public String toString() {
		return "Tpl [prefix=" + prefix + ", author=" + author + ", javaPath=" + javaPath + ", jspPath=" + jspPath + "]";
	}

}