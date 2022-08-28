package com.dz8.demo.model.product.service;


import com.dz8.demo.model.manufacturer.service.ManufacturerRepository;
import com.dz8.demo.model.product.entity.Product;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.UUID;


@Service
public class ProductServiceImpl  {
    private  ProductRepository productRepository;

    @Autowired
    @Lazy
    public void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public List<Product> getAll() {
        return productRepository.findAll();
    }
    public Product getById(UUID id){
        return productRepository.getById(id);
    };
    public Product save(Product product) {
        return productRepository.save(product);
    }
    public void delete(String id) {
         productRepository.deleteById(UUID.fromString(id));
    }

}