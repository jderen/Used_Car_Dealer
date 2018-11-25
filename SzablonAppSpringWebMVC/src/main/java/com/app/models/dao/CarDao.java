package com.app.models.dao;

import lombok.*;

import java.math.BigDecimal;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class CarDao {
    String photo;
    String brand;
    String model;
    String accidents;
    Long mileage;
    Long year;
    BigDecimal engine;
    Long power;
    String fuel;
    BigDecimal price;
    Date publishmentDate;
    String seller;

    @Override
    public String toString() {
        return "CarDao{" +
                "photo='" + photo + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", accidents='" + accidents + '\'' +
                ", mileage=" + mileage +
                ", year=" + year +
                ", engine=" + engine +
                ", power=" + power +
                ", fuel='" + fuel + '\'' +
                ", price=" + price +
                ", publishmentDate=" + publishmentDate +
                ", seller='" + seller + '\'' +
                '}';
    }
}
