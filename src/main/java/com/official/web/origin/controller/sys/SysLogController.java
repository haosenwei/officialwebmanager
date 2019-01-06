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
import com.official.web.origin.entity.sys.SysLog;
import com.official.web.origin.service.sys.SysLogServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("sys/log/")
public class SysLogController {
	private static final Logger logger = LoggerFactory.getLogger(SysLogController.class);
	
	/**服务实现类**/
	@Autowired
	SysLogServiceImpl sysLogServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("sysLog main");
		ModelAndView mav=new ModelAndView("sys/log/sysLog-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("sysLog toAdd");
		ModelAndView mav=new ModelAndView("sys/log/sysLog-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(SysLog sysLogForm){
		logger.info("sysLog doAdd");
		sysLogServiceImpl.addSysLog(sysLogForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("sysLog toEdit");
		ModelAndView mav=new ModelAndView("sys/log/sysLog-edit");
		SysLog sysLog=sysLogServiceImpl.findSysLogById(id);
		mav.addObject("sysLog", sysLog);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param sysLogForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(SysLog sysLogForm){
		logger.info("sysLog doEdit");
		sysLogServiceImpl.modifySysLog(sysLogForm);
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
		logger.info("sysLog doEdit");
		sysLogServiceImpl.removeSysLogByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("sysLog doEdit");
		ModelAndView mav=new ModelAndView("sys/log/sysLog-view");
		SysLog sysLog=sysLogServiceImpl.findSysLogById(id);
		mav.addObject("sysLog", sysLog);
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
		logger.info("sysLog search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysLogServiceImpl.findSysLogByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("sysLog toDialog");
		ModelAndView mav=new ModelAndView("sys/log/sysLog-dialog");
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
		logger.info("sysLog dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysLogServiceImpl.findSysLogByPager(condition,pager);
		return pager;
	}
}