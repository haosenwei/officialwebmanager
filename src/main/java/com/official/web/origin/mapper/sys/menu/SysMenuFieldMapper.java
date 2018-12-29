package com.official.web.origin.mapper.sys.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.sys.menu.SysMenuField;

/**
 * 菜单详情表,1数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface SysMenuFieldMapper {
	/**
	 * 根据id查询菜单详情表,1实体
	 * @param id
	 * @return
	 */
	public SysMenuField selectSysMenuFieldById(Long id);

	/**
	 * 查询所有菜单详情表,1实体
	 * @return
	 */
	public List<SysMenuField> selectSysMenuFieldAll();

	/**
	 * 插入菜单详情表,1实体
	 * @param sysMenuFieldForm
	 */
	public void insertSysMenuField(SysMenuField sysMenuFieldForm);

	/**
	 * 更新菜单详情表,1实体
	 * @param sysMenuFieldForm
	 */
	public void updateSysMenuField(SysMenuField sysMenuFieldForm);

	/**
	 * 根据条件更新菜单详情表,1实体
	 * @param condition
	 */
	public void updateSysMenuFieldByCondition(Map<String, Object> condition);

	/**
	 * 删除菜单详情表,1实体
	 * @param ids
	 */
	public void delSysMenuFieldByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询菜单详情表,1实体
	 * @param map
	 * @return
	 */
	public List<SysMenuField> selectSysMenuFieldByCondition(Map<String, Object> map);
	
	/**
	 * 分页查询菜单详情表,1实体
	 * @param map
	 * @return
	 */
	public List<SysMenuField> selectSysMenuFieldByPager(Map<String, Object> map);

	/**
	 * 分页查询菜单详情表,1实体条数
	 * @param condition
	 * @return
	 */
	public int selectSysMenuFieldCountByPager(Map<String, Object> condition);

	public List<SysMenuField> selectSysMenuFieldBySql(@Param("sql")String sql);

}
