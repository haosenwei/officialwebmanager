package com.official.web.origin.mapper.sys.dic;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.sys.dic.SysDicAuth;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface SysDicAuthMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysDicAuth selectSysDicAuthById(Long id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysDicAuth> selectSysDicAuthAll();

	/**
	 * 插入,null实体
	 * @param sysDicAuthForm
	 */
	public void insertSysDicAuth(SysDicAuth sysDicAuthForm);

	/**
	 * 更新,null实体
	 * @param sysDicAuthForm
	 */
	public void updateSysDicAuth(SysDicAuth sysDicAuthForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateSysDicAuthByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delSysDicAuthByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysDicAuth> selectSysDicAuthByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<SysDicAuth> selectSysDicAuthByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectSysDicAuthCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<SysDicAuth> selectSysDicAuthBySql(@Param("sql")String sql);
}
