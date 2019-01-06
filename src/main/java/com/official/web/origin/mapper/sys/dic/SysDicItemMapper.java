package com.official.web.origin.mapper.sys.dic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.sys.dic.SysDicItem;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface SysDicItemMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysDicItem selectSysDicItemById(Long id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysDicItem> selectSysDicItemAll();

	/**
	 * 插入,null实体
	 * @param sysDicItemForm
	 */
	public void insertSysDicItem(SysDicItem sysDicItemForm);

	/**
	 * 更新,null实体
	 * @param sysDicItemForm
	 */
	public void updateSysDicItem(SysDicItem sysDicItemForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateSysDicItemByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delSysDicItemByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysDicItem> selectSysDicItemByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysDicItem> selectSysDicItemByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectSysDicItemCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<SysDicItem> selectSysDicItemBySql(@Param("sql")String sql);
}
