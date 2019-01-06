package com.official.web.origin.service.sys.dic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.dic.SysDicAuth;
import com.official.web.origin.mapper.sys.dic.SysDicAuthMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysDicAuthServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	SysDicAuthMapper sysDicAuthMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysDicAuth findSysDicAuthById(Long id) {
		return sysDicAuthMapper.selectSysDicAuthById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysDicAuth> findEntityAll() {
		return sysDicAuthMapper.selectSysDicAuthAll();
	}
	
	/**
	 * 新增,null实体
	 * @param sysDicAuthForm
	 */
	public void addSysDicAuth(SysDicAuth sysDicAuthForm) {
		sysDicAuthMapper.insertSysDicAuth(sysDicAuthForm);
	}

	/**
	 * 更新,null实体
	 * @param sysDicAuthForm
	 */
	public void modifySysDicAuth(SysDicAuth sysDicAuthForm) {
		sysDicAuthMapper.updateSysDicAuth(sysDicAuthForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifySysDicAuthByCondition(Map<String, Object> condition) {
		sysDicAuthMapper.updateSysDicAuthByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeSysDicAuthByIds(String ids) {
		sysDicAuthMapper.delSysDicAuthByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<SysDicAuth> findSysDicAuthByCondition(Map<String, Object> condition) {
		return sysDicAuthMapper.selectSysDicAuthByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findSysDicAuthByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysDicAuth> list=sysDicAuthMapper.selectSysDicAuthByPager(condition);
		int count=sysDicAuthMapper.selectSysDicAuthCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}