package com.example.demo;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController("/api")
public class DBFController {
	@Autowired
	private PostcardRepo repo;
	@GetMapping("/ShowAll")
	public ArrayList<Postcardtable>ShowAll(){
		return repo.findAll();
	}
	@GetMapping("/ShowCardid/{C}")
	public Postcardtable ShowCardid(@PathVariable int C) {
		return repo.findByCardid(C);
	}
	@GetMapping("/FindByUser/{U}")
	public ArrayList<Postcardtable>FindByUser(@PathVariable String U){
		return repo.findByUsername(U);
	}
	@GetMapping("/FindByCategory/{C}")
	public ArrayList<Postcardtable>FindByCategory(@PathVariable String C){
		return repo.findByCategory(C);
	}	
	@GetMapping("/FindByCountry/{Country}")
	public ArrayList<Postcardtable>FindByCountry(@PathVariable String Country){
		return repo.findByCountry(Country);
	}	
	@GetMapping("/FilterCategoryAndCountry/{category}/{country}")
	public ArrayList<Postcardtable> FilterCategoryAndCountry(@PathVariable String category, @PathVariable String country){
		return repo.findByCategoryAndCountry(category, country);
	}
	@GetMapping("/FindByCardidOrRating/{C}/{R}")
	public ArrayList<Postcardtable> FindByCardidOrRating(@PathVariable int C, @PathVariable int R){
		return repo.findByCardidOrRating(C, R);
	}
	@GetMapping("/FindByRatingGreaterThan/{R}")
	public ArrayList<Postcardtable> FindByRatingGreaterThan(@PathVariable int R){
		return repo.findByRatingGreaterThan(R);
	}
	@GetMapping("/FindByRatingBetween/{R1}/{R2}")
	public ArrayList<Postcardtable> FindByRatingBetween(@PathVariable int R1, @PathVariable int R2){
		return repo.findByRatingBetween(R1, R2);
	}
	@GetMapping("/FindByRatingGreaterThanEqual/{M}")
	public ArrayList<Postcardtable> FindByRatingGreaterThanEqual(@PathVariable int R){
		return repo.findByRatingGreaterThanEqual(R);
	}
	@Autowired
	private PostcardService cards;
	@RequestMapping(method=RequestMethod.POST, value="/AddNewPostcard/")
	public String AddNewPostcard(@RequestBody Postcardtable pc) {
		return cards.AddNewPostcard(pc);
	}
	@RequestMapping(method=RequestMethod.DELETE, value="/DeletePostcard/{Card}")
	public String DeletePostcard(@PathVariable int Card) {
		return cards.DeletePostcard(Card);
	}
	@RequestMapping(method=RequestMethod.PUT, value="/UpdateRating/{Card}/{R}")
	public String UpdateRating(@PathVariable int Card, @PathVariable int R) {
		return cards.UpdateRating(Card, R);
	}
}  

