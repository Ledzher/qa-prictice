package com.example.qaprictice.repository;

import com.example.qaprictice.entity.Answer;
import com.example.qaprictice.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnswerRep extends JpaRepository<Answer, Long> {
    List<Answer> findByQuestion(Question question);
}
