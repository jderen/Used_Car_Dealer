package com.app.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
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
    @ManyToOne(cascade = CascadeType.PERSIST)
    List<Employee> employees = new ArrayList<>();

}
