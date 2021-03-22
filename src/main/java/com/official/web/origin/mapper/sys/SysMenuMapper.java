package com.official.web.origin.mapper.sys;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.official.web.origin.entity.sys.SysMenu;

/**
 * ,1数据库接口类
 *
 * @author hsw
 */
@Mapper
public interface SysMenuMapper {
    /**
     * 根据id查询,1实体
     *
     * @param id
     * @return
     */
    public SysMenu selectSysMenuById(@Param("id") Long id);

    /**
     * 查询所有,1实体
     *
     * @return
     */
    public List<SysMenu> selectSysMenuAll();

    /**
     * 插入,1实体
     *
     * @param sysMenuForm
     */
    public void insertSysMenu(SysMenu sysMenuForm);

    /**
     * 更新,1实体
     *
     * @param sysMenuForm
     */
    public void updateSysMenu(SysMenu sysMenuForm);

    /**
     * 根据条件更新,1实体
     *
     * @param condition
     */
    public void updateSysMenuByCondition(Map<String, Object> condition);

    /**
     * 删除,1实体
     *
     * @param ids
     */
    public void delSysMenuByIds(@Param("ids") String ids);

    /**
     * 根据条件查询,1实体
     *
     * @param map
     * @return
     */
    public List<SysMenu> selectSysMenuByCondition(Map<String, Object> map);

    /**
     * 分页查询,1实体
     *
     * @param map
     * @return
     */
    public List<SysMenu> selectSysMenuByPager(Map<String, Object> map);

    /**
     * 分页查询,1实体条数
     *
     * @param condition
     * @return
     */
    public int selectSysMenuCountByPager(Map<String, Object> condition);

    /**
     * sql查询,1实体
     *
     * @param sql
     * @return
     */
    public List<SysMenu> selectSysMenuBySql(@Param("sql") String sql);
}
