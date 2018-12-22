package com.official.web.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.official.web.origin.entity.sys.SysMenu;
import com.official.web.service.SysMenuService;

@Controller
public class IndexController {

	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		List<SysMenu> sysMenu = sysMenuService.getSysMenu();
		request.getSession().setAttribute("menu", sysMenu);
		return "index";
	}
	
	@RequestMapping("/sys/menu/getMyMenu")
	@ResponseBody
	public Object getMenu() {
		List<SysMenu> sysMenu = sysMenuService.getSysMenu();
		return sysMenu;
	}
	
	@RequestMapping("/index")
	public String toIndex(HttpServletRequest request) {
		List<SysMenu> sysMenu = sysMenuService.getSysMenu();
		request.getSession().setAttribute("menu", sysMenu);
		return "index";
	}
}
