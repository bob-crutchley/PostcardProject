package com.example.demo;

import java.util.ArrayList;
import com.example.demo.Postcardtable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostcardRepo extends JpaRepository<Postcardtable, Integer> {
	public ArrayList<Postcardtable>findAll();
	public Postcardtable findByCardid(int x);
	public ArrayList<Postcardtable>findByUsername(String Username);
	public ArrayList<Postcardtable>findByCategory(String Category);
	public ArrayList<Postcardtable>findByCountry(String Country);
	public ArrayList<Postcardtable>findByCategoryAndCountry(String Category, String Country);
	public ArrayList<Postcardtable>findByCardidOrRating(int Cardid, int Rating);
	public ArrayList<Postcardtable>findByRatingGreaterThan(int R);
	public ArrayList<Postcardtable>findByRatingBetween(int m1, int m2);
	public ArrayList<Postcardtable>findByRatingGreaterThanEqual(int m);
}
//things that are 'built in' or 'named queries' go in here - if you need to build it
//yourself then it goes in PostcardService