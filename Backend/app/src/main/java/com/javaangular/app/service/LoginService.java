package com.javaangular.app.service;

import com.javaangular.app.dto.LoginDTO;
import com.javaangular.app.entity.LoginEntity;
import com.javaangular.app.repo.LoginRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class LoginService  {

    private final LoginRepository loginRepo;

    public LoginService(LoginRepository loginRepo) {
        this.loginRepo = loginRepo;
    }

    public void insertUser(LoginEntity login){
        loginRepo.save(login);
    }

    public Boolean loginAuth(String email, String password) {
        return loginRepo.findByEmail(email)
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }


}
