package com.example.qaprictice.repository;

import com.example.qaprictice.entity.Question;
import com.example.qaprictice.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuestionRep extends JpaRepository<Question, Long> {
    List<Question> findByQuestionnaire(Questionnaire questionnaire);
}
