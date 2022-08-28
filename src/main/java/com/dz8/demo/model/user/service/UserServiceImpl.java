package com.dz8.demo.model.user.service;

import com.dz8.demo.model.role.entity.Role;
import com.dz8.demo.model.role.service.RoleRepository;
import com.dz8.demo.model.role.service.RoleService;
import com.dz8.demo.model.user.entity.User;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserDetailsService {
    private  UserRepository userRepository;
    private  RoleRepository roleRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    @Autowired
    @Lazy
    public void setUserRepository(UserRepository userRepository){
        this.userRepository=userRepository;
    }
    @Autowired
    @Lazy
    public void setRoleRepository(RoleRepository roleRepository){
        this.roleRepository=roleRepository;
    }
    public void save(UserSecurity userSecurity) {

        Set<Role> usersRoles = userSecurity.getRoles();

        User newUser = new User();
        if (usersRoles != null) {
            newUser.setRoles(usersRoles);
        } else {
            Role userRole = roleRepository.findByName("USER").orElseThrow(() -> new UsernameNotFoundException("Role not found"));
            newUser.addRoles(userRole);
        }

        newUser.setEmail(userSecurity.getEmail());
        newUser.setLastName(userSecurity.getLastName());
        newUser.setPassword(passwordEncoder.encode(userSecurity.getPassword()));
        newUser.setFirstName(userSecurity.getFirstName());
        userRepository.save(newUser);
    }


    public void delete(String id) {
        userRepository.deleteById(UUID.fromString(id));
    }


    public User findByEmail(String email) {
        return userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }


    public List<User> findAll() {
        return userRepository.findAll();
    }


    public void updateUser(UserSecurity userSecurity, UUID id) {
    }


    public User findById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return UserSecurity.fromUser(user);
    }
}