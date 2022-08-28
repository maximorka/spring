package com.dz8.demo.model.role.service;


import com.dz8.demo.model.product.service.ProductRepository;
import com.dz8.demo.model.role.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class RoleServiceImpl implements RoleService {
    private  RoleRepository repository;
    @Autowired
    @Lazy
    public void setProductRepository(RoleRepository repository) {
        this.repository = repository;
    }
    @Override
    public void saveRole(Role role) {
        repository.save(role);
    }

    @Override
    public void deleteRole(UUID id) {
        Role role = repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Role not found"));
        repository.delete(role);
    }

    @Override
    public Role findByName(String name) {
        Role role = repository.findByName(name).orElseThrow(() -> new UsernameNotFoundException("Role not found"));
        return role;
    }

    @Override
    public List<Role> findAll() {
        List<Role> list = repository.findAll();
        return list;
    }

    @Override
    public void updateRole(Role role, UUID id) {
        Role roleToUpdate = findById(id);
        roleToUpdate.setName(role.getName());
        repository.save(roleToUpdate);
    }

    @Override
    public Role findById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new UsernameNotFoundException("Role not found"));
    }
}