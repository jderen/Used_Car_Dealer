package com.app.models;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Table(name = "transactions")
public class Transaction {
    @Id
    @GeneratedValue
    Long id;
    Double price;
    @Column(name = "transaction_name")
    LocalDate transactionDate;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "employee_id")
    Employee employee;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "car_id")
    Car car;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "client_id")
    Client client;

    @Override
    public String toString() {
        return "Transaction{" +
                "id=" + id +
                ", price=" + price +
                ", transactionDate=" + transactionDate +
                ", employee=" + employee.id +
                ", car=" + car.id +
                ", client=" + client.id +
                '}';
    }
}
