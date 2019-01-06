package com.official.web.origin.mapper.sys.menu;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.sys.menu.SysMenuField;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface SysMenuFieldMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysMenuField selectSysMenuFieldById(Long id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysMenuField> selectSysMenuFieldAll();

	/**
	 * 插入,null实体
	 * @param sysMenuFieldForm
	 */
	public void insertSysMenuField(SysMenuField sysMenuFieldForm);

	/**
	 * 更新,null实体
	 * @param sysMenuFieldForm
	 */
	public void updateSysMenuField(SysMenuField sysMenuFieldForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateSysMenuFieldByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delSysMenuFieldByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysMenuField> selectSysMenuFieldByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysMenuField> selectSysMenuFieldByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectSysMenuFieldCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<SysMenuField> selectSysMenuFieldBySql(@Param("sql")String sql);
}
