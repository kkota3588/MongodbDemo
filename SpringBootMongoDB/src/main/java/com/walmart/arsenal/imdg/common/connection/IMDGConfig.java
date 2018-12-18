package com.walmart.arsenal.imdg.common.connection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;

@Configuration
@ConfigurationProperties
public class IMDGConfig {

	@Value("${imdg.file.path:#{null}}")
	private String IMDG_XML_FILE_PATH;

	@Autowired
	HazelcastInstance hazelcastInstance;

	@Bean
	public HazelcastInstance getInstance() {
		try {
			if (hazelcastInstance == null) {
				Config config = new FileSystemXmlConfig(IMDG_XML_FILE_PATH);
				hazelcastInstance = Hazelcast.newHazelcastInstance(config);
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return hazelcastInstance;

	}

}