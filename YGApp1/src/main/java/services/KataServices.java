package services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.project.entityClasses.Card;
import com.example.project.entityClasses.Topic;
import com.example.project.enums.CardTypes;
import com.example.project.enums.Difficulty;
import com.example.project.repositories.CardRepository;

@Service
public class KataServices {

	@Autowired
	CardRepository cardRepository;

	public List<Card> getKatasForTopic(Topic topic) {
		return cardRepository.findByTopic(topic).stream().filter(kata -> kata.getType().equals(CardTypes.KATA))
				.collect(Collectors.toList());
	}

	public List<Card> getKatasByDifficulty(Difficulty difficulty) {
		return cardRepository.findByDifficulty(difficulty).stream()
				.filter(kata -> kata.getType().equals(CardTypes.KATA)).collect(Collectors.toList());

	}
	
	public List<Card> getKatasForTopicByDifficulty(Topic topic, Difficulty difficulty) {
		return cardRepository.findByDifficulty(difficulty).stream()
				.filter(cardtype -> cardtype.getType().equals(CardTypes.KATA))
				.filter(card -> card.getTopic().equals(topic)).collect(Collectors.toList());

	}

}
