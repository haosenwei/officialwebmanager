package com.official.web.origin.service.sys.dic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.dic.SysDicGroup;
import com.official.web.origin.mapper.sys.dic.SysDicGroupMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysDicGroupServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	SysDicGroupMapper sysDicGroupMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysDicGroup findSysDicGroupById(Long id) {
		return sysDicGroupMapper.selectSysDicGroupById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysDicGroup> findEntityAll() {
		return sysDicGroupMapper.selectSysDicGroupAll();
	}
	
	/**
	 * 新增,null实体
	 * @param sysDicGroupForm
	 */
	public void addSysDicGroup(SysDicGroup sysDicGroupForm) {
		sysDicGroupMapper.insertSysDicGroup(sysDicGroupForm);
	}

	/**
	 * 更新,null实体
	 * @param sysDicGroupForm
	 */
	public void modifySysDicGroup(SysDicGroup sysDicGroupForm) {
		sysDicGroupMapper.updateSysDicGroup(sysDicGroupForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifySysDicGroupByCondition(Map<String, Object> condition) {
		sysDicGroupMapper.updateSysDicGroupByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeSysDicGroupByIds(String ids) {
		sysDicGroupMapper.delSysDicGroupByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<SysDicGroup> findSysDicGroupByCondition(Map<String, Object> condition) {
		return sysDicGroupMapper.selectSysDicGroupByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findSysDicGroupByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysDicGroup> list=sysDicGroupMapper.selectSysDicGroupByPager(condition);
		int count=sysDicGroupMapper.selectSysDicGroupCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}