package com.sly.seata.storage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.common.model.storage.Storage;
//import com.sly.seata.common.model.storage.Storage2;
//import com.sly.seata.common.utils.CommonUtils;
import com.sly.seata.storage.mapper.StorageMapper;
//import com.sly.seata.storage.service.Storage2Service;
import com.sly.seata.storage.service.StorageService;

import io.seata.core.context.RootContext;

/**
 * 仓储service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class StorageServiceImpl implements StorageService {

	@Autowired
	private StorageMapper storageMapper;
	
//	@Autowired
//	private Storage2Service storage2Service;//微服务调用另个微服务
	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(@RequestBody Storage storage) {
		String xid = RootContext.getXID();
		System.out.println("seata-springcloud-storage ---insert xid:"+xid);
		//int a = 10/0;
		storageMapper.insert(storage);
		
		Map<String,Object> tmp;
		List<Map<String,Object>> logList = storageMapper.selectLog();
		for(int i=0;i<logList.size();i++) {
			System.out.println("logList["+i+"]:"+logList.get(i));
			tmp = logList.get(i);
			System.out.println("lockList["+i+"].id:"+tmp.get("id")
				+",xid:"+tmp.get("xid")
				+",branch_id:"+tmp.get("branch_id")
				+",context:"+tmp.get("context")
				);
		}
//		Storage2 storage2 = new Storage2();
//		storage2.setStorage2Id(CommonUtils.genUUID());
//		storage2.setStorage2Name("name2");
//		storage2.setStorage2Count(20);
//		storage2.setRemark2("备注2");
//		storage2.setLogic2Del("N");
//		Map<String, Object> insert = storage2Service.insert(storage2 );//调用另一个微服务
//		if((int)insert.get("status") != 200) {
//			throw new RuntimeException((String)insert.get("message"));
//		}
//		System.out.println("storage2Service.insert(storage2 ) 调用另一个微服务successful.");
		/*
		List<Map<String,Object>> lockList = storageMapper.selectLockTable();
		for(int i=0;i<lockList.size();i++) {
			tmp = lockList.get(i);
			System.out.println("lockList["+i+"].row_key:"+tmp.get("row_key")
				+",xid:"+tmp.get("xid")
				+",transaction_id:"+tmp.get("transaction_id")
				+",branch_id:"+tmp.get("branch_id")
				+",resource_id:"+tmp.get("resource_id")
				+",table_name:"+tmp.get("table_name")
				+",pk:"+tmp.get("pk")
				);
		}
		
		List<Map<String,Object>> bList = storageMapper.selectBranchTable();
		for(int i=0;i<bList.size();i++) {
			tmp = bList.get(i);
			System.out.println("bList["+i+"].transaction_id:"+tmp.get("transaction_id")
				+",xid:"+tmp.get("xid")
				+",branch_id:"+tmp.get("branch_id")
				+",resource_id:"+tmp.get("resource_id")
				+",resource_group_id:"+tmp.get("resource_group_id")
				+",lock_key:"+tmp.get("lock_key")
				+",branch_type:"+tmp.get("branch_type")
				+",client_id:"+tmp.get("client_id")
				);
		}
		
		List<Map<String,Object>> gList = storageMapper.selectGlobalTable();
		for(int i=0;i<gList.size();i++) {
			System.out.println("gList["+i+"]:"+gList.get(i));
			tmp = gList.get(i);
			System.out.println("gList["+i+"].transaction_id:"+tmp.get("transaction_id")
				+",xid:"+tmp.get("xid")
				+",status:"+tmp.get("status")
				+",application_id:"+tmp.get("application_id")
				+",transaction_service_group:"+tmp.get("transaction_service_group")
				+",transaction_name:"+tmp.get("transaction_name")
				+",timeout:"+tmp.get("timeout")
				+",application_data:"+tmp.get("application_data")
				);
		}
		*/
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		return result;
	}
}
