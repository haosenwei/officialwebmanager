package com.official.web.origin.service.auth.role;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.auth.role.AuthRoleUser;
import com.official.web.origin.mapper.auth.role.AuthRoleUserMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class AuthRoleUserServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	AuthRoleUserMapper authRoleUserMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public AuthRoleUser findAuthRoleUserById(Long id) {
		return authRoleUserMapper.selectAuthRoleUserById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<AuthRoleUser> findEntityAll() {
		return authRoleUserMapper.selectAuthRoleUserAll();
	}
	
	/**
	 * 新增,null实体
	 * @param authRoleUserForm
	 */
	public void addAuthRoleUser(AuthRoleUser authRoleUserForm) {
		authRoleUserMapper.insertAuthRoleUser(authRoleUserForm);
	}

	/**
	 * 更新,null实体
	 * @param authRoleUserForm
	 */
	public void modifyAuthRoleUser(AuthRoleUser authRoleUserForm) {
		authRoleUserMapper.updateAuthRoleUser(authRoleUserForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifyAuthRoleUserByCondition(Map<String, Object> condition) {
		authRoleUserMapper.updateAuthRoleUserByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeAuthRoleUserByIds(String ids) {
		authRoleUserMapper.delAuthRoleUserByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<AuthRoleUser> findAuthRoleUserByCondition(Map<String, Object> condition) {
		return authRoleUserMapper.selectAuthRoleUserByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findAuthRoleUserByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<AuthRoleUser> list=authRoleUserMapper.selectAuthRoleUserByPager(condition);
		int count=authRoleUserMapper.selectAuthRoleUserCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}