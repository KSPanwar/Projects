package com.telusko.Teluskoquizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Teluskoquizapp.Model.question;
import com.telusko.Teluskoquizapp.Service.QuestionService;

@RestController
@RequestMapping("question")
public class QuestionController {
    @Autowired
    QuestionService questionService;
    @GetMapping("allQuestion")   
    public ResponseEntity<List<question>> getallquestion(){
        return questionService.getallquestion();
    }
    @GetMapping("category/{category}")
    public ResponseEntity<List<question>> getQuestionByCategory(@PathVariable String category){
        return questionService.getQuestionByCategory(category);
    }
    @PostMapping("add")
    public ResponseEntity<String> addQuestion(@RequestBody question question){
        return questionService.addQuestion(question);
        
    }
    @DeleteMapping("delete")
    public ResponseEntity<String> deleteQuestion(@RequestBody question question){
        return questionService.deleteQuestion(question);
    }
    @PostMapping("update")
    public ResponseEntity<String> updateQuestion(@RequestBody question question){
       return questionService.updateQuestion(question);
    }
}
