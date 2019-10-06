package com.sly.seata.storage;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * storage 启动类
 * 
 * @author sly
 * @time 2019年6月12日
 */
//@EnableEurekaClient
//@SpringBootApplication
//@MapperScan("com.sly.seata.storage.mapper")

@EnableEurekaClient
@EnableFeignClients(basePackages="com.sly.seata")
@EnableCircuitBreaker
@SpringBootApplication
@MapperScan("com.sly.seata.storage.mapper")
public class ApplicationStorageinfo {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationStorageinfo.class, args);
	}

}
