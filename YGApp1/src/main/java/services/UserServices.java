package services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.project.entityClasses.Card;
import com.example.project.entityClasses.User;
import com.example.project.enums.CardTypes;
import com.example.project.enums.Difficulty;
import com.example.project.enums.SkillLevel;


@Service
public class UserServices {

	

	public List<Card> getListOfSolvedKatas(User user) {
		return user.getCardsSolvedByUser().stream().filter(card -> card.getType().equals(CardTypes.KATA))
				.collect(Collectors.toList());
	}

	public List<Card> getListOfSolvedFlashCards(User user) {
		return user.getCardsSolvedByUser().stream().filter(card -> card.getType().equals(CardTypes.FLASHCARD))
				.collect(Collectors.toList());
	}
	
	public List<Card> getListofSolvedEasyCards(User user){
		 return  user.getCardsSolvedByUser().stream()
				.filter(card ->card.getDifficulty().equals(Difficulty.EASY)).collect(Collectors.toList());
		
	}
	
	public List<Card> getListofSolvedMediumCards(User user){
		 return  user.getCardsSolvedByUser().stream()
				.filter(card ->card.getDifficulty().equals(Difficulty.MEDIUM)).collect(Collectors.toList());
		
	}
	
	public List<Card> getListofSolvedHighCards(User user){
		 return  user.getCardsSolvedByUser().stream()
				.filter(card ->card.getDifficulty().equals(Difficulty.MEDIUM)).collect(Collectors.toList());
		
	}

	public void calculateSkillLevel(User user) {
		Long solvedMediumCards =  user.getCardsSolvedByUser().stream().filter(card ->card.getDifficulty().equals(Difficulty.MEDIUM)).count();
		Long solvedEasyCards =  user.getCardsSolvedByUser().stream().filter(card ->card.getDifficulty().equals(Difficulty.EASY)).count();
		Long solvedHighCards =  user.getCardsSolvedByUser().stream().filter(card ->card.getDifficulty().equals(Difficulty.HIGH)).count();
		
		if (getListofSolvedEasyCards(user).stream().count()<10) user.setSkillLevel(SkillLevel.BEGINNER);
		if (solvedHighCards> 50) user.setSkillLevel(SkillLevel.EXPERT);
		if (solvedHighCards>20) user.setSkillLevel(SkillLevel.HIGH);
		if (solvedMediumCards>10) user.setSkillLevel(SkillLevel.ADVANCED);
		if(solvedEasyCards>50 && solvedMediumCards >5) user.setSkillLevel(SkillLevel.ADVANCED);
		if(solvedMediumCards>50 && solvedHighCards >5) user.setSkillLevel(SkillLevel.HIGH);
		
	}

}
