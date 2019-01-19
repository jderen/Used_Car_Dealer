package com.app.models;

import com.app.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Accounts")
public class Account {
    @Id
    @GeneratedValue
    Long id;
    String login;
    String password;
    @Enumerated(EnumType.STRING)
    Role role;
    @OneToOne(cascade = CascadeType.PERSIST, mappedBy = "account")
    Employee employee;
}
