package com.official.web.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.official.web.origin.entity.sys.dic.SysDicGroup;
import com.official.web.origin.entity.sys.dic.SysDicItem;
import com.official.web.origin.service.sys.dic.SysDicGroupServiceImpl;
import com.official.web.origin.service.sys.dic.SysDicItemServiceImpl;

@Service
public class SysDicBizService {

	@Autowired
	private SysDicItemServiceImpl sysDicItemServiceImpl;
	
	@Autowired
	private SysDicGroupServiceImpl sysDicGroupServiceImpl;
	
	public Map<String, List<SysDicItem>> selectSysDic() {
		Map<String, List<SysDicItem>> map = new HashMap<String, List<SysDicItem>>();
		Map<Long, String> nameMap = new HashMap<Long, String>();
//		dicGroupServiceImpl.
		List<SysDicItem> findEntityAll = sysDicItemServiceImpl.findEntityAll();
		List<SysDicGroup> findEntityAll2 = sysDicGroupServiceImpl.findEntityAll();
		for (SysDicGroup sysDicGroup : findEntityAll2) {
			map.put(sysDicGroup.getName(), new ArrayList<SysDicItem>());
			nameMap.put(sysDicGroup.getId(), sysDicGroup.getName());
		}
		for (SysDicItem sysDicItem : findEntityAll) {
			String string = nameMap.get(sysDicItem.getGroupId());
			if(StringUtils.isBlank(string)) {
				continue;
			}
			map.get(string).add(sysDicItem);
		}
		return map;
	}

}
