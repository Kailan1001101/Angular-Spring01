package com.javaangular.app.controller;


import com.javaangular.app.dto.LoginDTO;
import com.javaangular.app.entity.LoginEntity;
import com.javaangular.app.service.LoginService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


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

    @GetMapping("/get")
    public List<LoginDTO> getUser(@RequestParam String email){
        return loginService.getUser(email);
    }

}
