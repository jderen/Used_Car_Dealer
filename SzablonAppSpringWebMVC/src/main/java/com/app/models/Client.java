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
@Table(name = "Clients")
public class Client {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String surname;
    @Column(name = "phone_number")
    String phoneNumber;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER,mappedBy = "lastOwner")
    List<Car> cars = new ArrayList<>();
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "client")
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
