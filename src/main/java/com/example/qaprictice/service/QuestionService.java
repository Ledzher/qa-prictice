package com.example.qaprictice.service;

import com.example.qaprictice.entity.Question;
import com.example.qaprictice.entity.Questionnaire;

import java.util.List;

public interface QuestionService {
    Question createQuestion(String text, Questionnaire questionnaire);

    List<Question> getQuestionsByQuestionnaire(Questionnaire questionnaire);

    Question getQuestionById(Long id);
}
