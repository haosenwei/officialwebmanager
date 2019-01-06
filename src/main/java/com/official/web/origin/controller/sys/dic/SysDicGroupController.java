package com.official.web.origin.controller.sys.dic;

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
import com.official.web.origin.entity.sys.dic.SysDicGroup;
import com.official.web.origin.service.sys.dic.SysDicGroupServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("sys/dic/group/")
public class SysDicGroupController {
	private static final Logger logger = LoggerFactory.getLogger(SysDicGroupController.class);
	
	/**服务实现类**/
	@Autowired
	SysDicGroupServiceImpl sysDicGroupServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("sysDicGroup main");
		ModelAndView mav=new ModelAndView("sys/dic/group/sysDicGroup-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("sysDicGroup toAdd");
		ModelAndView mav=new ModelAndView("sys/dic/group/sysDicGroup-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(SysDicGroup sysDicGroupForm){
		logger.info("sysDicGroup doAdd");
		sysDicGroupServiceImpl.addSysDicGroup(sysDicGroupForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("sysDicGroup toEdit");
		ModelAndView mav=new ModelAndView("sys/dic/group/sysDicGroup-edit");
		SysDicGroup sysDicGroup=sysDicGroupServiceImpl.findSysDicGroupById(id);
		mav.addObject("sysDicGroup", sysDicGroup);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param sysDicGroupForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(SysDicGroup sysDicGroupForm){
		logger.info("sysDicGroup doEdit");
		sysDicGroupServiceImpl.modifySysDicGroup(sysDicGroupForm);
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
		logger.info("sysDicGroup doEdit");
		sysDicGroupServiceImpl.removeSysDicGroupByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("sysDicGroup doEdit");
		ModelAndView mav=new ModelAndView("sys/dic/group/sysDicGroup-view");
		SysDicGroup sysDicGroup=sysDicGroupServiceImpl.findSysDicGroupById(id);
		mav.addObject("sysDicGroup", sysDicGroup);
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
		logger.info("sysDicGroup search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysDicGroupServiceImpl.findSysDicGroupByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("sysDicGroup toDialog");
		ModelAndView mav=new ModelAndView("sys/dic/group/sysDicGroup-dialog");
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
		logger.info("sysDicGroup dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysDicGroupServiceImpl.findSysDicGroupByPager(condition,pager);
		return pager;
	}
}