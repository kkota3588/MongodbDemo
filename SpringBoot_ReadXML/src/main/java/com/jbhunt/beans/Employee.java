package com.jbhunt.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@Component
@XmlRootElement(name = "employee")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	public Meta meta;
	public Data data;

	public Employee() {

	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Employee [meta=" + meta + ", data=" + data + "]";
	}

	public Employee(Meta meta, Data data) {
		super();
		this.meta = meta;
		this.data = data;
	}

}
