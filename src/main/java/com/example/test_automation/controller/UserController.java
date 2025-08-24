package com.example.test_automation.controller;

import com.example.test_automation.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;ㅇ

    @GetMapping("/user/info/{userId}") // GET 요청을 처리하며, {userId}는 동적인 경로 변수
    public ResponseEntity<String> getUserInfo(@PathVariable Long userId) {
        // 서비스 계층의 메서드를 호출하여 비즈니스 로직을 위임
        String userInfo = userService.getUserInfo(userId);

        if (userInfo != null) {
            // 사용자 정보가 존재하면 200 OK와 함께 데이터를 반환
            return ResponseEntity.ok(userInfo);
        } else {
            // 사용자 정보가 없으면 404 Not Found를 반환
            return ResponseEntity.notFound().build();
        }
    }

}
