package com.dz8.demo.model.manufacturer.service;


import com.dz8.demo.model.manufacturer.entity.Manufacturer;
import com.dz8.demo.model.user.service.UserServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;


@Service
public class ManufacturerService {
    private  ManufacturerRepository manufacturerRepository;
    @Autowired
    @Lazy
    public void setManufacturerRepository(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
    }
    public List<Manufacturer> getAll() {
        return manufacturerRepository.findAll();
    }

    public Manufacturer getByName(String name) {
        return manufacturerRepository.getByName(name);
    }
    public Manufacturer getById(UUID id){
        return manufacturerRepository.getById(id);
    };
    public void delete(String id) {
        manufacturerRepository.deleteById(UUID.fromString(id));
    }

    public Manufacturer save(Manufacturer manufacturer) {
        return manufacturerRepository.save(manufacturer);
    }

}
