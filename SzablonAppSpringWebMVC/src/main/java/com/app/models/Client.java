package com.app.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String surname;
    @Column(name = "phone_number")
    String phoneNumber;
    @ManyToOne(cascade = CascadeType.PERSIST)
    List<Car> cars = new ArrayList<>();

}
