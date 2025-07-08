package com.javaangular.app.repo;

import com.javaangular.app.entity.LoginEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface LoginRepository extends JpaRepository<LoginEntity,Long> {
    Optional<LoginEntity> findByEmail(String email);
}
