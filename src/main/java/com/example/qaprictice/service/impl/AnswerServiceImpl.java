package com.example.qaprictice.service.impl;

import com.example.qaprictice.entity.Answer;
import com.example.qaprictice.entity.Question;
import com.example.qaprictice.repository.AnswerRep;
import com.example.qaprictice.repository.QuestionRep;
import com.example.qaprictice.service.AnswerService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class AnswerServiceImpl implements AnswerService {
    @Autowired
    private AnswerRep answerRep;
    @Autowired
    private QuestionRep questionRep;



    @Override
    public Answer createAnswer(String text, Long question) {
        Question question1 = questionRep.findById(question).orElseThrow();
        Answer answer = new Answer();
        answer.setText(text);
        answer.setQuestion(question1);
        return answerRep.save(answer);
    }
    @Override
    public List<Answer> getAnswersByQuestion(Question question) {
        return answerRep.findByQuestion(question);
    }
    @Override
    public Answer getAnswerById(Long id) {
        return answerRep.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Answer not found with id: " + id));
    }
}
