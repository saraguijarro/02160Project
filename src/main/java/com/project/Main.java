package com.project;

import com.project.dto.UserEntity;
import com.project.repository.UserRepository;

public class Main {

    public static void main(String[] args) {
        UserRepository repository = new UserRepository();


        UserEntity password = repository.loginUser("exakkjmple@gmail.com", "password");
        System.out.println(password);
    }
}
