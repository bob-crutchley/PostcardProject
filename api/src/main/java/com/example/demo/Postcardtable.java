package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Postcardtable {
	@Id
	private String country;
	private String username;
	private int cardid;
	private int rating;
	private String category;
	
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public int getCardid() {
		return cardid;
	}
	public void setCardid(int cardid) {
		this.cardid = cardid;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public Postcardtable(String country, String username, int cardid, int rating, String category) {
		this.country = country;
		this.username = username;
		this.cardid = cardid;
		this.rating = rating;
		this.category = category;
	}
	public Postcardtable() {
	}
	
}