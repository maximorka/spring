package com.dz8.demo.model.product.service;

import com.dz8.demo.model.product.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
@Repository
@EnableJpaRepositories
public interface ProductRepository extends JpaRepository<Product, UUID> {
}
