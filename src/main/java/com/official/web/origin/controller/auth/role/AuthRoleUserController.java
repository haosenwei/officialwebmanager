package com.official.web.origin.controller.auth.role;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.util.WebUtils;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.common.Result;
import com.official.web.origin.entity.auth.role.AuthRoleUser;
import com.official.web.origin.service.auth.role.AuthRoleUserServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("auth/role/user/")
public class AuthRoleUserController {
	private static final Logger logger = LoggerFactory.getLogger(AuthRoleUserController.class);
	
	/**服务实现类**/
	@Autowired
	AuthRoleUserServiceImpl authRoleUserServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("authRoleUser main");
		ModelAndView mav=new ModelAndView("auth/role/user/authRoleUser-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("authRoleUser toAdd");
		ModelAndView mav=new ModelAndView("auth/role/user/authRoleUser-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(AuthRoleUser authRoleUserForm){
		logger.info("authRoleUser doAdd");
		authRoleUserServiceImpl.addAuthRoleUser(authRoleUserForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("authRoleUser toEdit");
		ModelAndView mav=new ModelAndView("auth/role/user/authRoleUser-edit");
		AuthRoleUser authRoleUser=authRoleUserServiceImpl.findAuthRoleUserById(id);
		mav.addObject("authRoleUser", authRoleUser);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param authRoleUserForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(AuthRoleUser authRoleUserForm){
		logger.info("authRoleUser doEdit");
		authRoleUserServiceImpl.modifyAuthRoleUser(authRoleUserForm);
		return new Result();
	}
	
	/**
	 * 执行删除操作
	 * @param ids
	 * @return
	 */
	@RequestMapping(value="del",method=RequestMethod.POST)
	@ResponseBody
	public Result del(String ids){
		logger.info("authRoleUser doEdit");
		authRoleUserServiceImpl.removeAuthRoleUserByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("authRoleUser doEdit");
		ModelAndView mav=new ModelAndView("auth/role/user/authRoleUser-view");
		AuthRoleUser authRoleUser=authRoleUserServiceImpl.findAuthRoleUserById(id);
		mav.addObject("authRoleUser", authRoleUser);
		return mav;
	}
	
	/**
	 * 分页查询数据
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping(value="search" ,method=RequestMethod.POST)
	@ResponseBody
	public Pager search(HttpServletRequest request,Pager pager){
		logger.info("authRoleUser search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		authRoleUserServiceImpl.findAuthRoleUserByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("authRoleUser toDialog");
		ModelAndView mav=new ModelAndView("auth/role/user/authRoleUser-dialog");
		return mav;
	}
	
	/**
	 * dialog检索
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping(value="dialogSearch",method=RequestMethod.POST)
	@ResponseBody
	public Pager dialogSearch(HttpServletRequest request,Pager pager){
		logger.info("authRoleUser dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		authRoleUserServiceImpl.findAuthRoleUserByPager(condition,pager);
		return pager;
	}
}