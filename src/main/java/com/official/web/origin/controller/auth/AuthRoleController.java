package com.official.web.origin.controller.auth;

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
import com.official.web.origin.entity.auth.AuthRole;
import com.official.web.origin.service.auth.AuthRoleServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("auth/role/")
public class AuthRoleController {
	private static final Logger logger = LoggerFactory.getLogger(AuthRoleController.class);
	
	/**服务实现类**/
	@Autowired
	AuthRoleServiceImpl authRoleServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("authRole main");
		ModelAndView mav=new ModelAndView("auth/role/authRole-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("authRole toAdd");
		ModelAndView mav=new ModelAndView("auth/role/authRole-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(AuthRole authRoleForm){
		logger.info("authRole doAdd");
		authRoleServiceImpl.addAuthRole(authRoleForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("authRole toEdit");
		ModelAndView mav=new ModelAndView("auth/role/authRole-edit");
		AuthRole authRole=authRoleServiceImpl.findAuthRoleById(id);
		mav.addObject("authRole", authRole);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param authRoleForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(AuthRole authRoleForm){
		logger.info("authRole doEdit");
		authRoleServiceImpl.modifyAuthRole(authRoleForm);
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
		logger.info("authRole doEdit");
		authRoleServiceImpl.removeAuthRoleByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("authRole doEdit");
		ModelAndView mav=new ModelAndView("auth/role/authRole-view");
		AuthRole authRole=authRoleServiceImpl.findAuthRoleById(id);
		mav.addObject("authRole", authRole);
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
		logger.info("authRole search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		authRoleServiceImpl.findAuthRoleByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("authRole toDialog");
		ModelAndView mav=new ModelAndView("auth/role/authRole-dialog");
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
		logger.info("authRole dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		authRoleServiceImpl.findAuthRoleByPager(condition,pager);
		return pager;
	}
}