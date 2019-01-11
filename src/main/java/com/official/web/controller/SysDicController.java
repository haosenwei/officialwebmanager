package com.official.web.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.official.web.origin.entity.sys.dic.SysDicItem;
import com.official.web.service.SysDicBizService;

@Controller
public class SysDicController {
	private static final Logger logger = LoggerFactory.getLogger(SysDicController.class);
	
	@Autowired
	SysDicBizService sysDicBizService;
	
	
	@RequestMapping("/selectDic")
	public String toSelectDic(HttpServletRequest request) {
		Map<String, List<SysDicItem>> list = sysDicBizService.selectSysDic();
		request.setAttribute("data", list);
		return "sys/dic/selectSysDic";
	}
}
