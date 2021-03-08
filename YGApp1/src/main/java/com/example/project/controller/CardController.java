package com.example.project.controller;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.entityClasses.Card;
import com.example.project.repositories.CardRepository;

@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	CardRepository cardRepository;
	
//	@GetMapping
//	public ResponseEntity<Set<Card>> getAllCards() {
//		return ResponseEntity.ok ((Set<Card>)cardRepository.findAll());
//	}
	
			@GetMapping
			public ResponseEntity<List<Card>> getAllCards() {
				return ResponseEntity.ok (cardRepository.findAll());
			}
			
			@GetMapping("/{id}")
			public ResponseEntity<Optional<Card>> getAllCards(@PathVariable Long id) {
				return ResponseEntity.ok (cardRepository.findById(id));
			}
		     
		     @GetMapping("/helloworld")
		     public String home(){
		         return "Hello World!(in CardController)";
		     }
			
			
	@PostMapping
	public Card createCard(@RequestBody Card card) {
		return cardRepository.save(card);
	}
			
//			@PostMapping("/{question},{answer}")
//			public int createCard(@PathVariable int question, @PathVariable int answer) {
//				Card card = new Card();
//				card.setQuestion(question);
//				card.setAnswer(answer);				
//				return cardRepository.save(card);
//				return question + answer;
//			}
	
	@DeleteMapping("/{id}")                                  
		public Boolean deleteCard(@PathVariable Long id) {  //---Wird evtl geändert
			cardRepository.deleteById(id);
			return true;
	
	}
	
	
	
	

}
