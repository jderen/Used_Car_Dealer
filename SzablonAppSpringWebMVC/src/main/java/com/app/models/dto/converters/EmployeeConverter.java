package com.app.models.dto.converters;

import com.app.models.Account;
import com.app.models.Address;
import com.app.models.Employee;
import com.app.models.dto.EmployeeDto;

import java.math.BigDecimal;

public class EmployeeConverter {
    public EmployeeDto employeeToEmployeeDto(Employee employee){
        return EmployeeDto.builder()
                .id(employee.getId())
                .accountId(employee.getAccount().getId())
                .addressId(employee.getAddress().getId())
                .hireDate(employee.getHireDate())
                .name(employee.getName())
                .surname(employee.getSurname())
                .salary(employee.getSalary().doubleValue())
                .tel(employee.getPhoneNumber())
                .build();
    }

    public Employee employeeDtoToEmployee(EmployeeDto employeeDto){
        return Employee.builder()
                .id(employeeDto.getId())
                .account(new Account(employeeDto.getAccountId(),null,null,null,null))
                .address(new Address(employeeDto.getAddressId(),null,null,null,null,null,null))
                .hireDate(employeeDto.getHireDate())
                .name(employeeDto.getName())
                .surname(employeeDto.getSurname())
                .salary(new BigDecimal(employeeDto.getSalary()))
                .phoneNumber(employeeDto.getTel())
                .transactions(null)
                .build();
    }
}
