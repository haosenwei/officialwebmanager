package com.official.web.origin.service.sys.dic;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.sys.dic.SysDicItem;
import com.official.web.origin.mapper.sys.dic.SysDicItemMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class SysDicItemServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	SysDicItemMapper sysDicItemMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public SysDicItem findSysDicItemById(Long id) {
		return sysDicItemMapper.selectSysDicItemById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<SysDicItem> findEntityAll() {
		return sysDicItemMapper.selectSysDicItemAll();
	}
	
	/**
	 * 新增,null实体
	 * @param sysDicItemForm
	 */
	public void addSysDicItem(SysDicItem sysDicItemForm) {
		sysDicItemMapper.insertSysDicItem(sysDicItemForm);
	}

	/**
	 * 更新,null实体
	 * @param sysDicItemForm
	 */
	public void modifySysDicItem(SysDicItem sysDicItemForm) {
		sysDicItemMapper.updateSysDicItem(sysDicItemForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifySysDicItemByCondition(Map<String, Object> condition) {
		sysDicItemMapper.updateSysDicItemByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeSysDicItemByIds(String ids) {
		sysDicItemMapper.delSysDicItemByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<SysDicItem> findSysDicItemByCondition(Map<String, Object> condition) {
		return sysDicItemMapper.selectSysDicItemByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findSysDicItemByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<SysDicItem> list=sysDicItemMapper.selectSysDicItemByPager(condition);
		int count=sysDicItemMapper.selectSysDicItemCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}