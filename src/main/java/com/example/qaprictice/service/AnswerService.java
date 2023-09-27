package com.example.qaprictice.service;

import com.example.qaprictice.entity.Answer;
import com.example.qaprictice.entity.Question;

import java.util.List;

public interface AnswerService {


    Answer createAnswer(String text, Long question);

    List<Answer> getAnswersByQuestion(Question question);

    Answer getAnswerById(Long id);
}
