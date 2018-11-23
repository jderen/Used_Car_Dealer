package com.app.models.dao;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
