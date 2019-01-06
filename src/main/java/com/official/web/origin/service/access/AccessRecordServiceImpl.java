package com.official.web.origin.service.access;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.official.web.origin.entity.common.Pager;
import com.official.web.origin.entity.access.AccessRecord;
import com.official.web.origin.mapper.access.AccessRecordMapper;
import com.official.web.origin.service.IService;

/**
 * ,null服务实现类
 * @author hsw
 *
 */
@Service
@Transactional
public class AccessRecordServiceImpl implements IService {

	/**,null实体操作类**/
	@Autowired
	private	AccessRecordMapper accessRecordMapper;

	/**
	 * 根据id查询,null实体
	 * @param id
	 * @return
	 */
	public AccessRecord findAccessRecordById(int id) {
		return accessRecordMapper.selectAccessRecordById(id);
	}
	
	/**
	 * 查询所有,null实体
	 * @return
	 */
	public List<AccessRecord> findEntityAll() {
		return accessRecordMapper.selectAccessRecordAll();
	}
	
	/**
	 * 新增,null实体
	 * @param accessRecordForm
	 */
	public void addAccessRecord(AccessRecord accessRecordForm) {
		accessRecordMapper.insertAccessRecord(accessRecordForm);
	}

	/**
	 * 更新,null实体
	 * @param accessRecordForm
	 */
	public void modifyAccessRecord(AccessRecord accessRecordForm) {
		accessRecordMapper.updateAccessRecord(accessRecordForm);
	}

	/**
	 * 根据条件更新,null实体
	 * @param condition
	 */
	public void modifyAccessRecordByCondition(Map<String, Object> condition) {
		accessRecordMapper.updateAccessRecordByCondition(condition);
	}

	/**
	 * 根据ids删除,null实体
	 * @param ids
	 */
	public void removeAccessRecordByIds(String ids) {
		accessRecordMapper.delAccessRecordByIds(ids);
	}
	
	/**
	 * 根据条件查询,null实体
	 * @param condition
	 * @return
	 */
	public List<AccessRecord> findAccessRecordByCondition(Map<String, Object> condition) {
		return accessRecordMapper.selectAccessRecordByCondition(condition);
	}
	
	/**
	 * 分页查询,null实体
	 * @param condition
	 * @param pager
	 */
	public void findAccessRecordByPager(Map<String, Object> condition,Pager pager) {
		condition.put("start", pager.getOffset());
		condition.put("length", pager.getLength());
		List<AccessRecord> list=accessRecordMapper.selectAccessRecordByPager(condition);
		int count=accessRecordMapper.selectAccessRecordCountByPager(condition);
		pager.searchResultHandle(list,count);
	}

}