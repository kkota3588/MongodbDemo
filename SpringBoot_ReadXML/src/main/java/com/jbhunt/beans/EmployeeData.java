package com.jbhunt.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

import com.jbhunt.beans.Address;

@XmlRootElement(name = "employeedata")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Component
public class EmployeeData implements Serializable {

	public EmployeeData() {
		super();
	}

	private static final long serialVersionUID = 1L;
	public String company;
	public int id;
	public String name;
	public String department;
	public String salary;
	public Address address;

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public EmployeeData(String company, int id, String name, String department, String salary, Address address) {
		super();
		this.company = company;
		this.id = id;
		this.name = name;
		this.department = department;
		this.salary = salary;
		this.address = address;
	}

	@Override
	public String toString() {
		return "Data [company=" + company + ", id=" + id + ", name=" + name + ", department=" + department + ", salary="
				+ salary + ", address=" + address + "]";
	}

}
