package com.gyarsilalsolanki011.JournalApp.repository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserRepositoryImplTest {

    @Autowired
    UserRepositoryImpl userRepository;

    @Test
    public void testGetUsersForSA() {
        Assertions.assertNotNull(userRepository.getUsersForSA());
    }

}
