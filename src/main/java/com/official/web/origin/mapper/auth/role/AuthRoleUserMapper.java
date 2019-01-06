package com.official.web.origin.mapper.auth.role;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.auth.role.AuthRoleUser;

/**
 * ,null数据库接口类
 * @author hsw
 *
 */
@Mapper
public interface AuthRoleUserMapper {
	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public AuthRoleUser selectAuthRoleUserById(Long id);

	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<AuthRoleUser> selectAuthRoleUserAll();

	/**
	 * 插入,null实体
	 * @param authRoleUserForm
	 */
	public void insertAuthRoleUser(AuthRoleUser authRoleUserForm);

	/**
	 * 更新,null实体
	 * @param authRoleUserForm
	 */
	public void updateAuthRoleUser(AuthRoleUser authRoleUserForm);

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void updateAuthRoleUserByCondition(Map<String, Object> condition);

	/**
	 * 删除,null实体
	 * @param ids
	 */
	public void delAuthRoleUserByIds(@Param("ids")String ids);

	/**
	 * 根据条件查询,null实体
	 * @param map
	 * @return
	 */
	public List<AuthRoleUser> selectAuthRoleUserByCondition(Map<String, Object> map);

	/**
	 * 分页查询,null实体
	 * @param map
	 * @return
	 */
	public List<AuthRoleUser> selectAuthRoleUserByPager(Map<String, Object> map);

	/**
	 * 分页查询,null实体条数
	 * @param condition
	 * @return
	 */
	public int selectAuthRoleUserCountByPager(Map<String, Object> condition);

	/**
	 * sql查询,null实体
	 * @param sql
	 * @return
	 */
	public List<AuthRoleUser> selectAuthRoleUserBySql(@Param("sql")String sql);
}
