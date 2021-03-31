package com.example.project.entityClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.project.enums.CardTypes;
<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonManagedReference;
=======
import com.example.project.enums.Difficulty;
>>>>>>> branch 'sefa' of https://github.com/FaSe22/YGApp.git

import lombok.Data;

@Entity
@Data
public class Card {

	@Id
	@GeneratedValue
	Long id;
	
	String question;
	String answer;
	
	Difficulty difficulty;
	
	CardTypes type;
	
	@ManyToOne
	
	Topic topic;
	
//	@ManyToMany(mappedBy = "cardsSolvedByUser")
//	@JsonManagedReference
//	Set<User> user = new HashSet();
	
	@ManyToMany(mappedBy = "cardsSolvedByUser")
	
	List<User> user = new ArrayList();
	

	
}
