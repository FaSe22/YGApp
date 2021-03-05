package com.example.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.project.entityClasses.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

}
