package com.gyarsilalsolanki011.JournalApp.config;

import com.gyarsilalsolanki011.JournalApp.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurity {
    @Autowired
    private UserDetailService userDetailService;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/user/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .httpBasic();

        httpSecurity.csrf().disable();

        return httpSecurity.build();
    }

//    @Bean
//    public AuthenticationProvider authenticationProvider() {
//
//        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
//        provider.setUserDetailsService(userDetailService);
//        provider.setPasswordEncoder(passwordEncoder());
//
//        return provider;
//    }
//
//    protected void Config(AuthenticationManagerBuilder auth) throws Exception {
//        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
//    }

}
