package com.dz8.demo.controler;

import com.dz8.demo.model.manufacturer.entity.Manufacturer;
import com.dz8.demo.model.manufacturer.service.ManufacturerService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/manufacturer")
@AllArgsConstructor
public class ManufacturerController {

    private final ManufacturerService manufacturerService;


    @GetMapping
    public ModelAndView showPage(Manufacturer manufacturer) {
        ModelAndView modelAndView = new ModelAndView("manufacturer");
        modelAndView.addAllObjects(Map.of("manufacturer", manufacturer,  "manufacturers", manufacturerService.getAll()));
        return modelAndView;
    }

    @PostMapping
    public String registerManufacturer(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return "redirect:/manufacturer";
    }

    @PostMapping("/delete")
    public String deleteProduct(String id) {
        manufacturerService.delete(id);
        return "redirect:/manufacturer";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("manufacturer") Manufacturer manufacturer) {
        manufacturerService.save(manufacturer);
        return "redirect:/manufacturer";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProductGet(@PathVariable String id) {

        ModelAndView modelAndView = new ModelAndView("manufacturer");
        Manufacturer manufacturer = manufacturerService.getById(UUID.fromString(id));

        modelAndView.addAllObjects(Map.of( "manufacturers", manufacturerService.getAll(), "manufacturerEditId", manufacturer));
        return modelAndView;
    }

}