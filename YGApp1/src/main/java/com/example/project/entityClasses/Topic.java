package com.example.project.entityClasses;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

import lombok.Data;

@Entity
@Data
public class Topic {

	@Id
	@GeneratedValue
	Long id;
	
	String topicName;
	
	@OneToMany (mappedBy ="topic")
	@JsonBackReference
	List<Card> cardsForTopic;
	
	
}
