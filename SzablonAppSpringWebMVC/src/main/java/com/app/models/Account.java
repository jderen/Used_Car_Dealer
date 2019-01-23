package com.app.models;

import com.app.models.enums.Role;
import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
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
