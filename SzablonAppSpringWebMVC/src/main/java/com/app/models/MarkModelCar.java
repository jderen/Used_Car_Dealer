package com.app.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "mark_model")
public class MarkModelCar {
    @Id
    @GeneratedValue
    Long id;
    String model;
    String mark;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "markModel")
    List<Car> cars;
}
