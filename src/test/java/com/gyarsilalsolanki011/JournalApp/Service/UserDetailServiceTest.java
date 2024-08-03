package com.gyarsilalsolanki011.JournalApp.Service;

import com.gyarsilalsolanki011.JournalApp.Entity.User;
import com.gyarsilalsolanki011.JournalApp.repository.UserRepository;
import com.gyarsilalsolanki011.JournalApp.service.UserDetailService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.security.core.userdetails.UserDetails;

import static org.mockito.Mockito.*;

public class UserDetailServiceTest {

    @InjectMocks
    private UserDetailService userDetailService;

    //we can use @MockBean if We use Autowire above and @SpringBootTest with class
    @Mock
    private UserRepository userRepository;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    } //To overCome nullPoint Exception in userRepository

    @Test
    void testLoadByUserName() {
        when(userRepository.findByUserName("ram")).thenReturn(User.builder().userName("ram").password("ram").build());
        UserDetails userDetails = userDetailService.loadUserByUsername("Ram");
        Assertions.assertNotNull(userDetails);
    }
}
