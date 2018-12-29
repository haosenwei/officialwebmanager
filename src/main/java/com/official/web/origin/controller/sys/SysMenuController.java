package com.official.web.origin.controller.sys;

import java.util.List;
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

import com.official.web.origin.entity.common.LayuiDataResult;
import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.common.Result;
import com.official.web.origin.entity.sys.SysMenu;
import com.official.web.origin.entity.sys.menu.SysMenuField;
import com.official.web.origin.service.sys.SysMenuServiceImpl;
import com.official.web.origin.service.sys.menu.SysMenuFieldServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("sys/menu/")
public class SysMenuController {
	private static final Logger logger = LoggerFactory.getLogger(SysMenuController.class);
	
	/**服务实现类**/
	@Autowired
	SysMenuServiceImpl sysMenuServiceImpl;
	/**服务实现类**/
	@Autowired
	SysMenuFieldServiceImpl sysMenuFieldServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("sysMenu main");
		ModelAndView mav=new ModelAndView("main");
		mav.addObject("code", "sys_menu");
		mav.addObject("url", "sys/menu/");
		List<SysMenuField> list = sysMenuFieldServiceImpl.findSysMenuFieldByCode("sys_menu");
		checkList(list);
		mav.addObject("SysMenuFieldList", list);
		
		return mav;
	}

	private void checkList(List<SysMenuField> list) {
		for (SysMenuField sysMenuField : list) {
			String[] split = sysMenuField.getColumnName().split("_");
			String res = "";
			for (int i = 0; i < split.length; i++) {
				if(i==0) {
					res+=split[i];
				}else {
					String upperCase = split[i].substring(0, 1).toUpperCase();
					res+=upperCase+split[i].substring(1);
				}
			}
			sysMenuField.setColumnName(res);
		}
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("sysMenu toAdd");
		ModelAndView mav=new ModelAndView("sys/menu/sysMenu-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping("doAdd")
	@ResponseBody
	public Result doAdd(SysMenu sysMenuForm){
		logger.info("sysMenu doAdd");
		sysMenuServiceImpl.addSysMenu(sysMenuForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("sysMenu toEdit");
		ModelAndView mav=new ModelAndView("sys/menu/sysMenu-edit");
		SysMenu sysMenu=sysMenuServiceImpl.findSysMenuById(id);
		mav.addObject("sysMenu", sysMenu);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param sysMenuForm
	 * @return
	 */
	@RequestMapping("doEdit")
	@ResponseBody
	public Result doEdit(SysMenu sysMenuForm){
		logger.info("sysMenu doEdit");
		sysMenuServiceImpl.modifySysMenu(sysMenuForm);
		return new Result();
	}
	
	/**
	 * 执行删除操作
	 * @param ids
	 * @return
	 */
	@RequestMapping("del")
	@ResponseBody
	public Result del(String ids){
		logger.info("sysMenu doEdit");
		sysMenuServiceImpl.removeSysMenuByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("sysMenu doEdit");
		ModelAndView mav=new ModelAndView("sys/menu/sysMenu-view");
		SysMenu sysMenu=sysMenuServiceImpl.findSysMenuById(id);
		mav.addObject("sysMenu", sysMenu);
		return mav;
	}
	
	/**
	 * 分页查询数据
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping(value="search" ,method=RequestMethod.GET)
	@ResponseBody
	public LayuiDataResult search(HttpServletRequest request,Pager pager){
		logger.info("sysMenu search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysMenuServiceImpl.findSysMenuByPager(condition, pager);
		List data = pager.getData();
		LayuiDataResult layuiDataResult = new LayuiDataResult();
		layuiDataResult.setData(data);
		layuiDataResult.setCount(pager.getRecordsTotal());
		return layuiDataResult;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("sysMenu toDialog");
		ModelAndView mav=new ModelAndView("sys/menu/sysMenu-dialog");
		return mav;
	}
	
	/**
	 * dialog检索
	 * @param request
	 * @param pager
	 * @return
	 */
	@RequestMapping("dialogSearch")
	@ResponseBody
	public Pager dialogSearch(HttpServletRequest request,Pager pager){
		logger.info("sysMenu dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysMenuServiceImpl.findSysMenuByPager(condition,pager);
		return pager;
	}
}