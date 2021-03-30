package com.example.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entityClasses.Card;
import com.example.project.entityClasses.Topic;
import com.example.project.enums.CardTypes;
import com.example.project.enums.Difficulty;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{
public List<Card> findByTopic(Topic topic);
public List<Card> findByType (CardTypes type);
public List<Card> findByDifficulty(Difficulty difficulty);
}
