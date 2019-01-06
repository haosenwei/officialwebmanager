package com.official.web.origin.controller.sys;

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
import com.official.web.origin.entity.sys.SysUser;
import com.official.web.origin.service.sys.SysUserServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("sys/user/")
public class SysUserController {
	private static final Logger logger = LoggerFactory.getLogger(SysUserController.class);
	
	/**服务实现类**/
	@Autowired
	SysUserServiceImpl sysUserServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("sysUser main");
		ModelAndView mav=new ModelAndView("sys/user/sysUser-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("sysUser toAdd");
		ModelAndView mav=new ModelAndView("sys/user/sysUser-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(SysUser sysUserForm){
		logger.info("sysUser doAdd");
		sysUserServiceImpl.addSysUser(sysUserForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("sysUser toEdit");
		ModelAndView mav=new ModelAndView("sys/user/sysUser-edit");
		SysUser sysUser=sysUserServiceImpl.findSysUserById(id);
		mav.addObject("sysUser", sysUser);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param sysUserForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(SysUser sysUserForm){
		logger.info("sysUser doEdit");
		sysUserServiceImpl.modifySysUser(sysUserForm);
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
		logger.info("sysUser doEdit");
		sysUserServiceImpl.removeSysUserByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("sysUser doEdit");
		ModelAndView mav=new ModelAndView("sys/user/sysUser-view");
		SysUser sysUser=sysUserServiceImpl.findSysUserById(id);
		mav.addObject("sysUser", sysUser);
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
		logger.info("sysUser search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysUserServiceImpl.findSysUserByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("sysUser toDialog");
		ModelAndView mav=new ModelAndView("sys/user/sysUser-dialog");
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
		logger.info("sysUser dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysUserServiceImpl.findSysUserByPager(condition,pager);
		return pager;
	}
}