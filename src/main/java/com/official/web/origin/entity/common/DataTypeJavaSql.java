package com.official.web.origin.entity.common;

public class DataTypeJavaSql {
	private String sqlDataType; // int , varchar

	private String javaDataType;

	private String length;

	private String mybatisDataType;


	public DataTypeJavaSql(String sqlDataType, String javaDataType, String mybatisDataType, String length) {
		this.sqlDataType = sqlDataType;
		this.javaDataType = javaDataType;
		this.length = length;
		this.mybatisDataType = mybatisDataType;
	}
	public DataTypeJavaSql(String sqlDataType, String javaDataType, String mybatisDataType ) {
		this.sqlDataType = sqlDataType;
		this.javaDataType = javaDataType;
		this.mybatisDataType = mybatisDataType;
	}

	public String getSqlDataType() {
		return sqlDataType;
	}

	public void setSqlDataType(String sqlDataType) {
		this.sqlDataType = sqlDataType;
	}

	public String getJavaDataType() {
		return javaDataType;
	}

	public void setJavaDataType(String javaDataType) {
		this.javaDataType = javaDataType;
	}

	public String getLength() {
		return length;
	}

	public void setLength(String length) {
		this.length = length;
	}

	public String getMybatisDataType() {
		return mybatisDataType;
	}

	public void setMybatisDataType(String mybatisDataType) {
		this.mybatisDataType = mybatisDataType;
	}

}
