package com.app.models;

import org.hibernate.annotations.JoinColumnOrFormula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Date;

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
    //java.sql date type
    //Date date = setSqlDate(java.sql.Date.valueOf("2017-11-15"));
    @Column(name = "hire_date")
    Date hireDate;
    BigDecimal salary;
    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "account_id", unique = true)
    Account account;
}
