package com.example.project.entityClasses;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue
	Long id;
	
	String firstname;
	String lastname;
	
		
	int skillLevel;
	
	
	
	
	// Cards solved by User
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
		@JoinTable(name = "user_cards",
		    joinColumns = @JoinColumn (name = "user_id"),
		    inverseJoinColumns = @JoinColumn(name = "card_id")
		)
	 Set<Card> cardsSolvedByUser = new HashSet<>();
	
	
}
