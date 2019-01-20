package com.app.models.dto;

import com.app.models.Client;
import com.app.models.MarkModelCar;
import com.app.models.enums.FuelType;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CarDto {
    private Long id;
    private Long mileage;
    private Long productionYear;
    private Double engineCapacity;
    private Long power;
    private String fuelType;
    private Double price;
    private LocalDate publishmentDate;
    private Long lastOwnerId;
    private String lastOwnerName;
    private String lastOwnerSurname;
    private String mark;
    private String model;
    private String accidents;
    private String photoPath;
}
