package com.official.web.service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.web.origin.entity.sys.SysMenu;
import com.official.web.origin.service.sys.SysMenuServiceImpl;

@Service
public class SysMenuService {
	
	@Autowired
	SysMenuServiceImpl sysMenuServiceImpl;
	
	public List<SysMenu> getSysMenu() {
		List<SysMenu> findEntityAll = sysMenuServiceImpl.findEntityAll();
		List<SysMenu> list= new ArrayList<SysMenu>();
		for (SysMenu sysMenu : findEntityAll) {
			if(sysMenu.getTypeDic().equals("1")) {
				list.add(sysMenu);
			}
		}
		list.sort(new Comparator<SysMenu>() {
			@Override
			public int compare(SysMenu o1, SysMenu o2) {
				return o1.getSort()-o2.getSort();
			}
		});
		for (SysMenu sysMenu : list) {
			addChild(sysMenu,findEntityAll);
		}
		return list;
	}

	private void addChild(SysMenu sysMenu, List<SysMenu> findEntityAll) {
		for (SysMenu sysMenuChild : findEntityAll) {
			if(sysMenuChild.getPid() == sysMenu.getId()) {
				sysMenu.getList().add(sysMenuChild);
				addChild(sysMenuChild, findEntityAll);
			}
		}
		sysMenu.getList().sort(new Comparator<SysMenu>() {
			@Override
			public int compare(SysMenu o1, SysMenu o2) {
				return o1.getSort()-o2.getSort();
			}
		});
	}
}
