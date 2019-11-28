package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.*;


@Entity
public class Postcardtable {
	@Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
	private String country;
    @Column
	private String username;
    @Column
	private int cardid;
    @Column
	private int rating;
    @Column
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
	
	public Postcardtable(Long id, String country, String username, int cardid, int rating, String category) {
        this.id = id;
		this.country = country;
		this.username = username;
		this.cardid = cardid;
		this.rating = rating;
		this.category = category;
	}
	public Postcardtable() {
	}
	
}
