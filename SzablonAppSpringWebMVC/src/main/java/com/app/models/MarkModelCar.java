package com.app.models;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "mark_model")
public class MarkModelCar {
    @Id
    @GeneratedValue
    Long id;
    String model;
    String mark;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "markModel")
    List<Car> cars;

    @Override
    public String toString() {
        return "MarkModelCar{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", mark='" + mark + '\'' +
                '}';
    }
}
