package com.jbhunt.beans;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name = "data")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Component
public class Data implements Serializable {

	private static final long serialVersionUID = 1L;
	List<EmployeeData> employeedata;

	public List<EmployeeData> getEmployeedata() {
		return employeedata;
	}

	public void setEmployeedata(List<EmployeeData> employeedata) {
		this.employeedata = employeedata;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "Data [employeedata=" + employeedata + "]";
	}

	public Data(List<EmployeeData> employeedata) {
		super();
		this.employeedata = employeedata;
	}

	public Data() {
		super();

	}

}
