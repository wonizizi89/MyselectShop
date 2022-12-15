package com.sparta.myselectshop.controller;

import com.sparta.myselectshop.dto.LoginRequestDto;
import com.sparta.myselectshop.dto.SignupRequestDto;
import com.sparta.myselectshop.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;

@Controller
@RequiredArgsConstructor //서비스랑 연결해야 함으로
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService; // 의존성주입 (DI)


    @GetMapping("/signup")
    public ModelAndView signupPage() {
        return new ModelAndView("signup");// signup페이지로 반환
    }

    @GetMapping("/login")
    public ModelAndView loginPage() {
        return new ModelAndView("login");
    }

    @PostMapping("/signup")
    public String signup(SignupRequestDto signupRequestDto) {
        userService.signup(signupRequestDto);
        return "redirect:/api/user/login";
    }

//    @PostMapping("/login")
//    public String login(LoginRequestDto loginRequestDto) {
//        userService.login(loginRequestDto);
//        return "redirect:/api/shop";
//    }
    //여기 위에서는 Form태그로 넘어왔기 때문에 저게 모델어트리뮤트 형식으로 받아와져서 리퀘스트 바디를 넣어주지 않았는데
    @ResponseBody
    @PostMapping("/login")
    public String login(@RequestBody LoginRequestDto loginRequestDto, HttpServletResponse response) {
        userService.login(loginRequestDto, response);
        return "success";

        //이제는 ajax에서 body에 값이 넘어오기 때문에 이렇게 @RequestBody를 써주셔야 함

        //HttpServletResponse 는 우리가 HttpRequest에서 헤더가 넘어와 받아오는 것처럼
        //우리도 클라이언트쪾으로 반환 할 때는  이렇게 Response객체를 반환함
        //그래서 이것도 미리 가지고 와서 반환할 response Header에다가 우리가 만들어준 토큰을 넣이주기 위해서
        //이렇게 받아오고 있음
    }
}