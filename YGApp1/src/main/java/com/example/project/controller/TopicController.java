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
import com.example.project.entityClasses.Topic;
import com.example.project.repositories.TopicRepository;

@Controller
public class TopicController {
	
	
	

	// TODO Bitte Prüfen ob    @Delete / @Put / @Post    hier nötig sind!!!
	


	
	
			@Autowired
			TopicRepository topicRepository;
			
			@GetMapping
			public ResponseEntity<List<Topic>> getAllTopics() {
				return ResponseEntity.ok (topicRepository.findAll());
			}
			
			
			@GetMapping("/{id}")
			public ResponseEntity<Optional<Topic>> getTopicById(@PathVariable Long id) {
				return ResponseEntity.ok (topicRepository.findById(id));
			}
			
			
						    @PostMapping
						    public Topic createTopic(@RequestBody Topic topic) {
						    	return topicRepository.save(topic);
						    }
		
						    
						     @PutMapping
						     public ResponseEntity<Topic> updateTopic(@RequestBody Topic topic) {
						    	 if(topic.getId() == null) {
						    		 return ResponseEntity.noContent().build();
						    	 }
						    	 return ResponseEntity.ok(topicRepository.save(topic));
						     }
		     
						     
						     @DeleteMapping("/{id}")                                  
						     public Boolean deleteTopic(@PathVariable Long id) { 
							 topicRepository.deleteById(id);
								return true;
						     }

}
