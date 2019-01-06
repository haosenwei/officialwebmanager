package com.official.web.origin.mapper.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.sys.SysLog;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface SysLogMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysLog selectSysLogById(Long id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysLog> selectSysLogAll();

	/**
	 * 插入,null实体
	 * @param sysLogForm
	 */
	public void insertSysLog(SysLog sysLogForm);

	/**
	 * 更新,null实体
	 * @param sysLogForm
	 */
	public void updateSysLog(SysLog sysLogForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateSysLogByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delSysLogByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysLog> selectSysLogByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysLog> selectSysLogByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectSysLogCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<SysLog> selectSysLogBySql(@Param("sql")String sql);
}
