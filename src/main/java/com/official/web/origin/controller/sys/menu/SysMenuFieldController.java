package com.official.web.origin.controller.sys.menu;

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
import com.official.web.origin.entity.sys.menu.SysMenuField;
import com.official.web.origin.service.sys.menu.SysMenuFieldServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("sys/menu/field/")
public class SysMenuFieldController {
	private static final Logger logger = LoggerFactory.getLogger(SysMenuFieldController.class);
	
	/**服务实现类**/
	@Autowired
	SysMenuFieldServiceImpl sysMenuFieldServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("sysMenuField main");
		ModelAndView mav=new ModelAndView("sys/menu/field/sysMenuField-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("sysMenuField toAdd");
		ModelAndView mav=new ModelAndView("sys/menu/field/sysMenuField-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(SysMenuField sysMenuFieldForm){
		logger.info("sysMenuField doAdd");
		sysMenuFieldServiceImpl.addSysMenuField(sysMenuFieldForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("sysMenuField toEdit");
		ModelAndView mav=new ModelAndView("sys/menu/field/sysMenuField-edit");
		SysMenuField sysMenuField=sysMenuFieldServiceImpl.findSysMenuFieldById(id);
		mav.addObject("sysMenuField", sysMenuField);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param sysMenuFieldForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(SysMenuField sysMenuFieldForm){
		logger.info("sysMenuField doEdit");
		sysMenuFieldServiceImpl.modifySysMenuField(sysMenuFieldForm);
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
		logger.info("sysMenuField doEdit");
		sysMenuFieldServiceImpl.removeSysMenuFieldByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("sysMenuField doEdit");
		ModelAndView mav=new ModelAndView("sys/menu/field/sysMenuField-view");
		SysMenuField sysMenuField=sysMenuFieldServiceImpl.findSysMenuFieldById(id);
		mav.addObject("sysMenuField", sysMenuField);
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
		logger.info("sysMenuField search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysMenuFieldServiceImpl.findSysMenuFieldByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("sysMenuField toDialog");
		ModelAndView mav=new ModelAndView("sys/menu/field/sysMenuField-dialog");
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
		logger.info("sysMenuField dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysMenuFieldServiceImpl.findSysMenuFieldByPager(condition,pager);
		return pager;
	}
}