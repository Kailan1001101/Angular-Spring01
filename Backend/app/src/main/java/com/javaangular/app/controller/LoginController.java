package com.javaangular.app.controller;


import com.javaangular.app.dto.LoginDTO;
import com.javaangular.app.entity.LoginEntity;
import com.javaangular.app.service.LoginService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/")
public class LoginController {

        private final LoginService loginService;


    public LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping("/add")
    public void saveUser(@RequestBody LoginEntity loginEntity){
        loginService.insertUser(loginEntity);
    }

    @PostMapping("/post")
    public ResponseEntity<Map<String, String>> login(@RequestBody LoginDTO request) {
        boolean success = loginService.loginAuth(request.getEmail(), request.getPassword());

        if (success) {
            return ResponseEntity.ok(Map.of("message", "Login successful"));
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("error", "Invalid credentials"));
        }
    }


}
