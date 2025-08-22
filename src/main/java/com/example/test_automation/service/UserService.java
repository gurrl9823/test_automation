package com.example.test_automation.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserInfo(Long userId) {
        return "홍길동 25세";
    }
}
