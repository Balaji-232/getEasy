package com.cart.entity;

import javax.persistence.*;

@Entity
@Table
public class CartDto {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long CId;
	
	@Column
	private int PId;
	
	@Column
	private int SId;
	
	@Column
	private String seller;

	@Column(name="Product_Image", nullable=false, length=255)
	private String PImage;
	
	@Column(name="Product_Name", nullable=false, length=155)
	private String PName;
	
	@Column(name="Product_Price", nullable=false)
	private int PPrice;
	
	@Column(name="Product_Quantity")
	private int PQuantity;

	public int getPQuantity() {
		return PQuantity;
	}

	public void setPQuantity(int pQuantity) {
		PQuantity = pQuantity;
	}

	public long getCId() {
		return CId;
	}

	public void setCId(long cId) {
		CId = cId;
	}

	public int getPId() {
		return PId;
	}

	public void setPId(int pId) {
		PId = pId;
	}

	public String getPImage() {
		return PImage;
	}

	public void setPImage(String pImage) {
		PImage = pImage;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public int getPPrice() {
		return PPrice;
	}

	public void setPPrice(int pPrice) {
		PPrice = pPrice;
	}
	
	public int getSId() {
		return SId;
	}

	public void setSId(int sId) {
		SId = sId;
	}

	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}
	
}
