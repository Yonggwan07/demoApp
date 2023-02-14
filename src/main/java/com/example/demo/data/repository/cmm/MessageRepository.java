package com.example.demo.data.repository.cmm;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.data.entity.cmm.Message;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByMessageContentContains(String messageContent);
}
