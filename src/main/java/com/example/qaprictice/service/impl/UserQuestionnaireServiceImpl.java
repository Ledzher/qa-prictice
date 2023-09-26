package com.example.qaprictice.service.impl;

import com.example.qaprictice.entity.Questionnaire;
import com.example.qaprictice.entity.User;
import com.example.qaprictice.entity.UserQuestionnaire;
import com.example.qaprictice.repository.UserQuestionnaireRep;
import com.example.qaprictice.service.UserQuestionnaireService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQuestionnaireServiceImpl implements UserQuestionnaireService {
    @Autowired
    private UserQuestionnaireRep userQuestionnaireRep;
    @Override
    public UserQuestionnaire createUserQuestionnaire(User user, Questionnaire questionnaire) {
        UserQuestionnaire userQuestionnaire = new UserQuestionnaire();
        userQuestionnaire.setUser(user);
        userQuestionnaire.setQuestionnaire(questionnaire);
        return userQuestionnaireRep.save(userQuestionnaire);
    }
    @Override
    public List<UserQuestionnaire> getUserQuestionnairesByUser(User user) {
        return userQuestionnaireRep.findByUser(user);
    }
    @Override
    public UserQuestionnaire getUserQuestionnaireById(Long id) {
        return userQuestionnaireRep.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("UserQuestionnaire not found with id: " + id));
    }


}
