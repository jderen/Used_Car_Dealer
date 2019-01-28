package com.app.models.dto;

import com.app.models.Employee;
import com.app.models.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

/* <th onclick="sortTable(0)">ID Pracownika</th>
                        <th onclick="sortTable(1)">Imię</th>
                        <th onclick="sortTable(2)">Nazwisko</th>
                        <th onclick="sortTable(3)">Nr tel.</th>
                        <th onclick="sortTable(4)">Wypłata</th>
                        <th onclick="sortTable(5)">Data zatrudnienia</th>
                        <th onclick="sortTable(6)">Hasło</th>
                        <th onclick="sortTable(7)">Stanowisko</th>
                        <th onclick="sortTable(8)">ID Konta</th>
                        <th onclick="sortTable(9)">ID Adresu</th>
                        <th onclick="sortTable(10)">Akcja</th>*/
public class AccountDto {
    Long id;
    String login;
    String password;
    String role;
    Long employeeId;
}
