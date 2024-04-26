package com.telusko.Teluskoquizapp.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.telusko.Teluskoquizapp.Model.questionWrapper;
import com.telusko.Teluskoquizapp.Dao.QuestionDao;
import com.telusko.Teluskoquizapp.Dao.QuizDao;
import com.telusko.Teluskoquizapp.Model.Response;
import com.telusko.Teluskoquizapp.Model.question;
import com.telusko.Teluskoquizapp.Model.quiz;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;
    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<String> CreateQuiz(String category, int noofQues, String title) {
        // TODO Auto-generated method stub
        List<question> questions = questionDao.findRandomQuestionByCategory(category,noofQues);
        quiz quiz = new quiz();
        quiz.setTitle(title);
        quiz.setQuestion(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);

    }

    public ResponseEntity<List<questionWrapper>> getQuiz(Integer id) {
        // TODO Auto-generated method stub
        Optional<quiz> quiz = quizDao.findById(id);
        List<question> questionsFromDB = quiz.get().getQuestion();
        List<questionWrapper> questionforuser = new ArrayList<>();
        for(question q : questionsFromDB){
            questionWrapper qw = new questionWrapper(q.getId(), q.getQuestionTitle(), q.getOption1(), q.getOption2(), q.getOption3(), q.getOption4());
            questionforuser.add(qw);
        }

        return new ResponseEntity<>(questionforuser,HttpStatus.OK);
    }

    public ResponseEntity<Integer> calculateScore(Integer id, List<Response> responses) {
        // TODO Auto-generated method stub
        Optional<quiz> quiz = quizDao.findById(id);
        List<question> questions = quiz.get().getQuestion();
        int i=0,score=0;
        for(Response response : responses ){
            if(response.getResponse().equals(questions.get(i).getRightAnswer())){
                score++;
            }
            i++;
    }
    return new ResponseEntity<>(score,HttpStatus.ACCEPTED);
}
}
