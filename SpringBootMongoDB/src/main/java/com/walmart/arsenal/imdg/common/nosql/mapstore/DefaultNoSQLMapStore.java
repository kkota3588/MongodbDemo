package com.walmart.arsenal.imdg.common.nosql.mapstore;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import org.mongojack.DBCursor;
import org.mongojack.DBQuery;
import org.mongojack.JacksonDBCollection;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.MapLoaderLifecycleSupport;
import com.hazelcast.core.MapStore;
import com.mongodb.MongoClient;
import com.walmart.arsenal.imdg.common.nosql.wrapper.DocumentWrapper;
@Configuration
@Component
public class DefaultNoSQLMapStore
		implements MapStore<String, Object>, ApplicationContextAware, MapLoaderLifecycleSupport {

	private static final String MONGO_DB_UNIQUE_DOCUMENT_ID = "_id";

	private MongoClient mongoClient;
	private static ApplicationContext context;
	JacksonDBCollection<DocumentWrapper, String> collection;

	private ObjectMapper mapper = new ObjectMapper();

	@SuppressWarnings({ "deprecation" })
	@Override
	public void init(HazelcastInstance hazelcastInstance, Properties properties, String mapName) {
		try {
			this.mongoClient = (MongoClient) context.getBean("mongoclient");
			mapper.registerModule(new ParameterNamesModule()).registerModule(new Jdk8Module())
					.registerModule(new JavaTimeModule());
			collection = JacksonDBCollection.wrap(
					mongoClient.getDB(context.getEnvironment().getProperty("mongodb.db")).getCollection(mapName),
					DocumentWrapper.class, String.class);
		} catch (Exception exception) {
			exception.printStackTrace();

		}
	}

	@Override
	public Object load(String key) {

		try {
			DocumentWrapper wrapper = collection.findOneById(key);
			if (wrapper != null) {
				return mapper.readValue(wrapper.getObjectJsonString(), wrapper.getClassType());
			}
		} catch (Exception exception) {

			exception.printStackTrace();
		}
		return null;
	}

	@Override
	public Map<String, Object> loadAll(Collection<String> keys) {

		Map<String, Object> documentWrapperMap = new HashMap<String, Object>();
		try {
			for (String key : keys) {
				DocumentWrapper wrapper = collection.findOneById(key);
				documentWrapperMap.put(wrapper.getId(),
						mapper.readValue(wrapper.getObjectJsonString(), wrapper.getClassType()));
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return documentWrapperMap;
	}

	@Override
	public Iterable<String> loadAllKeys() {

		List<String> keys = new ArrayList<String>();
		try {
			DBCursor<DocumentWrapper> cursor;
			DBQuery.Query query = DBQuery.exists(MONGO_DB_UNIQUE_DOCUMENT_ID);
			cursor = collection.find(query);
			Iterator<DocumentWrapper> iterator = cursor.iterator();
			while (iterator.hasNext()) {
				keys.add(iterator.next().getId());
			}
		} catch (Exception exception) {
			exception.printStackTrace();
		}
		return keys;
	}

	@Override
	public void store(String key, Object value) {
		try {
			DocumentWrapper wrapper = new DocumentWrapper(key, mapper.writeValueAsString(value), value.getClass());
			this.collection.save(wrapper);
		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void storeAll(Map<String, Object> map) {
		try {
			List<DocumentWrapper> batch = new ArrayList<DocumentWrapper>();
			for (Map.Entry<String, Object> entry : map.entrySet()) {
				String key = entry.getKey();
				Object value = entry.getValue();
				Class<? extends Object> className = entry.getValue().getClass();
				batch.add(new DocumentWrapper(key, mapper.writeValueAsString(value), className));
			}
			this.collection.insert(batch);

		} catch (Exception exception) {
			exception.printStackTrace();
		}
	}

	@Override
	public void delete(String key) {

	}

	@Override
	public void deleteAll(Collection<String> keys) {

	}

	@Override
	public void destroy() {
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		DefaultNoSQLMapStore.context = applicationContext;

	}

}
