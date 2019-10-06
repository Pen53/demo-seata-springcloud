package com.sly.seata.storage.service.hystrix;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.sly.seata.common.model.storage.Storageinfo;
import com.sly.seata.storage.service.StorageinfoService;

/**
 * Storageinfo熔断
 * 
 * @author sly
 * @time 2019年6月12日
 */
@Component
public class StorageinfoServiceHystrixImpl implements StorageinfoService {
	public StorageinfoServiceHystrixImpl() {
		System.out.println("----------初始化StorageinfoServiceHystrixImpl---------66666");
	}
	/**
	 * 新增失败熔断返回
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@Override
	public Map<String, Object> insert(Storageinfo storage2) {
		Map<String, Object> result = new HashMap<>(16);
		result.put("status", 400);
		result.put("message", "调用仓储23456新增服务失败！StorageinfoServiceHystrixImpl result.");
		return result;
	}

}
