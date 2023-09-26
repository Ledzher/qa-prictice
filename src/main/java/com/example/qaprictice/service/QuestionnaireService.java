package com.example.qaprictice.service;

import com.example.qaprictice.entity.Questionnaire;
import com.example.qaprictice.enums.TypeAnswer;

import java.util.List;

public interface QuestionnaireService {
    Questionnaire createQuestionnaire(String title, TypeAnswer type);

    List<Questionnaire> getAllQuestionnaires();

    Questionnaire getQuestionnaireById(Long id);
}
