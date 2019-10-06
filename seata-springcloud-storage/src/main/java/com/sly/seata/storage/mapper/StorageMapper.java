package com.sly.seata.storage.mapper;

import java.util.List;
import java.util.Map;

import com.sly.seata.common.model.storage.Storage;

/**
 * 仓储mapper
 * 
 * @author sly
 * @time 2019年6月12日
 */
public interface StorageMapper {

	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	int insert(Storage storage);
	
	List<Map<String,Object>> selectLog();
	
	List<Map<String,Object>> selectBranchTable();
	
	List<Map<String,Object>> selectGlobalTable();
	
	List<Map<String,Object>> selectLockTable();
}
