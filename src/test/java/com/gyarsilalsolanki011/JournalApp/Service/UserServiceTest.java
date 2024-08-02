package com.gyarsilalsolanki011.JournalApp.Service;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import com.gyarsilalsolanki011.JournalApp.UserArgumentProvider;
import com.gyarsilalsolanki011.JournalApp.service.UserService;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    @Disabled
    public void testAdd() {
        assertEquals(4, 2+2);
    }


    //CsvSource Tested
    @ParameterizedTest
    @CsvSource({
            "1,2,2",
            "2,2,4",
            "4,4,8"
    })
    public void testMultiply(int a, int b, int expected) {
        assertEquals(expected, a*b);
    }


    //ValueSource Tested
    @ParameterizedTest
    @ValueSource(strings = {
            "Ram",
            "Shyam",
            "Gsl",
            "Vipul"
    })
    public void testFindByUserName(String name) {
        assertNotNull(userService.findByUserName(name));
    }



    //ArgumentSource Tested
    @ParameterizedTest
    @ArgumentsSource(UserArgumentProvider.class)
    public void testSaveNewUser(User user) {
        assertTrue(userService.saveNewUser(user));
    }
}
