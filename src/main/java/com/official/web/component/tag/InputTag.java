package com.official.web.component.tag;

import com.official.web.origin.entity.sys.dic.SysDicItem;
import com.official.web.origin.service.sys.dic.SysDicItemServiceImpl;
import com.official.web.util.SpringContext;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.util.List;

@Component
@Data
public class InputTag extends TagSupport {

    private Integer type;
    private String value = null;
    private String defaultValue;
    private String fieldName;
    private String fieldComment;
    private boolean required = false;
    private int colLength = 6;
    private int dicGroupId = 0;

    @Override
    public int doStartTag() {
        JspWriter out = pageContext.getOut();
        StringBuffer str = new StringBuffer();
        str.append("\t\t<div class=\"layui-col-xs" + colLength + "\">\n");
        str.append("\t\t\t<div class=\"layui-form-item\">\n");
        str.append("\t\t\t\t<label class=\"layui-form-label\">" + fieldComment + "</label>\n");
        str.append("\t\t\t\t<div class=\"layui-input-block\">\n");
        switch (type) {
            case InputTypeConstants.COMMON_INPUT: {
                str.append("\t\t\t\t\t<input type=\"text\" name=\"" + fieldName + "\" placeholder=\"请输入" + fieldComment + "\" " + (required ? "required  lay-verify=\"required\"" : "") + " value=\"" + getFieldValue() + "\" autocomplete=\"off\" class=\"layui-input\">\n");
                break;
            }
            case InputTypeConstants.PASSWORD_INPUT: {
                str.append("\t\t\t\t\t<input type=\"password\" name=\"" + fieldName + "\" placeholder=\"请输入" + fieldComment + "\" " + (required ? "required  lay-verify=\"required\"" : "") + " value=\"" + getFieldValue() + "\" autocomplete=\"off\" class=\"layui-input\">\n");
                break;
            }
            case InputTypeConstants.TEXT_INPUT: {
                str.append("\t\t\t\t\t<textarea name=\"" + fieldName + "\" placeholder=\"请输入" + fieldComment + "\" " + (required ? "required  lay-verify=\"required\"" : "") + "class=\"layui-textarea\"></textarea>\n");
                break;
            }
            case InputTypeConstants.DIC_SELECT: {

                SysDicItemServiceImpl service = (SysDicItemServiceImpl) SpringContext.getApplicationContext().getBean("sysDicItemServiceImpl");
                List<SysDicItem> entityAll = service.findEntityAll();

                str.append("\t\t\t\t\t<select name=\"" + fieldName + "\" " + (required ? "required  lay-verify=\"required\"" : "") + ">\n");
                for (SysDicItem sysDicItem : entityAll) {
                    str.append("<option value=\"" + sysDicItem.getId() + "\"  " + (sysDicItem.getId().toString().equals(getFieldValue()) ? " selected " : "") + ">" + sysDicItem.getName() + "</option>\n");
                }
                str.append("</select>     \n");
                break;
            }
            case InputTypeConstants.OPEN_SWITCH: {
                str.append("<input type=\"checkbox\" name=\"" + fieldName + "\" lay-skin=\"switch\" lay-text=\"开|关\" " + (getFieldValue().equals("1") ? "checked" : "") + ">");
                break;
            }
            case InputTypeConstants.RADIO: {
                SysDicItemServiceImpl service = (SysDicItemServiceImpl) SpringContext.getApplicationContext().getBean("sysDicItemServiceImpl");
                List<SysDicItem> entityAll = service.findEntityAll();
                for (SysDicItem sysDicItem : entityAll) {
                    str.append("<input type=\"radio\" name=\"" + fieldName + "\" value=\"" + sysDicItem.getId() + "\" title=\"" + sysDicItem.getName() + "\" " + (getFieldValue().equals(sysDicItem.getId().toString()) ? "checked" : "") + ">");
                }
                break;
            }
        }
        str.append("\t\t\t\t</div>\n" +
                "\t\t\t</div>\n" +
                "\t\t</div>");
        try {
            out.write(str.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private String getFieldValue() {
        if (StringUtils.isNotBlank(value)) {
            return value;
        }
        if (StringUtils.isNotBlank(defaultValue)) {
            return defaultValue;
        }
        return "";
    }

    private List<SysDicItem> getSysDicItems(String key2) {
        try {
            SysDicItemServiceImpl service = (SysDicItemServiceImpl) SpringContext.getApplicationContext().getBean("sysDicItemServiceImpl");
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
}
