package com.app.models.dto.converters;

import com.app.models.Account;
import com.app.models.Employee;
import com.app.models.dao.EmployeeDao;
import com.app.models.dto.AccountDto;
import com.app.models.enums.Role;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AccountsConverter {

    private EmployeeDao employeeDao;

    public AccountsConverter(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    public AccountDto accountToAccountDto(Account account){
        if (account.getEmployee() == null) {
            account.setEmployee(new Employee());
        }
        return AccountDto.builder()
                .id(account.getId())
                .login(account.getLogin())
                .password(account.getPassword())
                .role(account.getRole().name())
                .employeeId(account.getEmployee().getId())
                .build();
    }

    public Account accountDtoToAccount(AccountDto accountDto){
        return Account.builder()
                .id(accountDto.getId())
                .employee(employeeDao.findById(accountDto.getEmployeeId()).orElseThrow(NullPointerException::new))
                .login(accountDto.getLogin())
                .password(accountDto.getPassword())
                .role(Role.valueOf(accountDto.getRole()))
                .build();
    }
}
