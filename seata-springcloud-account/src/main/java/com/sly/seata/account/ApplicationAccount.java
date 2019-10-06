package com.sly.seata.account;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * account 启动类
 * 
 * @EnableFeignClients(basePackages="com.sly.seata")
@EnableCircuitBreaker
@SpringBootApplication old


 */


@EnableEurekaClient
@EnableFeignClients(basePackages="com.sly.seata")
@EnableCircuitBreaker
@SpringBootApplication
@MapperScan("com.sly.seata.account.mapper")
public class ApplicationAccount {

	public static void main(String[] args) {
		SpringApplication.run(ApplicationAccount.class, args);
	}

}
