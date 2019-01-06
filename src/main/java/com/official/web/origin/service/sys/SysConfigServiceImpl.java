package com.official.web.origin.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.SysConfig;
import com.official.web.origin.mapper.sys.SysConfigMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysConfigServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	SysConfigMapper sysConfigMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysConfig findSysConfigById(Long id) {
		return sysConfigMapper.selectSysConfigById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysConfig> findEntityAll() {
		return sysConfigMapper.selectSysConfigAll();
	}
	
	/**
	 * 新增,null实体
	 * @param sysConfigForm
	 */
	public void addSysConfig(SysConfig sysConfigForm) {
		sysConfigMapper.insertSysConfig(sysConfigForm);
	}

	/**
	 * 更新,null实体
	 * @param sysConfigForm
	 */
	public void modifySysConfig(SysConfig sysConfigForm) {
		sysConfigMapper.updateSysConfig(sysConfigForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifySysConfigByCondition(Map<String, Object> condition) {
		sysConfigMapper.updateSysConfigByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeSysConfigByIds(String ids) {
		sysConfigMapper.delSysConfigByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<SysConfig> findSysConfigByCondition(Map<String, Object> condition) {
		return sysConfigMapper.selectSysConfigByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findSysConfigByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysConfig> list=sysConfigMapper.selectSysConfigByPager(condition);
		int count=sysConfigMapper.selectSysConfigCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}