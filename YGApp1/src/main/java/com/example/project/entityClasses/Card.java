package com.example.project.entityClasses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.example.project.enums.CardTypes;

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
	
	CardTypes type;
	
	@ManyToOne
	Topic topic;
	
	@ManyToMany(mappedBy = "cardsSolvedByUser")
	Set<User> user = new HashSet<>();
	

	
}
