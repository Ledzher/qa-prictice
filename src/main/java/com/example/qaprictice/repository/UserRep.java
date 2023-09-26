package com.example.qaprictice.repository;

import com.example.qaprictice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRep extends JpaRepository<User, Long> {
}
