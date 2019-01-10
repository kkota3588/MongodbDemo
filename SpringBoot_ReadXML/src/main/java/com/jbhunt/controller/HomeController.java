package com.jbhunt.controller;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.jbhunt.beans.Employee;

@RestController
public class HomeController {
	@Autowired
	Employee employee;
	private JAXBContext jaxbContext;

	@RequestMapping(value = "/readxml", method = RequestMethod.GET)
	public ResponseEntity<Employee> validate() throws IOException {
		File file = new ClassPathResource("data.xml").getFile();

		try {
			jaxbContext = JAXBContext.newInstance(Employee.class);
			Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
			employee = (Employee) jaxbUnmarshaller.unmarshal(file);

		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return new ResponseEntity<Employee>(employee, HttpStatus.OK);
	}
}