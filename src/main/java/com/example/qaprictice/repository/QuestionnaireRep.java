package com.example.qaprictice.repository;

import com.example.qaprictice.entity.Questionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestionnaireRep extends JpaRepository<Questionnaire,Long> {
}
