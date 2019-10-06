package com.sly.seata.business.service.impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.account.service.AccountService;
import com.sly.seata.business.service.BusinessService;
import com.sly.seata.common.model.account.Account;
import com.sly.seata.common.model.order.Order;
import com.sly.seata.common.model.storage.Storage;
import com.sly.seata.common.model.storage.Storageinfo;
import com.sly.seata.common.utils.CommonUtils;
import com.sly.seata.common.utils.DateUtils;
import com.sly.seata.order.service.OrderService;
import com.sly.seata.storage.service.StorageinfoService;
import com.sly.seata.storage.service.StorageService;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;

/**
 * 业务service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class BusinessServiceImpl implements BusinessService {
	private static final Logger LOGGER = LoggerFactory.getLogger(BusinessService.class);

	@Autowired
	private AccountService accountService;
	@Autowired
	private OrderService orderService;
	@Autowired
	private StorageService storageService;
	@Autowired
	private StorageinfoService storageinfoService;
	/**
	 * 付款
	 * 
	 * @param accountId
	 * @param orderId
	 * @param storageId
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@GlobalTransactional
	@Override
	public Map<String, Object> purchase(@RequestParam("accountId") String accountId,
			@RequestParam("orderId") String orderId, @RequestParam("storageId") String storageId) {
		try {
			System.out.println("accountId:" + accountId);
			System.out.println("orderId:" + orderId);
			System.out.println("storageId:" + storageId);

			Storage storage = new Storage();
			storage.setStorageId(CommonUtils.genUUID());
			storage.setStorageName("name");
			storage.setStorageCount(20);
			storage.setRemark("备注");
			storage.setLogicDel("N");
			Order order = new Order();
			order.setOrderId(CommonUtils.genUUID());
			order.setOrderNo("NO" + System.currentTimeMillis());
			order.setOrderDetail("详情");
			order.setCreateTime(DateUtils.formateTime(new Date()));
			order.setRemark("备注");
			order.setLogicDel("N");
			Account account = new Account();
			account.setAccountId(CommonUtils.genUUID());
			account.setAccountName("name");
			account.setAmount(new BigDecimal("100.5"));
			account.setLogicDel("N");
			account.setRemark("备注");
			String xid = RootContext.getXID();
			System.out.println("seata-springcloud-business----BusinessServiceImpl xid:" + xid);
			
			Storageinfo storage2 = new Storageinfo();
		    storage2.setStorage2Id(CommonUtils.genUUID());
		    storage2.setStorage2Name("nameFromBusiness");
		    storage2.setStorage2Count(20);
		    storage2.setRemark2("备注2");
		    storage2.setLogic2Del("N");
		    System.out.println("调用另一个微服务 storageinfoService.insert(storage2 ) begin.");
		    Map<String, Object> insert0 = storageinfoService.insert(storage2 );//调用另一个微服务
		    System.out.println("storageinfoService.insert(storage2 ) result:"+insert0);
		    if((int)insert0.get("status") != 200) {
		      throw new RuntimeException((String)insert0.get("message"));
		    }
		    System.out.println("调用另一个微服务 storageinfoService.insert(storage2 ) successful.");
			
		    System.out.println("调用另一个微服务 storageService.insert(storage) begin.");
			Map<String, Object> insert = storageService.insert(storage);
			System.out.println("storageService.insert(storage) result:"+insert);
			if((int)insert.get("status") != 200) {
				throw new RuntimeException((String)insert.get("message"));
			}
			System.out.println("调用另一个微服务 storageService.insert(storage) successful.");
			
			System.out.println("调用另一个微服务 accountService.insert(account) begin.");
			Map<String, Object> insert3 = accountService.insert(account);
			System.out.println("accountService.insert(account) result:"+insert3);
			if((int)insert3.get("status") != 200) {
				throw new RuntimeException((String)insert3.get("message"));
			}
			System.out.println("调用另一个微服务 accountService.insert(account) successful.");
			
			if(storageId.equals("9")) {
				order.setOrderDetail("rollBack");
			}else if(storageId.equals("10")) {
				order.setOrderDetail("callOrderSevice0");
			}else if(storageId.equals("101")) {
				order.setOrderDetail("callOrderSevice01");
			}else if(storageId.equals("11")) {
				order.setOrderDetail("callOrderSevice");
			}else if(storageId.equals("12")) {
				order.setOrderDetail("callOrderSevice1");
			}else if(storageId.equals("13")) {
				order.setOrderDetail("callOrderSevice2");
			}else if(storageId.equals("14")) {
				order.setOrderDetail("callOrderSevice3");
			}
			System.out.println("调用另一个微服务 orderService.insert(order) begin.");
			Map<String, Object> insert2 = orderService.insert(order);
			System.out.println("orderService.insert(order) result:"+insert2);
			if((int)insert2.get("status") != 200) {
				throw new RuntimeException((String)insert2.get("message"));
			}
			System.out.println("调用另一个微服务 orderService.insert(order) successful.");
			
			
			Map<String, Object> result = new HashMap<>(16);
			result.put("status", 200);
			result.put("message", "付款成功！");
			return result;
		} catch (Exception e) {
			System.out.println("BusinessServiceImpl purchase catch cls:"+e.getClass()
					+",msg:"+e.getMessage());
			LOGGER.error(ExceptionUtils.getStackTrace(e));
			throw new RuntimeException(e);
		}
	}

}
