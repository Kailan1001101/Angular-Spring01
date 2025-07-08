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

    public List<LoginDTO> getUser(String email){
        Optional<LoginEntity> loginEntity = loginRepo.findByEmail(email);
        return loginEntity.map(entity -> {
            LoginDTO dto = new LoginDTO();
            dto.setEmail(entity.getEmail());
            dto.setName(entity.getName());
            dto.setSurname(entity.getSurname());
            // No password set for security reasons
            return Collections.singletonList(dto); // Return a list with one item
        }).orElse(Collections.emptyList());
    }


}
