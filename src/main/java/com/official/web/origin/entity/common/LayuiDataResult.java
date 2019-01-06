package com.official.web.origin.entity.common;

import java.util.ArrayList;
import java.util.List;

public class LayuiDataResult {

	private int code = 0;
	private String msg ;
	private int count = 0;
	private List data=new ArrayList<>();
	private int curr = 0 ;
	private int length = 10;
	private int offset;
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public List getData() {
		return data;
	}
	public void setData(List data) {
		this.data = data;
	}
	public int getCurr() {
		return curr;
	}
	public void setCurr(int curr) {
		this.curr = curr;
	}
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

}
