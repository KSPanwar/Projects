package com.telusko.Teluskoquizapp.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.telusko.Teluskoquizapp.Model.question;
@Repository
public interface QuestionDao extends JpaRepository<question,Integer> {
 List<question> findByCategory(String category);
@Query( value = "SELECT * FROM question q WHERE q.Category =:category ORDER BY RANDOM() LIMIT :noofQues", nativeQuery = true)
List<question> findRandomQuestionByCategory(String category, int noofQues);
 
}
