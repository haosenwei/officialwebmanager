package com.official.web.origin.mapper.auth.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.auth.role.AuthRoleMenu;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface AuthRoleMenuMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public AuthRoleMenu selectAuthRoleMenuById(Long id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<AuthRoleMenu> selectAuthRoleMenuAll();

	/**
	 * 插入,null实体
	 * @param authRoleMenuForm
	 */
	public void insertAuthRoleMenu(AuthRoleMenu authRoleMenuForm);

	/**
	 * 更新,null实体
	 * @param authRoleMenuForm
	 */
	public void updateAuthRoleMenu(AuthRoleMenu authRoleMenuForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateAuthRoleMenuByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delAuthRoleMenuByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<AuthRoleMenu> selectAuthRoleMenuByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<AuthRoleMenu> selectAuthRoleMenuByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectAuthRoleMenuCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<AuthRoleMenu> selectAuthRoleMenuBySql(@Param("sql")String sql);
}
