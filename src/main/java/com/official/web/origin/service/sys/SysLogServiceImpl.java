package com.official.web.origin.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.SysLog;
import com.official.web.origin.mapper.sys.SysLogMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysLogServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	SysLogMapper sysLogMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysLog findSysLogById(Long id) {
		return sysLogMapper.selectSysLogById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysLog> findEntityAll() {
		return sysLogMapper.selectSysLogAll();
	}
	
	/**
	 * 新增,null实体
	 * @param sysLogForm
	 */
	public void addSysLog(SysLog sysLogForm) {
		sysLogMapper.insertSysLog(sysLogForm);
	}

	/**
	 * 更新,null实体
	 * @param sysLogForm
	 */
	public void modifySysLog(SysLog sysLogForm) {
		sysLogMapper.updateSysLog(sysLogForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifySysLogByCondition(Map<String, Object> condition) {
		sysLogMapper.updateSysLogByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeSysLogByIds(String ids) {
		sysLogMapper.delSysLogByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<SysLog> findSysLogByCondition(Map<String, Object> condition) {
		return sysLogMapper.selectSysLogByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findSysLogByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysLog> list=sysLogMapper.selectSysLogByPager(condition);
		int count=sysLogMapper.selectSysLogCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}