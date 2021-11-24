package com.spring.hanghaeblog.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.spring.hanghaeblog.dto.SignupRequestDto;
import com.spring.hanghaeblog.service.KakaoUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.Map;

@Controller
public class UserController {

    private final com.spring.hanghaeblog.service.UserService userService;
    private final KakaoUserService kakaoUserService;

    @Autowired
    public UserController(com.spring.hanghaeblog.service.UserService userService, KakaoUserService kakaoUserService) {
        this.userService = userService;
        this.kakaoUserService = kakaoUserService;
    }

    // 회원 로그인 페이지
    @GetMapping("/user/login")
    public String login() {
        return "login";
    }

    // 회원 가입 페이지
    @GetMapping("/user/signup")
    public String signup() {
        return "signup";
    }

    @GetMapping("/user/kakao/callback")
    public String kakaoLogin(@RequestParam String code) throws JsonProcessingException {
        kakaoUserService.kakaoLogin(code);
        return "redirect:/login";
    }

    @PostMapping("/user/signup")
    public String execSignup(@Valid SignupRequestDto signupRequestDto, Errors errors, Model model) {
        if (errors.hasErrors()) {
            // 회원가입 실패시, 입력 데이터를 유지
            model.addAttribute("userDto", signupRequestDto);

            // 유효성 통과 못한 필드와 메시지를 핸들링
            Map<String, String> validatorResult = userService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            return "/signup";
        }

        userService.registerUser(signupRequestDto);
        return "redirect:/user/login";
    }

//    @GetMapping("/user/login")
//    public String displogin() {
//        return "/login";
//    }

}