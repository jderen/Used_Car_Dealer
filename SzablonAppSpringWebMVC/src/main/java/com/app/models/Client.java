package com.app.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
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
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "lastOwner")
    List<Car> cars = new ArrayList<>();

}
