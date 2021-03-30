package com.example.project.entityClasses;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import com.example.project.enums.SkillLevel;

import lombok.Data;

@Entity
@Data
public class User {

	@Id
	@GeneratedValue
	Long id;

	String firstname;
	String lastname;

	SkillLevel skillLevel;

	// Cards solved by User
<<<<<<< HEAD
	@ManyToMany(cascade = {
		    CascadeType.PERSIST,
		    CascadeType.MERGE
		})
		@JoinTable(name = "user_cards",
		    joinColumns = @JoinColumn (name = "user_id"),
		    inverseJoinColumns = @JoinColumn(name = "card_id")
		)
	 List<Card> cardsSolvedByUser = new ArrayList();
	
	
=======
	@ManyToMany(cascade = { CascadeType.PERSIST, CascadeType.MERGE })
	@JoinTable(name = "user_cards", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "card_id"))
	Set<Card> cardsSolvedByUser = new HashSet<>();

>>>>>>> branch 'sefa' of https://github.com/FaSe22/YGApp.git
}
