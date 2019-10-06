package com.sly.seata.storage.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.common.model.order.Order;
import com.sly.seata.common.model.storage.Storageinfo;
import com.sly.seata.common.utils.CommonUtils;
import com.sly.seata.order.service.OrderService;
import com.sly.seata.storage.mapper.StorageinfoMapper;
import com.sly.seata.storage.service.StorageinfoService;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;

/**
 * 仓储service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class StorageinfoServiceImpl implements StorageinfoService {

	@Autowired
	private StorageinfoMapper storageinfoMapper;
	@Autowired
	private OrderService orderService;
	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@GlobalTransactional
	@Override
	public Map<String, Object> insert( Storageinfo storage) {
		String xid = RootContext.getXID();
		System.out.println("seata-springcloud-storageinfo ---insert xid:"+xid);
		//int a = 10/0;
		
		storageinfoMapper.insert(storage);
		
		if("callOrderSevice".equals(storage.getStorage2Name())) {
			System.out.println("Storage2Name:callOrderSevice 模拟帐户调用Storageinfo微服务,保存数据库失败!123456.");
			throw new RuntimeException("Storage2Name:callOrderSevice 模拟帐户调用Storageinfo微服务,保存数据库失败!123456.");
		}
		if("callOrderSevice1".equals(storage.getStorage2Name())) {
			System.out.println("callOrderSevice1 commit it.");
		}
		if("callOrderSevice2".equals(storage.getStorage2Name())) {
			//调用另外一个微服务（seata-springcloud-order）
			System.out.println("callOrderSevice2 调用另外一个微服务（seata-springcloud-order） begin.");
			Order order = new Order();
			order.setOrderId(CommonUtils.genUUID());
			order.setOrderNo("NO" + System.currentTimeMillis());
			order.setOrderDetail("callOrderSevice2FromStorageinfo");
			order.setLogicDel("N");
			order.setRemark("remark callOrderSevice2.");
			Map<String, Object> insert0 = orderService.insert(order );
			System.out.println("callOrderSevice2 调用另外一个微服务（seata-springcloud-order） after:"+insert0);
			if((int)insert0.get("status") != 200) {
		      throw new RuntimeException((String)insert0.get("message"));
		    }
			System.out.println("callOrderSevice2 调用另外一个微服务（seata-springcloud-order） success.");
		}
		
		if("callOrderSevice3".equals(storage.getStorage2Name())) {
			//调用另外一个微服务（seata-springcloud-order）
			System.out.println("callOrderSevice3 调用另外一个微服务（seata-springcloud-order） begin.");
			Order order = new Order();
			order.setOrderId(CommonUtils.genUUID());
			order.setOrderNo("NO" + System.currentTimeMillis());
			order.setOrderDetail("callOrderSevice3FromStorageinfo");
			order.setLogicDel("N");
			order.setRemark("remark callOrderSevice3.");
			Map<String, Object> insert0 = orderService.insert(order );
			System.out.println("callOrderSevice3 调用另外一个微服务（seata-springcloud-order） after:"+insert0);
			if((int)insert0.get("status") != 200) {
		      throw new RuntimeException((String)insert0.get("message"));
		    }
			System.out.println("callOrderSevice3 调用另外一个微服务（seata-springcloud-order） success.");
		}
		
//		Map<String,Object> tmp;
//		List<Map<String,Object>> logList = storageinfoMapper.selectLog();
//		for(int i=0;i<logList.size();i++) {
//			System.out.println("logList["+i+"]:"+logList.get(i));
//			tmp = logList.get(i);
//			System.out.println("lockList["+i+"].id:"+tmp.get("id")
//				+",xid:"+tmp.get("xid")
//				+",branch_id:"+tmp.get("branch_id")
//				+",context:"+tmp.get("context")
//				);
//		}
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
