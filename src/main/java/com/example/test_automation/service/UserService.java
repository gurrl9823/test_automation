package com.example.test_automation.service;

import org.springframework.stereotype.Service;

@Service
public class UserService {

    public String getUserInfo(Long userId) {

        String a = "A";
        String b = "B";
        String c = "C";
        if("aaa".equals(a) && "bbb".equals(b)) {
            c = "ccc";
        }

        String userKey = "123";
        return "홍길동 25세";
    }
}
