package com.official.web.origin.mapper.sys.dic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.sys.dic.SysDicGroup;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface SysDicGroupMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysDicGroup selectSysDicGroupById(Long id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysDicGroup> selectSysDicGroupAll();

	/**
	 * 插入,null实体
	 * @param sysDicGroupForm
	 */
	public void insertSysDicGroup(SysDicGroup sysDicGroupForm);

	/**
	 * 更新,null实体
	 * @param sysDicGroupForm
	 */
	public void updateSysDicGroup(SysDicGroup sysDicGroupForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateSysDicGroupByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delSysDicGroupByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysDicGroup> selectSysDicGroupByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysDicGroup> selectSysDicGroupByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectSysDicGroupCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<SysDicGroup> selectSysDicGroupBySql(@Param("sql")String sql);
}
