package com.official.web.tool.tpl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import com.official.web.origin.entity.sys.SysMenu;
import com.official.web.tool.tpl.bean.SysTableField;

public class JdbcTemplateCreate {

	// 获取数据源(设置为static 是因为该jdbc多次被调用)
	static JdbcTemplate jdbc = new JdbcTemplate(JdbcUtils.getDataSource());

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// 查询所有的表结构
		List<SysMenu> querySysMenu = querySysMenu();
		for (SysMenu sysMenu : querySysMenu) {
			createByTableName(sysMenu.getCode());
		}
		// String tableName = "sys_menu";
		// String[] split = tableName.split(",");
		// for (String string : split) {
		// createByTableName(string);
		// }
	}

	private static void createByTableName(String string) {
		Map<String, Object> user = query(string);
		System.out.println(user.toString());
		List<SysTableField> list = queryForList(user.get("id").toString());
		List<SysTableField> target = new ArrayList<SysTableField>();
		for (SysTableField sysTableField : list) {
			SysTableField queryDetail = queryDetail(sysTableField.getId());
			target.add(queryDetail);
			System.out.println(queryDetail.toString());
		}
		System.out.println(target.size());
		if (target.size() > 0) {
			new DBHelper().createfile(user, target);
		}
	}

	private static List<SysTableField> queryForList(String string) {
		String sql = "select * from sys_menu_field where menu_id = ? ";
		List<SysTableField> queryForList = jdbc.query(sql, new Object[] { string }, new MyRowMapper());
		return queryForList;
	}

	// 查询
	public static Map<String, Object> query(String id) {
		String sql = "select * from sys_menu where code = ?";
		Object args[] = new Object[] { id };
		Map<String, Object> map = jdbc.queryForMap(sql, args);
		// List<SysTable> queryForList = jdbc.queryForList(sql, SysTable.class, args);
		return map;
	}

	// 查询
	public static List<SysMenu> querySysMenu() {
		String sql = "select * from sys_menu ";
		List<SysMenu> queryForList = jdbc.query(sql, new Object[] {}, new SysMenuMapper());
		return queryForList;
	}

	public static SysTableField queryDetail(long id) {
		String sql = "select * from sys_menu_field where id = ?";
		Object args[] = new Object[] { id };
		Object user = jdbc.queryForObject(sql, args, new BeanPropertyRowMapper(SysTableField.class));
		// List<SysTable> queryForList = jdbc.queryForList(sql, SysTable.class, args);
		return (SysTableField) user;
	}

}

class MyRowMapper implements RowMapper<SysTableField> {
	@Override
	public SysTableField mapRow(ResultSet resultSet, int i) throws SQLException {
		SysTableField familyMember = new SysTableField();
		familyMember.setId(resultSet.getLong("id"));
		return familyMember;
	}
}
class SysMenuMapper implements RowMapper<SysMenu> {
	@Override
	public SysMenu mapRow(ResultSet resultSet, int i) throws SQLException {
		SysMenu familyMember = new SysMenu();
		familyMember.setId(resultSet.getLong("id"));
		familyMember.setCode(resultSet.getString("code"));
		return familyMember;
	}
}