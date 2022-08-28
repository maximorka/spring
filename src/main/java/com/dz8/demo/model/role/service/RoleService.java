package com.dz8.demo.model.role.service;

import com.dz8.demo.model.role.entity.Role;

import java.util.List;
import java.util.UUID;

public interface RoleService {

    void saveRole(Role role);

    void deleteRole(UUID id);

    Role findByName(String name);

    List<Role> findAll();

    void updateRole(Role role, UUID id);

    Role findById(UUID id);
}