package com.official.web.component.tag;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.official.web.origin.entity.sys.dic.SysDicItem;
import com.official.web.origin.service.sys.dic.SysDicItemServiceImpl;
import com.official.web.util.SpringContext;

@Component
public class SelectDicTag extends TagSupport {

	private String key;
	private String value;
	private String type = "all";

	@Override
	public int doStartTag() {
		JspWriter out = pageContext.getOut();
		// 查询所有的
		System.out.println(key + "-" + value + "-" + type);
		List<SysDicItem> list = getSysDicItems(key);
		if (list == null) {
			list = new ArrayList<SysDicItem>();
		}
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			SysDicItem sysDicItem = list.get(i);
			String select = "";
			if (StringUtils.isNotBlank(value) && value.equals(sysDicItem.getName())) {
				select = "selected=\"selected\"";
			}
			str.append("<option value=\"" + sysDicItem.getName() + "\" " + select + ">" + sysDicItem.getName());
		}
		try {
			out.write(str.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	private List<SysDicItem> getSysDicItems(String key2) {
		try {
			SysDicItemServiceImpl service = (SysDicItemServiceImpl) SpringContext.getApplicationContext()
					.getBean("sysDicItemServiceImpl");
			// list = service.findSysDicItemByCondition(condition);
			return service.findEntityAll();
		} catch (Exception e) {
			System.out.println("-------err-------");
		}
		return null;
	}

	@Override
	public int doEndTag() throws JspException {

		return super.doEndTag();
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	
	
}
