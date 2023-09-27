package com.example.qaprictice.service.impl;

import com.example.qaprictice.entity.User;
import com.example.qaprictice.repository.UserRep;
import com.example.qaprictice.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRep userRep;

    public User createUser(String name){
    User user = new User();
    user.setName(name);
     return userRep.save(user);
    }

    public List<User> getAllUser(){
        return userRep.findAll();
    }

    @Override
    public List<User> getAllUsers() {
        return userRep.findAll();
    }
    @Override
    public User getUserById(Long id) {
        return userRep.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));
    }
    @Override
    public User updateUser(Long id, String newName) {
        User user = userRep.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        user.setName(newName);
        return userRep.save(user);
    }
    @Override
    public void deleteUser(Long id) {
        userRep.deleteById(id);
    }

}
