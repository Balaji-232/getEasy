package com.cart.entity;

import javax.persistence.*;

@Entity
@Table
public class SignUp {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long Id;
	
	@Column(name="Name", nullable=false, length=100)
	private String Name;
	
	@Column(name="Password", nullable=false, length=50)
	private String Password;
	
	@Column(name="Email", nullable=false,unique=true,length=100)
	private String Email;
	
	@Column(name="Mobile", nullable=false, length=10)
	private String Mobile;

	public long getId() {
		return Id;
	}

	public void setId(long id) {
		Id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getMobile() {
		return Mobile;
	}

	public void setMobile(String mobile) {
		Mobile = mobile;
	}
	
	

}
