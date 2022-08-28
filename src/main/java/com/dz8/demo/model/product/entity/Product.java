package com.dz8.demo.model.product.entity;

import com.dz8.demo.model.manufacturer.entity.Manufacturer;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.*;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.UUID;
@Getter
@Setter
@Entity
@Table(name = "product")
public class Product {
    @Id
    @GeneratedValue
    @Type(type = "uuid-char")
    private UUID id;

    @Column
    private String name;
    @Column
    private BigDecimal price;

    @ToString.Exclude
    @JoinColumn(name = "manufacturer_id")
    @ManyToOne(optional = false)
    @NotFound(action = NotFoundAction.IGNORE)
    private Manufacturer manufacturer;
}
