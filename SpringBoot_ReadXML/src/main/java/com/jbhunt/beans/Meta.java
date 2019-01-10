package com.jbhunt.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name = "meta")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Component
public class Meta implements Serializable {

	private static final long serialVersionUID = 1L;
	public String serviceName;
	public String country;

	public String getServiceName() {
		return serviceName;
	}

	@Override
	public String toString() {
		return "Meta [serviceName=" + serviceName + ", country=" + country + "]";
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Meta(String serviceName, String country) {
		super();
		this.serviceName = serviceName;
		this.country = country;
	}

	public Meta() {
		super();
	}

}
