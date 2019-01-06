package com.official.web.service;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.web.entity.SysMenuVo;
import com.official.web.origin.entity.sys.SysMenu;
import com.official.web.origin.service.sys.SysMenuServiceImpl;

@Service
public class SysMenuService {
	
	@Autowired
	SysMenuServiceImpl sysMenuServiceImpl;
	
	public List<SysMenuVo> getSysMenu() throws IllegalAccessException, InvocationTargetException {
		List<SysMenu> findEntityAll = sysMenuServiceImpl.findEntityAll();
		List<SysMenuVo> sysMenuVoAll = new ArrayList<SysMenuVo>();
		for (SysMenu sysMenu : findEntityAll) {
			SysMenuVo sysMenuVo = new SysMenuVo();
			BeanUtils.copyProperties(sysMenuVo, sysMenu);
			sysMenuVoAll.add(sysMenuVo);
		}
		
		
		List<SysMenuVo> list= new ArrayList<SysMenuVo>();
		for (SysMenuVo sysMenu : sysMenuVoAll) {
			if(sysMenu.getTypeDic().equals("1")) {
				list.add(sysMenu);
			}
		}
		list.sort(new Comparator<SysMenuVo>() {
			@Override
			public int compare(SysMenuVo o1, SysMenuVo o2) {
				return o1.getSort()-o2.getSort();
			}
		});
		for (SysMenuVo sysMenu : list) {
			addChild(sysMenu,sysMenuVoAll);
		}
		return list;
	}

	private void addChild(SysMenuVo sysMenu, List<SysMenuVo> findEntityAll) {
		for (SysMenuVo sysMenuChild : findEntityAll) {
			if(sysMenuChild.getPid() == sysMenu.getId()) {
				sysMenu.getList().add(sysMenuChild);
				addChild(sysMenuChild, findEntityAll);
			}
		}
		sysMenu.getList().sort(new Comparator<SysMenuVo>() {
			@Override
			public int compare(SysMenuVo o1, SysMenuVo o2) {
				return o1.getSort()-o2.getSort();
			}
		});
	}
}
