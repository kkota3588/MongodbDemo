package com.jbhunt.beans;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Component;

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.PROPERTY)
@Component
public class Address implements Serializable {

	private static final long serialVersionUID = 1L;
	public String doorNo;
	public String street;
	public String village;
	public String mandal;
	public String dist;
	public String state;
	public int pincode;

	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getVillage() {
		return village;
	}

	public void setVillage(String village) {
		this.village = village;
	}

	public String getMandal() {
		return mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDist() {
		return dist;
	}

	public void setDist(String dist) {
		this.dist = dist;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPincode() {
		return pincode;
	}

	public void setPincode(int pincode) {
		this.pincode = pincode;
	}

	@Override
	public String toString() {
		return "Address [doorNo=" + doorNo + ", street=" + street + ", village=" + village + ", mandal=" + mandal
				+ ", dist=" + dist + ", state=" + state + ", pincode=" + pincode + "]";
	}

	public Address(String doorNo, String street, String village, String mandal, String dist, String state,
			int pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.village = village;
		this.mandal = mandal;
		this.dist = dist;
		this.state = state;
		this.pincode = pincode;
	}

	public Address() {
		super();

	}

}
