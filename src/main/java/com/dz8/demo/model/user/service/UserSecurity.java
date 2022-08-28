package com.dz8.demo.model.user.service;


import com.dz8.demo.model.role.entity.Role;
import com.dz8.demo.model.user.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.*;

@Data
@AllArgsConstructor
public class UserSecurity implements UserDetails {
    private UUID id;
    private String email;

    private String password;
    private String firstName;
    private String lastName;
    private List<SimpleGrantedAuthority> authorities ;
    private Set<Role> roles = new HashSet<>();
    @Override
    public String toString() {
        return "UserSecurity{" +
                "email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                "password" + password+
                '}';
    }
    public UserSecurity(){

    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }


    @Override
    public String getUsername() {
        return getEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public static UserDetails fromUser(User user){
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), user.getRoles());
    }

}