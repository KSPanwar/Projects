package com.telusko.Teluskoquizapp.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.Teluskoquizapp.Dao.QuestionDao;

import com.telusko.Teluskoquizapp.Model.question;

@Service
public class QuestionService {
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<question>> getallquestion() {
        try{
        return new ResponseEntity<>(questionDao.findAll(),HttpStatus.OK);
        }catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);
    }


    public ResponseEntity<List<question>> getQuestionByCategory(String category){
        try {
            return new ResponseEntity<>(questionDao.findByCategory(category),HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<String> addQuestion(question question) {
        try {
            questionDao.save(question);
            return  new ResponseEntity<>("Success", HttpStatus.CREATED);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return new ResponseEntity<>("Something is wrong",HttpStatus.BAD_REQUEST);
        
    }

    public ResponseEntity<String> deleteQuestion(question question) {
        try {
            questionDao.delete(question);
            return  new ResponseEntity<>("Deleted", HttpStatus.ACCEPTED);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return new ResponseEntity<>("Question not FOUND",HttpStatus.NOT_FOUND);
        
    }

    public ResponseEntity<String> updateQuestion(question question) {
        // TODO Auto-generated method stub
        try {
            questionDao.save(question);
            return  new ResponseEntity<>("Success", HttpStatus.CREATED);
            
        } catch (Exception e) {
           e.printStackTrace();
        }
        return new ResponseEntity<>("Something is wrong",HttpStatus.BAD_REQUEST);
        
    }

}
