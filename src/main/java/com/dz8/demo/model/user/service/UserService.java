package com.dz8.demo.model.user.service;

import com.dz8.demo.model.user.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    void save(UserSecurity userSecurity);

    void delete(String id);

    User findByEmail(String email);

    List<User> findAll();
    void updateUser(UserSecurity userSecurity, UUID id);

    User findById(UUID id);
}
