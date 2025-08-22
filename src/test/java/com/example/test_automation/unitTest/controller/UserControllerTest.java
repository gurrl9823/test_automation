package com.example.test_automation.controller;

import com.example.test_automation.service.UserService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(UserController.class)
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private UserService userService;

    @Test
    @DisplayName("사용자 정보 조회 성공 시 200 OK를 반환한다")
    void getUserInfo_Success_Returns200Ok() throws Exception {
        // Given
        Long userId = 123456L;
        String userInfo = "홍길동 25세";
        given(userService.getUserInfo(userId)).willReturn(userInfo);

        // When & Then
        mockMvc.perform(get("/user/info/{userId}", userId)) // GET 요청 시뮬레이션
                .andExpect(status().isOk()) // 응답 상태가 200 OK인지 검증
                .andExpect(content().string(userInfo)); // 응답 본문이 예상과 일치하는지 검증
    }

    @Test
    @DisplayName("존재하지 않는 사용자 정보 조회 시 404 Not Found를 반환한다")
    void getUserInfo_NotFound_Returns404NotFound() throws Exception {
        // Given
        Long userId = 999L;
        given(userService.getUserInfo(userId)).willReturn(null);

        // When & Then
        mockMvc.perform(get("/user/info/{userId}", userId))
                .andExpect(status().isNotFound()); // 응답 상태가 404 Not Found인지 검증
    }
}