package com.app.models;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "Adresses")
public class Address {
    @Id
    @GeneratedValue
    Long id;
    String street;
    @Column(name = "home_number")
    Long homeNumber;
    @Column(name = "apartment_number")
    Long apartmentNumber;
    String city;
    @Column(name = "post_code")
    String postCode;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy =  "address")
    List<Employee> employees = new ArrayList<>();

}
