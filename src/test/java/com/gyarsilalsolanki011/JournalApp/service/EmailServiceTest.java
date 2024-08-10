package com.gyarsilalsolanki011.JournalApp.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    void testSendEmail() {
        emailService.sendEmail("jogilalsolanki01@gmail.com",
                "Hello World",
                "How are you?");
    }
}
