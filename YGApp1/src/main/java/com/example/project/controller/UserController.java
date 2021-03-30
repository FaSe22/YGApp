package com.example.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.example.project.entityClasses.Card;
import com.example.project.entityClasses.User;
import com.example.project.repositories.UserRepository;

@Controller
public class UserController {

	

	// TODO Bitte Prüfen ob    @Delete / @Put und @GetAll    hier nötig sind!!!


	
	
			@Autowired
			UserRepository userRepository;
			
						@GetMapping
						public ResponseEntity<List<User>> getAllUser() {
							return ResponseEntity.ok (userRepository.findAll());
						}
			
						
			@GetMapping("/{id}")
			public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
				return ResponseEntity.ok (userRepository.findById(id));
			}
			
			
		    @PostMapping
		    public User createUser(@RequestBody User user) {
		    	return userRepository.save(user);
		    }
		
		    
					     @PutMapping
					     public ResponseEntity<User> updateUser(@RequestBody User user) {
					    	 if(user.getId() == null) {
					    		 return ResponseEntity.noContent().build();
					    	 }
					    	 return ResponseEntity.ok(userRepository.save(user));
					     }
		     
					     
					     @DeleteMapping("/{id}")                                  
					     public Boolean deleteUser(@PathVariable Long id) {  //---Wird evtl geändert
						userRepository.deleteById(id);
							return true;
					     }
	
					     
}
