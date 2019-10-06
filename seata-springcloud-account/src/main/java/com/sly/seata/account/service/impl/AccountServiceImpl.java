package com.sly.seata.account.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.sly.seata.account.mapper.AccountMapper;
import com.sly.seata.account.service.AccountService;
import com.sly.seata.common.exception.BizException;
import com.sly.seata.common.model.account.Account;
import com.sly.seata.common.model.storage.Storageinfo;
import com.sly.seata.common.utils.CommonUtils;
import com.sly.seata.storage.service.StorageinfoService;

import io.seata.core.context.RootContext;
import io.seata.spring.annotation.GlobalTransactional;

/**
 * 账户service实现
 */
@RestController
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountMapper accountMapper;
	@Autowired
	private StorageinfoService storageinfoService;
	/**
	 * 新增
	 * 
	 * @param account
	 * @return
	 */
	@GlobalTransactional
	@Override
	public Map<String, Object> insert(Account account) {
		String xid = RootContext.getXID();
		System.out.println("seata-springcloud-account  ---insert xid:"+xid);
		accountMapper.insert(account);
		System.out.println("seata-springcloud-account  ---insert success.");
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		if("callOrderSevice0".equals(account.getAccountName())) {
			System.out.println("AccountServiceImpl callOrderSevice0 test rollBack transaction 123.");
			throw new RuntimeException("AccountServiceImpl callOrderSevice0 test rollBack transaction 123.");
		}
		if("callOrderSevice01".equals(account.getAccountName())) {
			System.out.println("AccountServiceImpl callOrderSevice01 commit.");
		}
		if("callOrderSevice".equals(account.getAccountName())) {
			Storageinfo storageinfo = new Storageinfo();
			storageinfo.setStorage2Id(CommonUtils.genUUID());
			storageinfo.setStorage2Name("callOrderSevice");
			storageinfo.setStorage2Count(20);
			storageinfo.setRemark2("备注callOrderSevice");
		    storageinfo.setLogic2Del("N");
		    
		    Map<String, Object> insert = null;
		    try {
		    	System.out.println("callOrderSevice调用服务Storageinfo ....begin.");
		    	insert = storageinfoService.insert(storageinfo );//调用另一个微服务
		    	System.out.println("callOrderSevice调用服务Storageinfo ....result:"+insert);
			    if((int)insert.get("status") != 200) {
			      throw new RuntimeException((String)insert.get("message"));
			    }
			    System.out.println("callOrderSevice调用服务Storageinfo ....success.");
		    }catch(Exception e) {
		    	System.out.println("callOrderSevice-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    	throw new RuntimeException("callOrderSevice-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    }
		}
		if("callOrderSevice1".equals(account.getAccountName())) {
			Storageinfo storageinfo = new Storageinfo();
			storageinfo.setStorage2Id(CommonUtils.genUUID());
			storageinfo.setStorage2Name("callOrderSevice1");
			storageinfo.setStorage2Count(20);
			storageinfo.setRemark2("备注callOrderSevice1");
		    storageinfo.setLogic2Del("N");
		    
		    Map<String, Object> insert = null;
		    try {
		    	System.out.println("callOrderSevice1调用服务Storageinfo ....begin.");
		    	insert = storageinfoService.insert(storageinfo );//调用另一个微服务
		    	System.out.println("callOrderSevice1调用服务Storageinfo ....result:"+insert);
			    if((int)insert.get("status") != 200) {
			      throw new RuntimeException((String)insert.get("message"));
			    }
			    System.out.println("callOrderSevice1调用服务Storageinfo ....success.");
		    }catch(Exception e) {
		    	System.out.println("callOrderSevice1-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    	throw new RuntimeException("callOrderSevice1-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    }
		}
		
		if("callOrderSevice2".equals(account.getAccountName())) {
			Storageinfo storageinfo = new Storageinfo();
			storageinfo.setStorage2Id(CommonUtils.genUUID());
			storageinfo.setStorage2Name("callOrderSevice2");
			storageinfo.setStorage2Count(20);
			storageinfo.setRemark2("备注callOrderSevice2");
		    storageinfo.setLogic2Del("N");
		    
		    Map<String, Object> insert = null;
		    try {
		    	System.out.println("callOrderSevice2调用服务Storageinfo ....begin.");
		    	insert = storageinfoService.insert(storageinfo );//调用另一个微服务
		    	System.out.println("callOrderSevice2调用服务Storageinfo ....result:"+insert);
			    if((int)insert.get("status") != 200) {
			      throw new RuntimeException((String)insert.get("message"));
			    }
			    System.out.println("callOrderSevice2调用服务Storageinfo ....success.");
		    }catch(Exception e) {
		    	System.out.println("callOrderSevice2-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    	throw new RuntimeException("callOrderSevice2-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    }
		}
		
		if("callOrderSevice3".equals(account.getAccountName())) {
			Storageinfo storageinfo = new Storageinfo();
			storageinfo.setStorage2Id(CommonUtils.genUUID());
			storageinfo.setStorage2Name("callOrderSevice3");
			storageinfo.setStorage2Count(20);
			storageinfo.setRemark2("备注callOrderSevice3");
		    storageinfo.setLogic2Del("N");
		    
		    Map<String, Object> insert = null;
		    try {
		    	System.out.println("callOrderSevice3调用服务Storageinfo ....begin.");
		    	insert = storageinfoService.insert(storageinfo );//调用另一个微服务
		    	System.out.println("callOrderSevice3调用服务Storageinfo ....result:"+insert);
			    if((int)insert.get("status") != 200) {
			      throw new RuntimeException((String)insert.get("message"));
			    }
			    System.out.println("callOrderSevice3调用服务Storageinfo ....success.");
		    }catch(Exception e) {
		    	System.out.println("callOrderSevice3-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    	throw new RuntimeException("callOrderSevice3-帐户调用Storageinfo服务异常,msg:"+e.getMessage());
		    }
		}
		
		return result;
	}
	@GlobalTransactional
	@Override
	public Map<String, Object> insert1(Account account) {
		String xid = RootContext.getXID();
		System.out.println("seata-springcloud-account new  ---insert xid:"+xid);
		accountMapper.insert(account);
		System.out.println("seata-springcloud-account new ---insert success.");
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 200);
		result.put("message", "新增成功！");
		
		Storageinfo storage2 = new Storageinfo();
	    storage2.setStorage2Id(CommonUtils.genUUID());
	    storage2.setStorage2Name("nameFormAccound0");
	    storage2.setStorage2Count(20);
	    storage2.setRemark2("备注FormAccound");
	    storage2.setLogic2Del("N");
	    System.out.println("AccountServiceImpl.insert(account ) begin....");
	    if("nameFromStorageinfo".equals(account.getAccountName())) {
	    	storage2.setStorage2Name("nameFormAccound66");
	    }
	    Map<String, Object> insert = null;
	    try {
	    	insert = storageinfoService.insert(storage2 );//调用另一个微服务
	    	System.out.println("AccountServiceImpl.insert(account ) after....resutl:"+insert);
		    if((int)insert.get("status") != 200) {
		      throw new RuntimeException((String)insert.get("message"));
		    }
		    System.out.println("AccountServiceImpl.insert(account ) 调用另一个微服务successful.");
	    }catch(Exception e) {
	    	if(e instanceof BizException) {
	    		System.out.println("this is BizException:"+e.getMessage());
	    	}
	    	System.out.println("cls:"+e.getClass()+",调用另一个微服务 storageinfoService.insert exception.msg="+e.getMessage());
	    	e.printStackTrace();
	    	/**
	    	 * com.netflix.client.ClientException 服务不存在异常
	    	 */
	    	//throw new RuntimeException(e);
	    	throw new BizException(BizException.BizException_Account, "帐户服务异常,msg:"+e.getMessage());
	    }
	    
	    
		if("123".length()==3) {
			//throw new RuntimeException("模拟创建订单服务出现异常!666");
		}
		if("123".length()==3) {
			/*
			try {
				System.out.println("模拟业务执行，耗时1分钟");
				Thread.sleep(60_000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			*/
		}
		return result;
	}

}
