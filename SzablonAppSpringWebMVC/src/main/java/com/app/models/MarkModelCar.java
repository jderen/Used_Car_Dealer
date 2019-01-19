package com.app.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class MarkModelCar {
    @Id
    @GeneratedValue
    Long id;
    String model;
    String mark;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "markModel")
    List<Car> cars;
}
