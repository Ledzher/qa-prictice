package com.example.qaprictice.repository;

import com.example.qaprictice.entity.User;
import com.example.qaprictice.entity.UserQuestionnaire;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserQuestionnaireRep extends JpaRepository<UserQuestionnaire, Long> {
    List<UserQuestionnaire> findByUser(User user);
}
