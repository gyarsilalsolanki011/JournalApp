package com.gyarsilalsolanki011.JournalApp.scheduler;

import com.gyarsilalsolanki011.JournalApp.schedulers.UserScheduler;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class UserSchedulerTest {

    @Autowired
    private UserScheduler userScheduler;

    @Test
    void testFetchUserAndSendMail() {
        userScheduler.fetchUsersAndSendMail();
    }
}
