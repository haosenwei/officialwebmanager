package com.official.web.component.tag;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import com.official.web.origin.service.IService;
import com.official.web.util.SpringContext;

@Component
public class SelectListTag extends TagSupport {

	private String entityName;
	private String valueKey;
	private String valueName;

	private String valuea;

	@Override
	public int doStartTag() {
		JspWriter out = pageContext.getOut();

		System.out.println(entityName + "-" + valueKey + "-" + valueName + "-" + valuea);
		List list = null;
		try {
			IService service1 = (IService) SpringContext.getApplicationContext().getBean(entityName + "ServiceImpl");
			list = service1.findEntityAll();
		} catch (Exception e) {
			System.out.println("-------err-------");
		}
		if(list ==null){
			return 0;
		}
		String[] split = null ;
		if(valuea!=null){
			split = valuea.split(",");
		}
		
		StringBuffer str = new StringBuffer();
		for (int i = 0; i < list.size(); i++) {
			Object object = list.get(i);
			try {
				String key  = BeanUtils.getProperty(object, valueKey);
				String name = BeanUtils.getProperty(object, valueName);
				String select = ""; 
				if(split!=null){
					for (String string : split) {
						if(StringUtils.equals(string, key)){
							select ="selected=\"selected\"";
						}
					}
				}
				str.append("<option value=\"" + key + "\" "+select+">" + name);
			} catch (IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
				e.printStackTrace();
			}
		}
		try {
			out.write(str.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int doEndTag() throws JspException {

		return super.doEndTag();
	}

	public String getEntityName() {
		return entityName;
	}

	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	public String getValueKey() {
		return valueKey;
	}

	public void setValueKey(String valueKey) {
		this.valueKey = valueKey;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getValuea() {
		return valuea;
	}

	public void setValuea(String valuea) {
		this.valuea = valuea;
	}

}
