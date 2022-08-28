package com.dz8.demo.model.manufacturer.entity;

import com.dz8.demo.model.product.entity.Product;
import lombok.Data;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;
@Data
@Entity
@Table(name = "manufacturer")
public class Manufacturer {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "manufacturer", fetch = FetchType.LAZY)
    private List<Product> products;
}
