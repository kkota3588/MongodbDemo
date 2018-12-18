package com.walmart.arsenal.imdg.common.loader;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.mongo.MongoDataAutoConfiguration;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;

import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.walmart.arsenal.imdg.beans.EmployeeRequest;
import com.walmart.arsenal.imdg.common.connection.IMDGConfig;

@ComponentScan({
//"com.walmart.arsenal.imdg.beans", "com.walmart.arsenal.imdg.common.nosql.mapstore",
//		"com.walmart.arsenal.imdg.common.connection", "com.walmart.arsenal.imdg.controller",
//		"com.walmart.arsenal.imdg.common.nosql.wrapper", "com.walmart.arsenal.imdg.common.connection",
		"com.walmart.arsenal.imdg" })
@SpringBootApplication(exclude = { MongoAutoConfiguration.class, MongoDataAutoConfiguration.class })
@EnableConfigurationProperties
public class DefaultIMDGLoader implements CommandLineRunner {

	@Autowired
	IMDGConfig imdgConfig;

	static {
		System.setProperty("spring.config.location",
				"file:D://MYAPPLICATIONS//Practice_On_SpringBoot//SpringBootMongoDB//src//main//resources//arsenalImdg.yml");

	}

	public static void main(String[] args) {
		SpringApplication.run(DefaultIMDGLoader.class, args);
	}

	@Override
	public void run(String... arg0) throws Exception {
		try {
			HazelcastInstance hzInstance = imdgConfig.getInstance();
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("EID", "1");
//			map.put("EName", "krishna");
//			map.put("ESal", "30000");
//			map.put("EDep", "dev");
//	
//			IMap<Object, Object> imap = hzInstance.getMap("Employees");
//
//			imap.put("EmployeeData", map);
//			System.out.println(imap.get("EmployeeData"));
		} catch (Exception exception) {
			exception.printStackTrace();
		}

	}

}