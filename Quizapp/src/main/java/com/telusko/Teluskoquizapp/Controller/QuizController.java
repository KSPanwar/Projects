package com.telusko.Teluskoquizapp.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.telusko.Teluskoquizapp.Model.Response;
import com.telusko.Teluskoquizapp.Model.questionWrapper;
import com.telusko.Teluskoquizapp.Service.QuizService;

@RestController
@RequestMapping("quiz")

public class QuizController {
    @Autowired
    QuizService quizService;
    @PostMapping("create")
    public ResponseEntity<String> CreateQuiz(@RequestParam String category, @RequestParam int noofQues, @RequestParam String title ){
        return quizService.CreateQuiz(category,noofQues,title);
    }
    @GetMapping("getQuiz/{id}")
    public ResponseEntity<List<questionWrapper>> getQuiz(@PathVariable Integer id){
        return quizService.getQuiz(id);
    }

    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> calculateScore(@PathVariable Integer id,@RequestBody List<Response> responses){
        return quizService.calculateScore(id,responses);
    }

}
