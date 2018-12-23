package com.official.web.origin.entity.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int curr =1;
	private int recordsTotal;
	private int length = 10;
	private int recordsFiltered;
	private List data=new ArrayList<>();
	private int offset;
	
	
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getOffset() {
		return (curr-1)*length;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getCurr() {
		return curr;
	}
	public void setCurr(int curr) {
		this.curr = curr;
	}
	public int getRecordsTotal() {
		return recordsTotal;
	}
	public void setRecordsTotal(int recordsTotal) {
		this.recordsTotal = recordsTotal;
	}
	public int getRecordsFiltered() {
		return recordsFiltered;
	}
	public void setRecordsFiltered(int recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public void searchResultHandle(List list, int count) {
		this.data=list;
		this.recordsFiltered =  count;
		this.recordsTotal = count;
	}
}

