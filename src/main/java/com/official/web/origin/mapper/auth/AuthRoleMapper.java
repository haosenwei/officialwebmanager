package com.official.web.origin.mapper.auth;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.auth.AuthRole;

/**
 * ,null数据库接口类
 *
 * @author hsw
 */
@Mapper
public interface AuthRoleMapper {
    /**
     * 根据id查询,null实体
     *
     * @param id
     * @return
     */
    public AuthRole selectAuthRoleById(@Param("id") Long id);

    /**
     * 查询所有,null实体
     *
     * @return
     */
    public List<AuthRole> selectAuthRoleAll();

    /**
     * 插入,null实体
     *
     * @param authRoleForm
     */
    public void insertAuthRole(AuthRole authRoleForm);

    /**
     * 更新,null实体
     *
     * @param authRoleForm
     */
    public void updateAuthRole(AuthRole authRoleForm);

    /**
     * 根据条件更新,null实体
     *
     * @param condition
     */
    public void updateAuthRoleByCondition(Map<String, Object> condition);

    /**
     * 删除,null实体
     *
     * @param ids
     */
    public void delAuthRoleByIds(@Param("ids") String ids);

    /**
     * 根据条件查询,null实体
     *
     * @param map
     * @return
     */
    public List<AuthRole> selectAuthRoleByCondition(Map<String, Object> map);

    /**
     * 分页查询,null实体
     *
     * @param map
     * @return
     */
    public List<AuthRole> selectAuthRoleByPager(Map<String, Object> map);

    /**
     * 分页查询,null实体条数
     *
     * @param condition
     * @return
     */
    public int selectAuthRoleCountByPager(Map<String, Object> condition);

    /**
     * sql查询,null实体
     *
     * @param sql
     * @return
     */
    public List<AuthRole> selectAuthRoleBySql(@Param("sql") String sql);
}
