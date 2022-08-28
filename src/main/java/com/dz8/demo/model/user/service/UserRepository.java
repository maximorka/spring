package com.dz8.demo.model.user.service;

import com.dz8.demo.model.user.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
@Repository
@EnableJpaRepositories
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByEmail(String email);

}


