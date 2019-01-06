package com.official.web.origin.service.sys;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.SysUser;
import com.official.web.origin.mapper.sys.SysUserMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysUserServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	SysUserMapper sysUserMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysUser findSysUserById(Long id) {
		return sysUserMapper.selectSysUserById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysUser> findEntityAll() {
		return sysUserMapper.selectSysUserAll();
	}
	
	/**
	 * 新增,null实体
	 * @param sysUserForm
	 */
	public void addSysUser(SysUser sysUserForm) {
		sysUserMapper.insertSysUser(sysUserForm);
	}

	/**
	 * 更新,null实体
	 * @param sysUserForm
	 */
	public void modifySysUser(SysUser sysUserForm) {
		sysUserMapper.updateSysUser(sysUserForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifySysUserByCondition(Map<String, Object> condition) {
		sysUserMapper.updateSysUserByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeSysUserByIds(String ids) {
		sysUserMapper.delSysUserByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<SysUser> findSysUserByCondition(Map<String, Object> condition) {
		return sysUserMapper.selectSysUserByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findSysUserByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysUser> list=sysUserMapper.selectSysUserByPager(condition);
		int count=sysUserMapper.selectSysUserCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}