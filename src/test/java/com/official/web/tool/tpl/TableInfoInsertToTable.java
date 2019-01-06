package com.official.web.tool.tpl;

import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

public class TableInfoInsertToTable {

	// 获取数据源(设置为static 是因为该jdbc多次被调用)
	static JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());

	public static void main(String[] args) {
		String tableName = "access_record"+
		",auth_role"+
		",auth_role_menu"+
		",auth_role_user"+
		",sys_config"+
		",sys_dic_auth"+
		",sys_dic_group"+
		",sys_dic_item"+
		",sys_log"+
		",sys_menu"+
		",sys_menu_field"+
		",sys_user";
		
		
//		String tableName = "sys_dic_item,sys_dic_auth,sys_dic_group";
		String[] split = tableName.split(",");
		for (String string : split) {
			addToTable(string);
		}
	}

	private static void addToTable(String tableName) {
		// 查询表信息
		Map<String, Object> queryDataInfo = queryDataInfo(tableName);
		// 查询是否存在,若存在更新,若不存在插入
		long sysMenuId = getSysTable(queryDataInfo);

		// 查询表结构
		List<Map<String, Object>> queryDataDetailInfo = queryDataDetailInfo(tableName);
		// 插入到table表中
		for (Map<String, Object> map : queryDataDetailInfo) {
			updateSysTableField(sysMenuId, map);
		}
	}

	private static void updateSysTableField(long sysMenuId, Map<String, Object> map) {
		// 查询表中是否存在数据
		String COLUMN_NAME = map.get("COLUMN_NAME").toString();
		String DATA_TYPE = map.get("DATA_TYPE").toString();
		String COLUMN_DEFAULT = map.get("COLUMN_DEFAULT") == null ? "" : map.get("COLUMN_DEFAULT").toString();
		String COLUMN_TYPE = map.get("COLUMN_TYPE") == null ? "" : map.get("COLUMN_TYPE").toString();
		String COLUMN_KEY = map.get("COLUMN_KEY") == null ? "" : map.get("COLUMN_KEY").toString();
		String COLUMN_COMMENT = map.get("COLUMN_COMMENT") == null ? "" : map.get("COLUMN_COMMENT").toString();
		String CHARACTER_MAXIMUM_LENGTH = map.get("CHARACTER_MAXIMUM_LENGTH") == null ? ""
				: map.get("CHARACTER_MAXIMUM_LENGTH").toString();
		Map<String, Object> querySysTableFieldByName = querySysTableFieldByName(sysMenuId, COLUMN_NAME);
		// 插入到sys_table表中
		if (querySysTableFieldByName == null || querySysTableFieldByName.keySet().size() == 0) {
			String insertSql = "INSERT INTO `g4m`.`sys_menu_field`(`menu_id`, `column_name`, `data_type`, `column_type`, `flength`, `key_dic`, `comment`, `remark`,`default_value`) VALUES "
					+ "(" + sysMenuId + ", '" + COLUMN_NAME + "', '" + DATA_TYPE + "', '" + COLUMN_TYPE + "', '"
					+ CHARACTER_MAXIMUM_LENGTH + "', '" + COLUMN_KEY + "', '" + COLUMN_COMMENT.split(":")[0] + "', '"
					+ COLUMN_COMMENT + "','" + COLUMN_DEFAULT + "')";
			jdbc.update(insertSql);
		} else {
			String string = querySysTableFieldByName.get("id").toString();
			String updateSql = "UPDATE `g4m`.`sys_menu_field` SET `column_name` = '" + COLUMN_NAME
					+ "', `data_type` = '" + DATA_TYPE + "', `column_type` = '" + COLUMN_TYPE + "', `flength` = '"
					+ CHARACTER_MAXIMUM_LENGTH + "', `key_dic` = '" + COLUMN_KEY + "',`comment` = '"
					+ COLUMN_COMMENT.split(":")[0] + "', `remark` = '" + COLUMN_COMMENT + "',`default_value` = '"
					+ COLUMN_DEFAULT + "' WHERE `id` = " + string;
			jdbc.update(updateSql);
		}
	}

	private static Map<String, Object> querySysTableFieldByName(long sysMenuId, String cOLUMN_NAME) {
		Map<String, Object> queryForMap;
		try {
			queryForMap = jdbc.queryForMap("SELECT * FROM `sys_menu_field` WHERE menu_id = " + sysMenuId
					+ " and column_name = '" + cOLUMN_NAME + "' ");
			return queryForMap;
		} catch (DataAccessException e) {
			return new HashMap<String, Object>();
		}
	}

	private static long getSysTable(Map<String, Object> queryDataInfo) {
		String tableName = queryDataInfo.get("Table_Name").toString();
		String tableCommet = queryDataInfo.get("TABLE_COMMENT").toString();
		Map<String, Object> sysMenu = querySysTableByName(tableName);
		long id = 0;
		if (sysMenu == null || sysMenu.keySet().size() == 0) {
			KeyHolder keyHolder = new GeneratedKeyHolder();
			PreparedStatementCreator preparedStatementCreator = con -> {
				String[] split = tableName.split("_");
				String url = "";
				if(split.length>1) {
					for (int i = 0; i < split.length; i++) {
						url += split[i];
						if(i!=split.length-1) {
							url+="/";
						}
					}
				}
				PreparedStatement ps = con.prepareStatement(
						"INSERT INTO `g4m`.`sys_menu`(`code`, `type_dic`, `name`, `pid`, `status_dic`, `url`, `path`, `icon`, `sort`, `remark`, `create_time`, `modify_uer_id`, `modify_time`) VALUES ('"
								+ tableName + "', '4', '" + tableCommet	+ "', 1, '1', '"+url+"', '', NULL, 1, NULL, now(), NULL, now())",
						Statement.RETURN_GENERATED_KEYS);
				return ps;
			};

			jdbc.update(preparedStatementCreator, keyHolder);

			System.out.println("看下能否拿到最终的自增的id-------------->" + keyHolder.getKey().longValue());
			id = keyHolder.getKey().longValue();
		} else {
			id = Long.valueOf(sysMenu.get("id").toString());
			if (!sysMenu.get("name").toString().equals(tableCommet)) {
				jdbc.update("UPDATE  `sys_menu` set `name` = '" + tableCommet + "' WHERE `code` = '" + tableName + "'");
			}
		}
		System.out.println("sysMenu--id-------------->" + id);
		return id;
	}

	// 查询
	public static Map<String, Object> querySysTableByName(String id) {
		String sql = "select * from sys_menu where code = ?";
		Object args[] = new Object[] { id };
		Map<String, Object> map;
		try {
			map = jdbc.queryForMap(sql, args);
		} catch (DataAccessException e) {
			return new HashMap<String, Object>();
		}
		return map;
	}

	private static List<Map<String, Object>> queryDataDetailInfo(String tableName) {
		List<Map<String, Object>> queryForList = jdbc.queryForList(
				"SELECT a.column_name, a.DATA_TYPE, a.COLUMN_DEFAULT , a.CHARACTER_MAXIMUM_LENGTH, a.COLUMN_TYPE, a.COLUMN_KEY, a.COLUMN_COMMENT FROM information_schema.COLUMNS a WHERE table_schema = 'g4m' AND table_name = ? ",
				new Object[] { tableName });
		return queryForList;
	}

	private static Map<String, Object> queryDataInfo(String tableName) {
		System.out.println("查询表:"+tableName);
		Map<String, Object> queryForMap = jdbc.queryForMap("SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.`TABLES` WHERE TABLE_NAME = '" + tableName + "'  and TABLE_SCHEMA = 'g4m'");
		return queryForMap;
	}
}
