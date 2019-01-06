package com.official.web.controller;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.web.entity.SysMenuVo;
import com.official.web.service.SysMenuService;

@Controller
public class IndexController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		List<SysMenuVo> sysMenu = sysMenuService.getSysMenu();
		request.getSession().setAttribute("menu", sysMenu);
		return "index";
	}
	
	@RequestMapping("/sys/menu/getMyMenu")
	@ResponseBody
	public Object getMenu() throws IllegalAccessException, InvocationTargetException {
		List<SysMenuVo> sysMenu = sysMenuService.getSysMenu();
		return sysMenu;
	}
	
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request) throws IllegalAccessException, InvocationTargetException {
		List<SysMenuVo> sysMenu = sysMenuService.getSysMenu();
		request.getSession().setAttribute("menu", sysMenu);
		return "index";
	}
}
