package com.example.test_automation.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

    @InjectMocks
    private UserService userService;

    @Test
    @DisplayName("getUserInfoService 테스트")
    void getUserInfo_should_always_return_fixed_string() {

        // Given
        Long anyUserId = 123L; // 어떤 userId가 들어가도 결과는 동일해야 합니다.
        String expectedUserInfo = "홍길동 25세";

        // When
        String actualUserInfo = userService.getUserInfo(anyUserId);

        // Then
        assertNotNull(actualUserInfo, "결과는 null이 아니어야 합니다.");
        assertEquals(expectedUserInfo, actualUserInfo, "항상 '홍길동 25세' 문자열을 반환해야 합니다.");
    }

}
