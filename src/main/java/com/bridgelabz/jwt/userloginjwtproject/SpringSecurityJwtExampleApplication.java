package com.bridgelabz.jwt.userloginjwtproject;

import com.bridgelabz.jwt.userloginjwtproject.repository.UserRepository;
import com.bridgelabz.jwt.userloginjwtproject.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@SpringBootApplication
public class SpringSecurityJwtExampleApplication {
    @Autowired
    private UserRepository repository;

    @PostConstruct
    public void initUsers() {
        List<User> users = Stream.of(
                new User(101, "Mayur", "password@123", "pawarmayur12272@gmail.com"),
                new User(102, "Amol", "pwd1", "user1@gmail.com"),
                new User(103, "Sushant", "pwd2", "user2@gmail.com"),
                new User(104, "Nikhil", "pwd3", "user3@gmail.com")
        ).collect(Collectors.toList());
        repository.saveAll(users);
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityJwtExampleApplication.class, args);
    }

}
