package com.example.user;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConditionalOnClass(FirstSrv.class)
@EnableConfigurationProperties(FirstProperties.class)
@ConditionalOnProperty(prefix = "first", value = "enabled", matchIfMissing = true)
public class FirstAutoConfig {
	@Resource
	private FirstProperties pro;

	@Bean
    @ConditionalOnMissingBean
	public FirstSrv firstSrv(){
		FirstSrv srv = new FirstSrv();
		srv.setName(pro.getName());
		srv.setId(pro.getId());
		srv.setAddress(pro.getAddress());
		return srv;
	}
}
