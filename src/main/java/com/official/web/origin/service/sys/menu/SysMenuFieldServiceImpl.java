package com.official.web.origin.service.sys.menu;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.menu.SysMenuField;
import com.official.web.origin.mapper.sys.menu.SysMenuFieldMapper;
import com.official.web.origin.service.IService;

/**
 * 菜单详情表,1服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysMenuFieldServiceImpl implements IService {

	/**菜单详情表,1实体操作类**/
	@Autowired
	private	SysMenuFieldMapper sysMenuFieldMapper;

	/**
	 * 根据id查询菜单详情表,1实体
	 * @param id
	 * @return
	 */
	public SysMenuField findSysMenuFieldById(Long id) {
		return sysMenuFieldMapper.selectSysMenuFieldById(id);
	}
	
	/**
	 * 查询所有菜单详情表,1实体
	 * @return
	 */
	public List<SysMenuField> findEntityAll() {
		return sysMenuFieldMapper.selectSysMenuFieldAll();
	}
	
	/**
	 * 新增菜单详情表,1实体
	 * @param sysMenuFieldForm
	 */
	public void addSysMenuField(SysMenuField sysMenuFieldForm) {
		sysMenuFieldMapper.insertSysMenuField(sysMenuFieldForm);
	}

	/**
	 * 更新菜单详情表,1实体
	 * @param sysMenuFieldForm
	 */
	public void modifySysMenuField(SysMenuField sysMenuFieldForm) {
		sysMenuFieldMapper.updateSysMenuField(sysMenuFieldForm);
	}

	/**
	 * 根据条件更新菜单详情表,1实体
	 * @param condition
	 */
	public void modifySysMenuFieldByCondition(Map<String, Object> condition) {
		sysMenuFieldMapper.updateSysMenuFieldByCondition(condition);
	}

	/**
	 * 根据ids删除菜单详情表,1实体
	 * @param ids
	 */
	public void removeSysMenuFieldByIds(String ids) {
		sysMenuFieldMapper.delSysMenuFieldByIds(ids);
	}
	
	/**
	 * 根据条件查询菜单详情表,1实体
	 * @param condition
	 * @return
	 */
	public List<SysMenuField> findSysMenuFieldByCondition(Map<String, Object> condition) {
		return sysMenuFieldMapper.selectSysMenuFieldByCondition(condition);
	}
	
	/**
	 * 根据条件查询菜单详情表,1实体
	 * @param condition
	 * @return
	 */
	public List<SysMenuField> findSysMenuFieldBySql(String sql) {
		if(StringUtils.isBlank(sql)) {
			return new ArrayList<SysMenuField>();
		}
		return sysMenuFieldMapper.selectSysMenuFieldBySql(sql);
	}
	
	/**
	 * 分页查询菜单详情表,1实体
	 * @param condition
	 * @param pager
	 */
	public void findSysMenuFieldByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysMenuField> list=sysMenuFieldMapper.selectSysMenuFieldByPager(condition);
		int count=sysMenuFieldMapper.selectSysMenuFieldCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

	public List<SysMenuField> findSysMenuFieldByCode(String string) {
		String sql = "SELECT * FROM `sys_menu_field` WHERE menu_id = (SELECT id FROM sys_menu WHERE `code` = '"+string+"' )";
		List<SysMenuField> list = sysMenuFieldMapper.selectSysMenuFieldBySql(sql);
		return list;
	}

}