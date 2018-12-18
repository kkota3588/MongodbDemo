//package com.walmart.arsenal.imdg.controller;
//
//import java.util.HashMap;
//import java.util.Map;
//
//import org.bson.Document;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.http.MediaType;
//import org.springframework.stereotype.Component;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.hazelcast.core.HazelcastInstance;
//import com.hazelcast.core.IMap;
//import com.walmart.arsenal.imdg.beans.EmployeeRequest;
//import com.walmart.arsenal.imdg.common.connection.IMDGConfig;
//
//@RestController
//public class Controller {
//
//	@Autowired
//	IMDGConfig imdgConfig;
////	@Autowired
////	HazelcastInstance hzInstance;
//
//	@RequestMapping(value = "/insert", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
////	public ResponseEntity<EmployeeResponse> putData(@RequestBody EmployeeRequest req) throws Exception {
//	public String putData(@RequestBody EmployeeRequest req) {
//		try {
////			Document document = new Document();
////			document.put("EID", req.getEmpId());
////			document.put("EName", req.getEmpName());
////			document.put("ESal", req.getEmpSal());
////			document.put("EDep", req.getEmpDep());
//
//			Map<String, String> map = new HashMap<String, String>();
//			map.put("EID", req.getEmpId());
//			map.put("EName", req.getEmpName());
//			map.put("ESal", req.getEmpSal());
//			map.put("EDep", req.getEmpDep());
//			HazelcastInstance hzInstance = imdgConfig.getInstance();
//			IMap<Object, Object> imap = hzInstance.getMap("Employees");
//
//			imap.put("EmployeeData", map);
//			System.out.println(imap.get("EmployeeData"));
//			// return new ResponseEntity<EmployeeResponse>(response, HttpStatus.OK);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return "successfully inserted";
//	}
//}
