package com.cart.entity;

import javax.persistence.*;

@Entity
@Table
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int Id;
	
	@Column
	private int sId;

	public int getsId() {
		return sId;
	}

	public void setsId(int sId) {
		this.sId = sId;
	}

	@Column(name="BName", length=100)
	private String buildingName;
	
	@Column(name="Area", length=100)
	private String area;
	
	@Column(name="Street", length=100)
	private String street;
	
	@Column(name="City", length=100)
	private String city;
	
	@Column(name="State", nullable=false)
	private String state;
	
	@Column(name="Country", nullable=false)
	private String country;
	
	@Column(name="PinCode", nullable=false)
	private String pinCode;

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public String getBuildingName() {
		return buildingName;
	}

	public void setBuildingName(String buildingName) {
		this.buildingName = buildingName;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPinCode() {
		return pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
}
