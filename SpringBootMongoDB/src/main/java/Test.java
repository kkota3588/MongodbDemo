import static com.mongodb.MongoClientOptions.builder;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Map.Entry;

import org.bson.Document;
import org.mongojack.JacksonDBCollection;
import org.springframework.context.ApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import com.hazelcast.config.Config;
import com.hazelcast.config.FileSystemXmlConfig;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.core.IMap;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientOptions;
import com.mongodb.MongoClientURI;
import com.walmart.arsenal.imdg.beans.EmployeeRequest;

public class Test {
	@SuppressWarnings("deprecation")
	public static void main(String args[]) {

		try {
			EmployeeRequest req = new EmployeeRequest();
			req.setEmpId("101");
			req.setEmpName("Krishna");
			req.setEmpSal("100000");
			req.setEmpDep("Dev");

			Config config = new FileSystemXmlConfig("src/main/resources/hazelcast.xml");
			HazelcastInstance hazelcastInstance = Hazelcast.newHazelcastInstance(config);
			IMap<Object, Object> imp = hazelcastInstance.getMap("testing123");

			imp.put("EmployeeData1", req);
			imp.get("EmployeeData");
			for (Entry<Object, Object> entry : imp.entrySet()) {
				System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
			}

//			MongoClientURI connectionString = new MongoClientURI("mongodb://localhost:27017");
//			MongoClient mongoClient = new MongoClient(connectionString);
//			System.out.println(mongoClient);
//			DB db = mongoClient.getDB("test");
//			DBCollection collection = db.getCollection("Employees");
//			Document documents = new Document();
//			documents.append("EID", req.getEmpId());
//			documents.append("ENAME", req.getEmpName());
//			documents.append("Esal", req.getEmpSal());
//			documents.append("Edep", req.getEmpDep());
//			collection.insert(new BasicDBObject("EmployeeData", documents));
//			DBCursor dbCursor = collection.find();
//
//			while (dbCursor.hasNext()) {
//				System.out.println(dbCursor.next());
//			}
//		
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
