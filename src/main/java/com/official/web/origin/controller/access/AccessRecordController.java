package com.official.web.origin.controller.access;

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
import com.official.web.origin.entity.access.AccessRecord;
import com.official.web.origin.service.access.AccessRecordServiceImpl;

/**
 * 
 * 控制器
 * @author hsw
 *
 */
@Controller
@RequestMapping("access/record/")
public class AccessRecordController {
	private static final Logger logger = LoggerFactory.getLogger(AccessRecordController.class);
	
	/**服务实现类**/
	@Autowired
	AccessRecordServiceImpl accessRecordServiceImpl;

	/**
	 * main页面
	 * @return
	 */
	@RequestMapping("main")
	public ModelAndView main(){
		logger.info("accessRecord main");
		ModelAndView mav=new ModelAndView("access/record/accessRecord-main");
		return mav;
	}

	/**
	 * 跳转到添加页面
	 * @return
	 */
	@RequestMapping("toAdd")
	public ModelAndView toAdd(){
		logger.info("accessRecord toAdd");
		ModelAndView mav=new ModelAndView("access/record/accessRecord-add");
		return mav;
	}
	
	/**
	 * 执行添加操作
	 * @param
	 * @return
	 */
	@RequestMapping(value="doAdd",method=RequestMethod.POST)
	@ResponseBody
	public Result doAdd(AccessRecord accessRecordForm){
		logger.info("accessRecord doAdd");
		accessRecordServiceImpl.addAccessRecord(accessRecordForm);
		return new Result();
	}
	
	/**
	 * 跳转到修改页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toEdit")
	public ModelAndView toEdit(int id){
		logger.info("accessRecord toEdit");
		ModelAndView mav=new ModelAndView("access/record/accessRecord-edit");
		AccessRecord accessRecord=accessRecordServiceImpl.findAccessRecordById(id);
		mav.addObject("accessRecord", accessRecord);
		return mav;
	}
	
	/**
	 * 执行修改操作
	 * @param accessRecordForm
	 * @return
	 */
	@RequestMapping(value="doEdit",method=RequestMethod.POST)
	@ResponseBody
	public Result doEdit(AccessRecord accessRecordForm){
		logger.info("accessRecord doEdit");
		accessRecordServiceImpl.modifyAccessRecord(accessRecordForm);
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
		logger.info("accessRecord doEdit");
		accessRecordServiceImpl.removeAccessRecordByIds(ids);
		return new Result();
	}
	
	/**
	 * 跳转到查看页面
	 * @param id
	 * @return
	 */
	@RequestMapping("toView")
	public ModelAndView toView(int id){
		logger.info("accessRecord doEdit");
		ModelAndView mav=new ModelAndView("access/record/accessRecord-view");
		AccessRecord accessRecord=accessRecordServiceImpl.findAccessRecordById(id);
		mav.addObject("accessRecord", accessRecord);
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
		logger.info("accessRecord search");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		accessRecordServiceImpl.findAccessRecordByPager(condition, pager);
		return pager;
	}
	
	/**
	 * 跳转到dialog页面
	 * @return
	 */
	@RequestMapping("toDialog")
	public ModelAndView toDialog(){
		logger.info("accessRecord toDialog");
		ModelAndView mav=new ModelAndView("access/record/accessRecord-dialog");
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
		logger.info("accessRecord dialogSearch");
		Map<String, Object> condition=WebUtils.getParametersStartingWith(request, "search_");
		accessRecordServiceImpl.findAccessRecordByPager(condition,pager);
		return pager;
	}
}