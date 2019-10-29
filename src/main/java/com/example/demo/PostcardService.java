package com.example.demo;

import java.util.ArrayList;
import com.example.demo.PostcardRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component
public class PostcardService {
	
	@Autowired
	private PostcardRepo repo;
	
	
public String AddNewPostcard(String C, String U, int Card, int R, String Cat) {
	Postcardtable ref=new Postcardtable(C, U, Card, R, Cat);
	repo.save(ref);
	return "New Card Added!";
	}
public String DeletePostcard(int Card) {
	Postcardtable ref=repo.findByCardid(Card);
	if(ref==null)
		return "Postcard Not Found!";
		repo.delete(ref);
		return "Card Deleted!";
	}
public String UpdateRating(int Card, int R) {
	Postcardtable ref=repo.findByCardid(Card);
	if(ref==null)
		return "Postcard Not Found!";
		ref.setRating(R);
		repo.save(ref);
		return "Rating Updated!";
	}
}
