package com.example.demo.data.dao.cmm;

import com.example.demo.data.entity.cmm.User;

public interface UserDAO {
    User insertUser(User user);
    User selectUser(String userId);
    User updateUser(User user) throws Exception;
    void deleteUser(String userId) throws Exception;
}
