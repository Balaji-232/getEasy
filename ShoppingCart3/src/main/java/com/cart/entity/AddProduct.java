package com.cart.entity;

import javax.persistence.*;

@Entity
@Table
public class AddProduct {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long PId;
	
	@Column(name="Product_Name", nullable=false)
	private String PName;
	
	@Column(name="Product_Image", nullable=false)
	private String PImage;
	
	@Column(name="Product_Price", nullable=false)
	private int PPrice;
	
	@Column(name="Product_Quantity", nullable=false)
	private int PQuantity;
	
	@Column(name="Rating")
	private float pRating;
	
	public float getpRating() {
		return pRating;
	}

	public void setpRating(float pRating) {
		this.pRating = pRating;
	}

	@Column(name="Seller", nullable=false)
	private String seller;
	
	@Column(name="sellerEmail", nullable=false)
	private String sellerEmail;
	
	public String getSeller() {
		return seller;
	}

	public void setSeller(String seller) {
		this.seller = seller;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public int getPQuantity() {
		return PQuantity;
	}

	public void setPQuantity(int pQuantity) {
		PQuantity = pQuantity;
	}

	public long getPId() {
		return PId;
	}

	public void setPId(long pId) {
		PId = pId;
	}

	public String getPName() {
		return PName;
	}

	public void setPName(String pName) {
		PName = pName;
	}

	public String getPImage() {
		return PImage;
	}

	public void setPImage(String pImage) {
		PImage = pImage;
	}

	public int getPPrice() {
		return PPrice;
	}

	public void setPPrice(int pPrice) {
		PPrice = pPrice;
	}
	
}
