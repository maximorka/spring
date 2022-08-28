package com.dz8.demo.controler;

import com.dz8.demo.model.manufacturer.service.ManufacturerService;
import com.dz8.demo.model.product.entity.Product;
import com.dz8.demo.model.product.service.ProductServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import java.util.Map;
import java.util.UUID;

@Controller
@RequestMapping("/product")
@AllArgsConstructor
public class ProductController {

    private final ProductServiceImpl productService;
    private final ManufacturerService manufacturerService;

    @GetMapping
    public ModelAndView showPage(Product product) {
        ModelAndView modelAndView = new ModelAndView("product");
        modelAndView.addAllObjects(Map.of("product", product, "AllProduct", productService.getAll(), "allManufacturers", manufacturerService.getAll()));
        return modelAndView;
    }

    @PostMapping
    public String registerProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @PostMapping("/delete")
    public String deleteProduct(String id) {
        productService.delete(id);
        return "redirect:/product";
    }

    @PostMapping("/edit")
    public String editProduct(@ModelAttribute("product") Product product) {
        productService.save(product);
        return "redirect:/product";
    }

    @GetMapping("/edit/{id}")
    public ModelAndView editProductGet(@PathVariable String id) {

        ModelAndView modelAndView = new ModelAndView("product");
        Product product = new Product();

        Product productEditId = productService.getById(UUID.fromString(id));
                modelAndView.addAllObjects(Map.of("product", product, "AllProduct", productService.getAll(), "allProducers", manufacturerService.getAll(),"productEditId", productEditId));
        return modelAndView;
    }
}