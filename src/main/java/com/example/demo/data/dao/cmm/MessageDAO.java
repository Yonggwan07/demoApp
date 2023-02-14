package com.example.demo.data.dao.cmm;

import com.example.demo.data.entity.cmm.Message;

import java.util.List;

public interface MessageDAO {
    List<Message> findByMessageContentContains(String messageContent);
}
