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
import org.springframework.web.bind.annotation.PutMapping;
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
	
			@GetMapping
			public ResponseEntity<List<Card>> getAllCards() {
				return ResponseEntity.ok (cardRepository.findAll());
			}
			
			
			@GetMapping("/{id}")
			public ResponseEntity<Optional<Card>> getCardById(@PathVariable Long id) {
				return ResponseEntity.ok (cardRepository.findById(id));
			}
			
			
		    @PostMapping
		    public Card createCard(@RequestBody Card card) {
		    	return cardRepository.save(card);
		    }
	
		    
		     @PutMapping
		     public ResponseEntity<Card> updateCard(@RequestBody Card card) {
		    	 if(card.getId() == null) {
		    		 return ResponseEntity.noContent().build();
		    	 }
		    	 return ResponseEntity.ok(cardRepository.save(card));
		     }
		     
		     
		     @DeleteMapping("/{id}")                                  
		     public Boolean deleteCard(@PathVariable Long id) {
			cardRepository.deleteById(id);
				return true;
		     }
		     
		     
		// Special GET-Easteregg
			  @GetMapping("/yougrow")
			  public String home(){
			      return "Hallo Yougrow-Team!";
			  }	

}
