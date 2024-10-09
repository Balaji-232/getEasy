package com.cart.entity;

import javax.persistence.*;

@Entity
@Table
public class Review{
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	
	@Column
	private long Rid;
	
	public long getRid() {
		return Rid;
	}

	public void setRid(long rid) {
		Rid = rid;
	}

	@Column
	private int rating;
	
	@Column
	private String review;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
	
	
}