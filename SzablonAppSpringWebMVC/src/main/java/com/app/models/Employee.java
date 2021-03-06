package com.app.models;

import lombok.*;
import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder

@Entity
@Table(name = "Employees")
public class Employee {
    @Id
    @GeneratedValue
    Long id;
    String name;
    String surname;
    @Column(name = "phone_number")
    String phoneNumber;
    @Column(name = "hire_date")
    LocalDate hireDate;
    BigDecimal salary;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id", unique = true)
    Account account;
    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    @JoinColumn(name = "address_id")
    Address address;
    @OneToMany(cascade = CascadeType.PERSIST, mappedBy = "employee")
    List<Transaction> transactions = new ArrayList<>();

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", hireDate=" + hireDate +
                ", salary=" + salary +
                ", account=" + account.id +
                ", address=" + address.id +
                '}';
    }
}
