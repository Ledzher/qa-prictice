package com.example.qaprictice.controller;

import com.example.qaprictice.entity.Question;
import com.example.qaprictice.entity.Questionnaire;
import com.example.qaprictice.service.impl.QuestionServiceImpl;
import com.example.qaprictice.service.impl.QuestionnaireServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/questions")
public class QuestionController {
    @Autowired
    private QuestionServiceImpl questionServiceImpl;
    @Autowired
    private QuestionnaireServiceImpl questionnaireServiceImpl;

    @PostMapping
    public ResponseEntity<?> createQuestion(@RequestBody String text, @RequestBody Questionnaire questionnaire) {
        Question question = questionServiceImpl.createQuestion(text, questionnaire);
        return ResponseEntity.ok(question);
    }

    @GetMapping("/questionnaire/{questionnaireId}")
    public ResponseEntity<List<Question>> getQuestionsByQuestionnaire(@PathVariable Long questionnaireId) {
        Questionnaire questionnaire = questionnaireServiceImpl.getQuestionnaireById(questionnaireId);
        List<Question> questions = questionServiceImpl.getQuestionsByQuestionnaire(questionnaire);
        return new ResponseEntity<>(questions, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> getQuestionById(@PathVariable Long id) {
        Question question = questionServiceImpl.getQuestionById(id);
        return new ResponseEntity<>(question, HttpStatus.OK);
    }
}
