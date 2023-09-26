package com.example.qaprictice.service.impl;

import com.example.qaprictice.entity.Questionnaire;
import com.example.qaprictice.enums.TypeAnswer;
import com.example.qaprictice.repository.QuestionnaireRep;
import com.example.qaprictice.service.QuestionnaireService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class QuestionnaireServiceImpl implements QuestionnaireService {
    @Autowired
    private QuestionnaireRep questionnaireRep;
    @Override
    public Questionnaire createQuestionnaire(String title, TypeAnswer type) {
        Questionnaire questionnaire = new Questionnaire();
        questionnaire.setTitle(title);
        questionnaire.setTypeAnswer(type);
        return questionnaireRep.save(questionnaire);
    }
    @Override
    public List<Questionnaire> getAllQuestionnaires() {
        return questionnaireRep.findAll();
    }
    @Override
    public Questionnaire getQuestionnaireById(Long id) {
        return questionnaireRep.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Questionnaire not found with id: " + id));
    }
}
