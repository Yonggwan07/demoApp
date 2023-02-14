package com.example.demo.data.dao.cmm.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.example.demo.data.dao.cmm.MessageDAO;
import com.example.demo.data.entity.cmm.Message;
import com.example.demo.data.repository.cmm.MessageRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Component
public class MessageDAOImpl implements MessageDAO {

    private final MessageRepository repo;
    
    @Override
    public List<Message> findByMessageContentContains(String messageContent) {
        return repo.findByMessageContentContains(messageContent);
    }
}
