package com.walmart.arsenal.imdg.common.nosql.mapstore;

import static com.mongodb.MongoClientOptions.builder;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
@Component
@Configuration
@ConfigurationProperties
public class MongoConnection {

	private static final String MONGO_DB_URL = "mongodb://";
	private static final boolean MONGO_SSL = true;

	@Value("${mongodb.url:#{null}}")
	private String MONGO_URL;

	@Bean(name = "mongoclient")
	public Mongo mongo() throws Exception {
//		MongoClientOptions.Builder options = builder().sslEnabled(MONGO_SSL).sslInvalidHostNameAllowed(true);
		MongoClientURI connectionString = new MongoClientURI(MONGO_URL);
		MongoClient mongoClient = new MongoClient(connectionString);
		return mongoClient;
	}

}