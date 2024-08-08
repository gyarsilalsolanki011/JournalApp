package com.gyarsilalsolanki011.JournalApp.Service;

import com.gyarsilalsolanki011.JournalApp.service.EmailService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class EmailServiceTest {

    @Autowired
    EmailService emailService;

    @Test
    void testSendEmail() {
        emailService.sendEmail("gyarsilalsolanki011@gmail.com",
                "Hello World",
                "How are you?");
    }
}
