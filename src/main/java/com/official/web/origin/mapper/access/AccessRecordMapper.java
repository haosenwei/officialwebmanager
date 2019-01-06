package com.official.web.origin.mapper.access;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.access.AccessRecord;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface AccessRecordMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public AccessRecord selectAccessRecordById(int id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<AccessRecord> selectAccessRecordAll();

	/**
	 * 插入,null实体
	 * @param accessRecordForm
	 */
	public void insertAccessRecord(AccessRecord accessRecordForm);

	/**
	 * 更新,null实体
	 * @param accessRecordForm
	 */
	public void updateAccessRecord(AccessRecord accessRecordForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateAccessRecordByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delAccessRecordByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<AccessRecord> selectAccessRecordByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<AccessRecord> selectAccessRecordByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectAccessRecordCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<AccessRecord> selectAccessRecordBySql(@Param("sql")String sql);
}
