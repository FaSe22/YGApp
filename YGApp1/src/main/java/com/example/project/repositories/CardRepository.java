package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entityClasses.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Long>{

}
