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
import com.official.web.origin.entity.sys.dic.SysDicItem;
import com.official.web.origin.service.sys.dic.SysDicItemServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("sys/dic/item/")
public class SysDicItemController {
	private static final Logger logger = LoggerFactory.getLogger(SysDicItemController.class);
	
	/**服务实现类**/
	@Autowired
	SysDicItemServiceImpl sysDicItemServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("sysDicItem main");
		ModelAndView mav=new ModelAndView("sys/dic/item/sysDicItem-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("sysDicItem toAdd");
		ModelAndView mav=new ModelAndView("sys/dic/item/sysDicItem-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(SysDicItem sysDicItemForm){
		logger.info("sysDicItem doAdd");
		sysDicItemServiceImpl.addSysDicItem(sysDicItemForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(Long id){
		logger.info("sysDicItem toEdit");
		ModelAndView mav=new ModelAndView("sys/dic/item/sysDicItem-edit");
		SysDicItem sysDicItem=sysDicItemServiceImpl.findSysDicItemById(id);
		mav.addObject("sysDicItem", sysDicItem);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param sysDicItemForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(SysDicItem sysDicItemForm){
		logger.info("sysDicItem doEdit");
		sysDicItemServiceImpl.modifySysDicItem(sysDicItemForm);
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
		logger.info("sysDicItem doEdit");
		sysDicItemServiceImpl.removeSysDicItemByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(Long id){
		logger.info("sysDicItem doEdit");
		ModelAndView mav=new ModelAndView("sys/dic/item/sysDicItem-view");
		SysDicItem sysDicItem=sysDicItemServiceImpl.findSysDicItemById(id);
		mav.addObject("sysDicItem", sysDicItem);
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
		logger.info("sysDicItem search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysDicItemServiceImpl.findSysDicItemByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("sysDicItem toDialog");
		ModelAndView mav=new ModelAndView("sys/dic/item/sysDicItem-dialog");
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
		logger.info("sysDicItem dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		sysDicItemServiceImpl.findSysDicItemByPager(condition,pager);
		return pager;
	}
}