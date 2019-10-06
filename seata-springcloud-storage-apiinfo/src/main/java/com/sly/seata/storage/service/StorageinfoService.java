package com.sly.seata.storage.service;

import java.util.Map;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.sly.seata.common.model.storage.Storageinfo;
import com.sly.seata.storage.service.hystrix.StorageinfoServiceHystrixImpl;

/**
 * Storageinfo feign客户端
 * 
 * @author sly
 * @time 2019年6月12日
 */
@FeignClient(name = "seata-springcloud-storageinfo", fallback = StorageinfoServiceHystrixImpl.class)
public interface StorageinfoService {

	/**
	 * 新增
	 * 
	 * @param storage
	 * @return
	 * @author sly
	 * @time 2019年6月12日
	 */
	@RequestMapping(value = "/storageinfo/insert", method = RequestMethod.POST)
	Map<String, Object> insert(@RequestBody Storageinfo storageinfo);

}
