package com.example.qaprictice.controller;

import com.example.qaprictice.entity.Questionnaire;
import com.example.qaprictice.entity.User;
import com.example.qaprictice.entity.UserQuestionnaire;
import com.example.qaprictice.service.impl.QuestionnaireServiceImpl;
import com.example.qaprictice.service.impl.UserQuestionnaireServiceImpl;
import com.example.qaprictice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user-questionnaires")
public class UserQuestionnaireController {
    @Autowired
    private UserQuestionnaireServiceImpl userQuestionnaireServiceImpl;
    @Autowired
    private UserServiceImpl userServiceImpl;
    @Autowired
    private QuestionnaireServiceImpl questionnaireServiceImpl;

    @PostMapping
    public ResponseEntity<UserQuestionnaire> createUserQuestionnaire(@RequestBody User user, @RequestBody Questionnaire questionnaire, @RequestBody UserQuestionnaire userQuestionnaire) {
        User newUser = userServiceImpl.getUserById(user.getId());
        Questionnaire newQuestionnaire = questionnaireServiceImpl.getQuestionnaireById(questionnaire.getId());
        UserQuestionnaire newUserQuestionnaire = userQuestionnaireServiceImpl.createUserQuestionnaire(newUser, newQuestionnaire);
        return new ResponseEntity<>(userQuestionnaire, HttpStatus.CREATED);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<UserQuestionnaire>> getUserQuestionnairesByUser(@PathVariable Long userId) {
        User user = userServiceImpl.getUserById(userId);
        List<UserQuestionnaire> userQuestionnaires = userQuestionnaireServiceImpl.getUserQuestionnairesByUser(user);
        return new ResponseEntity<>(userQuestionnaires, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserQuestionnaire> getUserQuestionnaireById(@PathVariable Long id) {
        UserQuestionnaire userQuestionnaire = userQuestionnaireServiceImpl.getUserQuestionnaireById(id);
        return new ResponseEntity<>(userQuestionnaire, HttpStatus.OK);
    }
}
