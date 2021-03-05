package com.example.project.entityClasses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Card {

	@Id
	@GeneratedValue
	Long id;
	
	String question;
	String answer;
	
	int difficulty;
	
	@ManyToOne
	Topic topic;
	
	@ManyToMany(mappedBy = "card")
	Set<User> user = new HashSet<>();
	

	
}
