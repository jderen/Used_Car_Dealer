package com.app.models;

import com.app.models.enums.RoleEnum;

import javax.persistence.*;

@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue
    Long id;
    String login;
    String password;
    @Enumerated(EnumType.STRING)
    RoleEnum role;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "account")
    Employee employee;
}
