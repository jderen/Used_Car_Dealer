package com.app.models;

import com.app.models.enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue
    Long id;
    Long mileage;
    @Column(name = "production_year")
    Long productionYear;
    @Column(name = "engine_capacity", precision = 1)
    BigDecimal engineCapacity;
    Long power;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "fuel_type")
    FuelType fuelType;
    BigDecimal price;
    @Column(name = "publishment_date")
    LocalDate publishmentDate;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id_last_owner")
    Client lastOwner;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "markModel_id")
    MarkModelCar markModel;
    Boolean accidents;
    String photoPath;

}
