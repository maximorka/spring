package com.dz8.demo.controler;

import com.dz8.demo.model.role.entity.Role;
import com.dz8.demo.model.role.service.RoleService;
import com.dz8.demo.model.user.entity.User;
import com.dz8.demo.model.user.service.UserSecurity;
import com.dz8.demo.model.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/user")
@AllArgsConstructor
public class UserControler {

    private final UserServiceImpl userService;
    private final RoleService roleService;

    @GetMapping
    public ModelAndView showPage(UserSecurity user) {
        ModelAndView modelAndView = new ModelAndView("user");
        List<Role> roles = roleService.findAll();
        modelAndView.addAllObjects(Map.of("user", user, "AllUsers", userService.findAll(),"roles",roles));
        return modelAndView;
    }


    @PostMapping
    public String registerUser(@ModelAttribute("user") UserSecurity userSecurity) {
        userService.save(userSecurity);
        return "redirect:/user";
    }

    @PostMapping("/delete")
    public String deleteUser(String id) {
        userService.delete(id);
        return "redirect:/user";
    }

    @PostMapping("/edit")
    public String editUser(@ModelAttribute("user") UserSecurity userSecurity) {
        userService.save(userSecurity);
        return "redirect:/user";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editUserGet(@PathVariable String id) {
        ModelAndView modelAndView = new ModelAndView("user");
        UserSecurity user = new UserSecurity();
        List<Role> roles = roleService.findAll();
        User userEditId = userService.findById(UUID.fromString(id));
        modelAndView.addAllObjects(Map.of("user", user, "AllUsers", userService.findAll(), "roles", roles,"userEditId", userEditId));
        return modelAndView;
    }
}
