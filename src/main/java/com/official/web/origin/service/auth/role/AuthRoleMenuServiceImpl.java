package com.official.web.origin.service.auth.role;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.auth.role.AuthRoleMenu;
import com.official.web.origin.mapper.auth.role.AuthRoleMenuMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class AuthRoleMenuServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	AuthRoleMenuMapper authRoleMenuMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public AuthRoleMenu findAuthRoleMenuById(Long id) {
		return authRoleMenuMapper.selectAuthRoleMenuById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<AuthRoleMenu> findEntityAll() {
		return authRoleMenuMapper.selectAuthRoleMenuAll();
	}
	
	/**
	 * 新增,null实体
	 * @param authRoleMenuForm
	 */
	public void addAuthRoleMenu(AuthRoleMenu authRoleMenuForm) {
		authRoleMenuMapper.insertAuthRoleMenu(authRoleMenuForm);
	}

	/**
	 * 更新,null实体
	 * @param authRoleMenuForm
	 */
	public void modifyAuthRoleMenu(AuthRoleMenu authRoleMenuForm) {
		authRoleMenuMapper.updateAuthRoleMenu(authRoleMenuForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifyAuthRoleMenuByCondition(Map<String, Object> condition) {
		authRoleMenuMapper.updateAuthRoleMenuByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeAuthRoleMenuByIds(String ids) {
		authRoleMenuMapper.delAuthRoleMenuByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<AuthRoleMenu> findAuthRoleMenuByCondition(Map<String, Object> condition) {
		return authRoleMenuMapper.selectAuthRoleMenuByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findAuthRoleMenuByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<AuthRoleMenu> list=authRoleMenuMapper.selectAuthRoleMenuByPager(condition);
		int count=authRoleMenuMapper.selectAuthRoleMenuCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}