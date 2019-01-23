package com.app.models;

import com.app.models.enums.FuelType;
import lombok.*;
import org.springframework.context.annotation.Configuration;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Cars")
public class Car {
    @Id
    @GeneratedValue
    Long id;
    Long mileage;
    @Column(name = "production_year")
    Long productionYear;
    @Column(name = "engine_capacity", precision = 3, scale = 1)
    Double engineCapacity;
    Long power;
    @Enumerated(value = EnumType.STRING)
    @Column(name = "fuel_type")
    FuelType fuelType;
    @Column(precision = 20, scale = 2)
    Double price;
    @Column(name = "publishment_date")
    LocalDate publishmentDate;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "client_id_last_owner")
    Client lastOwner;

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "markModel_id")
    MarkModelCar markModel;
    Boolean accidents;
    String photoPath;

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", mileage=" + mileage +
                ", productionYear=" + productionYear +
                ", engineCapacity=" + engineCapacity +
                ", power=" + power +
                ", fuelType=" + fuelType +
                ", price=" + price +
                ", publishmentDate=" + publishmentDate +
                ", lastOwner=" + lastOwner.id +
                ", markModel=" + markModel.id +
                ", accidents=" + accidents +
                ", photoPath='" + photoPath + '\'' +
                '}';
    }
}
