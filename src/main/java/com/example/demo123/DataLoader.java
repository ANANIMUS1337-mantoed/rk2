package com.example.demo123;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;

@Component
public class DataLoader implements CommandLineRunner {

    private final UserService userService;
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public DataLoader(UserService userService, JdbcTemplate jdbcTemplate) {
        this.userService = userService;
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void run(String... args) {
        jdbcTemplate.execute("TRUNCATE TABLE users RESTART IDENTITY");

        List<String> userNames = Arrays.asList(
                "Asan", "Amer", "Tema", "Rus",
                "Alish", "Ilyar", "Mukha", "Alikh",
                "Mar", "Akma", "Alina", "Beka"
        );
        userService.saveUsers(userNames);
    }
}