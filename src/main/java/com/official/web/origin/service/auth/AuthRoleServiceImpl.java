package com.official.web.origin.service.auth;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.auth.AuthRole;
import com.official.web.origin.mapper.auth.AuthRoleMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class AuthRoleServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	AuthRoleMapper authRoleMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public AuthRole findAuthRoleById(Long id) {
		return authRoleMapper.selectAuthRoleById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<AuthRole> findEntityAll() {
		return authRoleMapper.selectAuthRoleAll();
	}
	
	/**
	 * 新增,null实体
	 * @param authRoleForm
	 */
	public void addAuthRole(AuthRole authRoleForm) {
		authRoleMapper.insertAuthRole(authRoleForm);
	}

	/**
	 * 更新,null实体
	 * @param authRoleForm
	 */
	public void modifyAuthRole(AuthRole authRoleForm) {
		authRoleMapper.updateAuthRole(authRoleForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifyAuthRoleByCondition(Map<String, Object> condition) {
		authRoleMapper.updateAuthRoleByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeAuthRoleByIds(String ids) {
		authRoleMapper.delAuthRoleByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<AuthRole> findAuthRoleByCondition(Map<String, Object> condition) {
		return authRoleMapper.selectAuthRoleByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findAuthRoleByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<AuthRole> list=authRoleMapper.selectAuthRoleByPager(condition);
		int count=authRoleMapper.selectAuthRoleCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}