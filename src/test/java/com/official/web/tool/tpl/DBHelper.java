package com.official.web.tool.tpl;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.official.web.tool.tpl.bean.SysTableField;
import com.official.web.tool.tpl.bean.TableField;
import com.official.web.tool.tpl.bean.Tpl;
import com.official.web.util.DateFomatUtil;
import com.official.web.util.XMLUtil;

public class DBHelper {

	private Tpl tpl;
	private Map<String, Object> sysTable;
	Map<String, Object> map = null;

	public String createfile(Map<String, Object> sysTableParam, List<SysTableField> list) {
		this.sysTable = sysTableParam;
		try {
			say("开始生成文件-------");

			/**
			 * 1,读取配置文件 2,读到数据表 3.查询表结构 4.生成文件
			 */
			readConfig();
			map = createPublicParam(list);

			createJavaFile("entity", "entity", "");
			createJavaFile("service", "service", "ServiceImpl");
			createJavaFile("mapper", "mapper", "Mapper");
			String targetFile = tpl.getJavaPath() + "src/main/java/" + tpl.getFilePrefix() + "/mapper" + map.get("spacePrefix").toString().replace(".", "/") + "/";
			System.out.println(targetFile);
			FreeMarkerHelper.generateRequest(map, "mapperxml.txt", targetFile, map.get("EntityName") + "Mapper.xml");

			createJspPage("add");
			createJspPage("main");
			createJspPage("edit");
			createJspPage("view");
			createJspPage("dialog");
			targetFile = tpl.getJspPath() + "src/main/java/" + tpl.getFilePrefix() + "/controller" + map.get("spacePrefix").toString().replace(".", "/") + "/";
			targetFile = targetFile.replace("original/", "");
			System.out.println(targetFile);

			map.put("prefix", ((String) map.get("prefix")).replace(".original", ""));
			System.out.println(map.get("prefix"));
			FreeMarkerHelper.generateRequest(map, "controller.txt", targetFile, map.get("EntityName") + "Controller.java");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return "SUCCESS";
	}

	private void say(String string) {
		System.out.println(DateFomatUtil.dateToString() + ":" + string);
	}

	private void readConfig() throws Exception {
		say("读取配置文件");
		tpl = (Tpl) XMLUtil.convertXmlFileToObject(Tpl.class, "D:/hao/git/officialwebmanager/tpl/tpl.xml");
		// 输出配置
		say(tpl.toString());
	}

	private void createJspPage(String type) {
		String targetFile = tpl.getJspPath() + "src/main/webapp/WEB-INF/jsp/" + map.get("urlPrefix").toString().replace(".", "/") + "/";
		System.out.println(targetFile);
		FreeMarkerHelper.generateRequest(map, type + ".txt", targetFile,
				map.get("entityName") + "-" + type + ".jsp");
	}

	private void createJavaFile(String type, String javaPath, String javaName) {

		String targetFile = tpl.getJavaPath() + "src/main/java/" + tpl.getFilePrefix() + "/" + javaPath + map.get("spacePrefix").toString().replace(".", "/") + "/";
		System.out.println(targetFile);
		FreeMarkerHelper.generateRequest(map, type + ".txt", targetFile, map.get("EntityName") + javaName + ".java");
	}

	public Map<String, Object> createPublicParam(List<SysTableField> sysTableFieldList) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("prefix", tpl.getPrefix());
		map.put("menuName", sysTable.get("name").toString());
		map.put("table_name", sysTable.get("code").toString());
		String url = sysTable.get("url").toString().replace("main", "")+"/"; // sys/role
		map.put("urlPrefix", url);
		String[] split = url.split("/");
		String spacePrefix = "";
		for (int i = 0; i < split.length - 1; i++) {
			String string = split[i];
			if (StringUtils.isNotBlank(string)) {
				spacePrefix += "." + split[i];
			}
		}
		map.put("spacePrefix", spacePrefix);
		map.put("comment", sysTable.get("name") + "," + sysTable.get("remark").toString());
		map.put("author", tpl.getAuthor());

		split = sysTable.get("code").toString().split("_");
		String EntityName = "";
		String entityName = "";
		boolean flag = true;
		for (String string : split) {
			EntityName += string.substring(0, 1).toUpperCase() + string.substring(1);
			if (flag) {
				flag = false;
				entityName = string;
				continue;
			}
			entityName += string.substring(0, 1).toUpperCase() + string.substring(1);
		}
		map.put("EntityName", EntityName);
		map.put("entityName", entityName);
		List<TableField> list = new ArrayList<TableField>();
		for (SysTableField sysTableField : sysTableFieldList) {
			TableField TableField = new TableField(sysTableField);
			list.add(TableField);
		}

		// 排序
		list.sort(new Comparator<TableField>() {
			@Override
			public int compare(TableField arg0, TableField arg1) {
				if (arg0.getOrderBy() == null) {
					return 0;
				}
				if (arg1.getOrderBy() == null) {
					return 0;
				}

				return arg0.getOrderBy() - arg1.getOrderBy();
			}
		});

		map.put("list", list);
		return map;
	}

}