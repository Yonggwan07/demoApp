package com.example.demo.data.dao.cmm.impl;

import java.util.Optional;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.UserDAO;
import com.example.demo.data.entity.cmm.User;
import com.example.demo.data.repository.cmm.UserRepository;

@Component
public class UserDAOImpl implements UserDAO {
    private final UserRepository userRepository;

    public UserDAOImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User insertUser(User user) {
        User saved = userRepository.save(user);
        return saved;
    }

    @Override
    public User selectUser(String userId) {
        Optional<User> selected = userRepository.findById(userId);
        return selected.isPresent() ? selected.get() : null;
    }

    @Override
    public User updateUser(User user) throws Exception {
        Optional<User> selected = userRepository.findById(user.getUserId());
        User updated;
        if (selected.isPresent()) {
            updated = userRepository.save(user);
        } else {
            throw new Exception();
        }
        return updated;
    }

    @Override
    public void deleteUser(String userId) throws Exception {
        Optional<User> selected = userRepository.findById(userId);
        if (selected.isPresent()) {
            userRepository.delete(selected.get());
        } else {
            throw new Exception();
        }
    }
}
