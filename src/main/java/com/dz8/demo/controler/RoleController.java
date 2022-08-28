package com.dz8.demo.controler;


import com.dz8.demo.model.role.service.RoleService;
import com.dz8.demo.model.role.entity.Role;
import lombok.AllArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;
import java.util.Map;
import java.util.UUID;


@Controller
@RequestMapping("/roles")
@AllArgsConstructor
@Log
public class RoleController {

    private final RoleService roleService;

    @GetMapping("/list")
    public ModelAndView findAll() {
        log.info("Handling find role list request");
        List<Role> list = roleService.findAll();
        ModelAndView modelAndView = new ModelAndView("role-list");
        modelAndView.addAllObjects(Map.of("list", list));
        return modelAndView;
    }

    @GetMapping("/create-new")
    public ModelAndView showForm(Role role) {
        ModelAndView modelAndView = new ModelAndView("edit-role-form");
        modelAndView.addAllObjects(Map.of("role", role));
        return modelAndView;
    }

    @PostMapping("/create-new")
    public RedirectView submitForm(@ModelAttribute("role") Role role){
        roleService.saveRole(role);
        return new RedirectView("/app/roles/list");
    }

    @RequestMapping("/update")
    public ModelAndView showEditForm(@RequestParam UUID id) {
        log.info("Handling update role request: " + id);
        ModelAndView modelAndView = new ModelAndView("edit-role-form");
        Role role = roleService.findById(id);
        modelAndView.addAllObjects(Map.of("role", role));
        return modelAndView;
    }

    @RequestMapping("/delete/{id}")
    public RedirectView deleteUsers(@PathVariable UUID id) {
        log.info("Handling delete user request: " + id);
        roleService.deleteRole(id);
        return new RedirectView("/app/roles/list");
    }

}