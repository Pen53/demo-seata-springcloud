package com.sly.seata.order.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.account.service.AccountService;
import com.sly.seata.common.model.account.Account;
import com.sly.seata.common.model.order.Order;
import com.sly.seata.common.utils.CommonUtils;
import com.sly.seata.order.mapper.OrderMapper;
import com.sly.seata.order.service.OrderService;

import io.seata.core.context.RootContext;

/**
 * 订单service实现
 * 
 * @author sly
 * @time 2019年6月12日
 */
@RestController
public class OrderServiceImpl implements OrderService {

	@Autowired
	private OrderMapper orderMapper;
	
	@Autowired 
	private AccountService accountService;
	/**
	 * 新增
	 * 
	 * @param order
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(@RequestBody Order order) {
		System.out.println("seata-springcloud-order -----OrderServiceImpl insert:"+RootContext.getXID());
		
		orderMapper.insert(order);
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		if("123".length()==3) {
			//throw new RuntimeException("订单 test Transaction 123456.");
		}
		if("rollBack".equals(order.getOrderDetail())) {
			System.out.println("order.getOrderDetail()=callOrderSevice 订单 test throw RuntimeException.");
			throw new RuntimeException("order.getOrderDetail()=callOrderSevice 订单 test throw RuntimeException.");
		}
		if("callOrderSevice0".equals(order.getOrderDetail())) {
			Account account = new Account();
			account.setAccountId(CommonUtils.genUUID());
			account.setAccountName("callOrderSevice0");
			System.out.println("OrderServiceImpl callOrderSevice0-调用服务accountService.insert(account ) begin.");	
			try {	
				Map<String, Object> insert = accountService.insert(account );
				System.out.println("callOrderSevice0 调用服务accountService.insert(account ) result:"+insert);
				if((int)insert.get("status") != 200) {
					throw new RuntimeException((String)insert.get("message"));
				}
				System.out.println("OrderServiceImpl callOrderSevice0-调用服务accountService.insert(account ) success.");
			}catch(Exception e) {
				throw new RuntimeException("callOrderSevice0订单服务调用帐户服务失败，msg:"+e.getMessage());
			}
		}
		if("callOrderSevice01".equals(order.getOrderDetail())) {
			Account account = new Account();
			account.setAccountId(CommonUtils.genUUID());
			account.setAccountName("callOrderSevice01");
			System.out.println("OrderServiceImpl callOrderSevice01-调用服务accountService.insert(account ) begin.");	
			try {	
				Map<String, Object> insert = accountService.insert(account );
				System.out.println("callOrderSevice01 调用服务accountService.insert(account ) result:"+insert);
				if((int)insert.get("status") != 200) {
					throw new RuntimeException((String)insert.get("message"));
				}
				System.out.println("OrderServiceImpl callOrderSevice01-调用服务accountService.insert(account ) success.");
			}catch(Exception e) {
				throw new RuntimeException("callOrderSevice01订单服务调用帐户服务失败，msg:"+e.getMessage());
			}
		}
		if("callOrderSevice".equals(order.getOrderDetail())) {
			Account account = new Account();
			account.setAccountId(CommonUtils.genUUID());
			account.setAccountName("callOrderSevice");
			System.out.println("OrderServiceImpl callOrderSevice-调用服务accountService.insert(account ) begin.");	
			try {	
				Map<String, Object> insert = accountService.insert(account );
				System.out.println("callOrderSevice 调用服务accountService.insert(account ) result:"+insert);
				if((int)insert.get("status") != 200) {
					throw new RuntimeException((String)insert.get("message"));
				}
				System.out.println("OrderServiceImpl callOrderSevice-调用服务accountService.insert(account ) success.");
			}catch(Exception e) {
				throw new RuntimeException("callOrderSevice订单服务调用帐户服务失败，msg:"+e.getMessage());
			}
		}
		if("callOrderSevice1".equals(order.getOrderDetail())) {
			Account account = new Account();
				account.setAccountId(CommonUtils.genUUID());
				account.setAccountName("callOrderSevice1");
			System.out.println("OrderServiceImpl callOrderSevice1-调用服务accountService.insert(account ) begin.");	
			try {	
				Map<String, Object> insert = accountService.insert(account );
				System.out.println("callOrderSevice1 调用服务accountService.insert(account ) result:"+insert);
				if((int)insert.get("status") != 200) {
					throw new RuntimeException((String)insert.get("message"));
				}
				System.out.println("OrderServiceImpl callOrderSevice1-调用服务accountService.insert(account ) success.");
			}catch(Exception e) {
				throw new RuntimeException("callOrderSevice1订单服务调用帐户服务失败，msg:"+e.getMessage());
			}
		}
		if("callOrderSevice2".equals(order.getOrderDetail())) {
			Account account = new Account();
				account.setAccountId(CommonUtils.genUUID());
				account.setAccountName("callOrderSevice2");
			System.out.println("OrderServiceImpl callOrderSevice2-调用服务accountService.insert(account ) begin.");	
			try {	
				Map<String, Object> insert = accountService.insert(account );
				System.out.println("callOrderSevice2 调用服务accountService.insert(account ) result:"+insert);
				if((int)insert.get("status") != 200) {
					throw new RuntimeException((String)insert.get("message"));
				}
				System.out.println("OrderServiceImpl callOrderSevice2-调用服务accountService.insert(account ) success.");
			}catch(Exception e) {
				throw new RuntimeException("callOrderSevice2订单服务调用帐户服务失败，msg:"+e.getMessage());
			}
		}
		if("callOrderSevice3".equals(order.getOrderDetail())) {
			Account account = new Account();
				account.setAccountId(CommonUtils.genUUID());
				account.setAccountName("callOrderSevice3");
			System.out.println("OrderServiceImpl callOrderSevice3-调用服务accountService.insert(account ) begin.");	
			try {	
				Map<String, Object> insert = accountService.insert(account );
				System.out.println("callOrderSevice3 调用服务accountService.insert(account ) result:"+insert);
				if((int)insert.get("status") != 200) {
					throw new RuntimeException((String)insert.get("message"));
				}
				System.out.println("OrderServiceImpl callOrderSevice3-调用服务accountService.insert(account ) success.");
			}catch(Exception e) {
				throw new RuntimeException("callOrderSevice3订单服务调用帐户服务失败，msg:"+e.getMessage());
			}
		}
		
		if("callOrderSevice2FromStorageinfo".equals(order.getOrderDetail())) {
			System.out.println("order.getOrderDetail()=callOrderSevice2FromStorageinfo 订单 test throw RuntimeException.");
			throw new RuntimeException("order.getOrderDetail()=callOrderSevice2FromStorageinfo 订单 test throw RuntimeException.");
		}
		if("callOrderSevice3FromStorageinfo".equals(order.getOrderDetail())) {
			System.out.println("order.getOrderDetail()=callOrderSevice3FromStorageinfo 订单 服务commit.");
			System.out.println("模拟业务执行时间过长。sleep 40s,会造成account调用timeout,从而整个分布式事务回滚。");
			try {
				Thread.sleep(40_000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("40s睡眠过后ee");
		}
		return result;
	}

}
