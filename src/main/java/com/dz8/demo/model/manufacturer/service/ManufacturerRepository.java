package com.dz8.demo.model.manufacturer.service;

import com.dz8.demo.model.manufacturer.entity.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@Repository
@EnableJpaRepositories
public interface ManufacturerRepository extends JpaRepository<Manufacturer, UUID> {
Manufacturer getByName(String name);
}
