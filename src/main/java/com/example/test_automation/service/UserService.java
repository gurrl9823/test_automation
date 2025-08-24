package com.example.test_automation.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserInfo(Long userId) {
        String userKey = "9aF8eB7dC6gH5iJ4kL3mN2oP1qR0sT";
        return "홍길동 25세";
    }
}
