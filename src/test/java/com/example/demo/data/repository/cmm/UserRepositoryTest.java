package com.example.demo.data.repository.cmm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.data.entity.cmm.QUser;
import com.example.demo.data.entity.cmm.User;
import com.querydsl.jpa.impl.JPAQueryFactory;

@SpringBootTest
public class UserRepositoryTest {
    @Autowired
    JPAQueryFactory jpaQueryFactory;

    @Test
    void userTest() {
        QUser qUser = QUser.user;

        User selected = jpaQueryFactory.selectFrom(qUser).where(qUser.userId.eq("demo")).fetchOne();

            System.out.println("----- Select User Table -----");
            System.out.println("getUserId : " + selected.getUserId());
            System.out.println("getUserName : " + selected.getUserName());
            System.out.println("getUserNumber : " + selected.getUserNumber());
            System.out.println("getUserPassword : " + selected.getPassword());
            System.out.println("----- End -----");
    }
}
