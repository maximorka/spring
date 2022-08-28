//package com.dz8.demo.config;
//
//import com.dz8.demo.model.user.entity.User;
//import com.dz8.demo.model.user.service.UserRepository;
//import com.dz8.demo.model.user.service.UserSecurity;
//import lombok.AllArgsConstructor;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;
//
//
//public class CustomUserDetailsService implements UserDetailsService {
//
//    @Autowired
//    private  UserRepository userRepository;
//    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
//        User user = userRepository.findByEmail(email).orElseThrow(() -> new UsernameNotFoundException("User not found"));
//        return UserSecurity.fromUser(user);
//    }
//}