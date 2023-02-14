package com.example.demo.service.tmm;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.data.dao.cmm.MessageDAO;
import com.example.demo.data.entity.cmm.Message;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TMMA0020ServiceImpl implements TMMA0020Service {

    private final MessageDAO dao;

    @Override
    public List<Message> get(String messageContent) {
        return dao.findByMessageContentContains(messageContent);
    }
}
