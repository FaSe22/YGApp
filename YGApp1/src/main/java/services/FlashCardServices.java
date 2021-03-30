package services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.project.entityClasses.Card;
import com.example.project.entityClasses.Topic;
import com.example.project.enums.CardTypes;
import com.example.project.enums.Difficulty;
import com.example.project.repositories.CardRepository;

public class FlashCardServices {

	@Autowired
	CardRepository cardRepository;

	public List<Card> getFlashCardsForTopic(Topic topic) {
		return cardRepository.findByTopic(topic).stream().filter(kata -> kata.getType().equals(CardTypes.FLASHCARD))
				.collect(Collectors.toList());
	}

	public List<Card> getFlashCardsByDifficulty(Difficulty difficulty) {
		return cardRepository.findByDifficulty(difficulty).stream()
				.filter(kata -> kata.getType().equals(CardTypes.FLASHCARD)).collect(Collectors.toList());

	}

	public List<Card> getFlashCardsForTopicByDifficulty(Topic topic, Difficulty difficulty) {
		return cardRepository.findByDifficulty(difficulty).stream()
				.filter(cardtype -> cardtype.getType().equals(CardTypes.FLASHCARD))
				.filter(card -> card.getTopic().equals(topic)).collect(Collectors.toList());

	}

}
