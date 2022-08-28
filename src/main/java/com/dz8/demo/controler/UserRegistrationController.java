package com.dz8.demo.controler;

import com.dz8.demo.model.role.entity.Role;
import com.dz8.demo.model.role.service.RoleService;
import com.dz8.demo.model.user.service.UserSecurity;
import com.dz8.demo.model.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.*;

@Controller
@RequestMapping("/registration")
@AllArgsConstructor
public class UserRegistrationController {
    private final RoleService roleService;
    private final UserServiceImpl userService;


    @GetMapping
    public ModelAndView showRegistrationForm(UserSecurity user) {
        ModelAndView modelAndView = new ModelAndView("registration");
        List<Role> roles = roleService.findAll();
        modelAndView.addAllObjects(Map.of("user", user, "allRoles", roles));
        return modelAndView;
    }

    @PostMapping
    public String registerUserAccount(@ModelAttribute("user") UserSecurity userSecurity) {
        userService.save(userSecurity);
        return "redirect:/login?reg_success";
    }
}