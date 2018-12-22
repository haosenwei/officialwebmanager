package com.official.web.origin.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.SysMenu;
import com.official.web.origin.mapper.sys.SysMenuMapper;
import com.official.web.origin.service.IService;

/**
 * 菜单表,1服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysMenuServiceImpl implements IService {

	/**菜单表,1实体操作类**/
	@Autowired
	private	SysMenuMapper sysMenuMapper;

	/**
	 * 根据id查询菜单表,1实体
	 * @param id
	 * @return
	 */
	public SysMenu findSysMenuById(Long id) {
		return sysMenuMapper.selectSysMenuById(id);
	}
	
	/**
	 * 查询所有菜单表,1实体
	 * @return
	 */
	public List<SysMenu> findEntityAll() {
		return sysMenuMapper.selectSysMenuAll();
	}
	
	/**
	 * 新增菜单表,1实体
	 * @param sysMenuForm
	 */
	public void addSysMenu(SysMenu sysMenuForm) {
		sysMenuMapper.insertSysMenu(sysMenuForm);
	}

	/**
	 * 更新菜单表,1实体
	 * @param sysMenuForm
	 */
	public void modifySysMenu(SysMenu sysMenuForm) {
		sysMenuMapper.updateSysMenu(sysMenuForm);
	}

	/**
	 * 根据条件更新菜单表,1实体
	 * @param condition
	 */
	public void modifySysMenuByCondition(Map<String, Object> condition) {
		sysMenuMapper.updateSysMenuByCondition(condition);
	}

	/**
	 * 根据ids删除菜单表,1实体
	 * @param ids
	 */
	public void removeSysMenuByIds(String ids) {
		sysMenuMapper.delSysMenuByIds(ids);
	}
	
	/**
	 * 根据条件查询菜单表,1实体
	 * @param condition
	 * @return
	 */
	public List<SysMenu> findSysMenuByCondition(Map<String, Object> condition) {
		return sysMenuMapper.selectSysMenuByCondition(condition);
	}
	
	/**
	 * 分页查询菜单表,1实体
	 * @param condition
	 * @param pager
	 */
	public void findSysMenuByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysMenu> list=sysMenuMapper.selectSysMenuByPager(condition);
		int count=sysMenuMapper.selectSysMenuCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}