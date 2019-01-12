package com.app.models;

import com.app.models.enums.FuelTypeEnum;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue
    Long id;
    Long mileage;
    @Column(name = "production_year")
    Long productionYear;
    @Column(name = "engine_capacity")
    BigDecimal engineCapacity;
    Long power;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "fuel_type")
    FuelTypeEnum fuelType;
    BigDecimal price;
    @Column(name = "publishment_date")
    Date publishmentDate;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER, mappedBy = "cars")
    @JoinColumn(name = "client_id_last_owner")
    Client lastOwner;
    
    String photoPath;

}
