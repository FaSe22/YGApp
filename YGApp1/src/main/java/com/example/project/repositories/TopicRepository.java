package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entityClasses.Topic;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long>{

}
