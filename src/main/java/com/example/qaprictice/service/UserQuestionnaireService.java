package com.example.qaprictice.service;

import com.example.qaprictice.entity.Questionnaire;
import com.example.qaprictice.entity.User;
import com.example.qaprictice.entity.UserQuestionnaire;

import java.util.List;

public interface UserQuestionnaireService {
    UserQuestionnaire createUserQuestionnaire(User user, Questionnaire questionnaire);

    List<UserQuestionnaire> getUserQuestionnairesByUser(User user);

    UserQuestionnaire getUserQuestionnaireById(Long id);
}
