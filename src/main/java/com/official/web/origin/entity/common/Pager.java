package com.official.web.origin.entity.common;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Pager implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int draw =1;
	private int recordsTotal;
	private int length;
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
		return offset;
	}
	public void setOffset(int offset) {
		this.offset = offset;
	}
	public int getDraw() {
		return draw;
	}
	public void setDraw(int draw) {
		this.draw = draw;
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

