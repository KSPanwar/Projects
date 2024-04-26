package com.telusko.Teluskoquizapp.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.telusko.Teluskoquizapp.Model.quiz;

@Repository
public interface QuizDao extends JpaRepository<quiz,Integer> {

}
