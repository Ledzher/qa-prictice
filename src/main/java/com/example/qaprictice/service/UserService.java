package com.example.qaprictice.service;

import com.example.qaprictice.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserById(Long id);

    User updateUser(Long id, String newName);

    void deleteUser(Long id);
}
