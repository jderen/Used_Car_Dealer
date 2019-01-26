package com.app.models.dto.converters;

import com.app.models.Car;
import com.app.models.Client;
import com.app.models.Employee;
import com.app.models.Transaction;
import com.app.models.dao.ClientDao;
import com.app.models.dao.*;
import com.app.models.dto.CarDto;
import com.app.models.dto.TransactionDto;

public class TransactionConverter {
    private ClientDao clientDao;
    private CarDao carDao;
    private EmployeeDao employeeDao;

    public TransactionConverter(ClientDao clientDao, CarDao carDao, EmployeeDao employeeDao) {
        this.clientDao = clientDao;
        this.carDao = carDao;
        this.employeeDao=employeeDao;
    }

    public TransactionDto transactionToTransactionDto(Transaction transaction){
        if (transaction.getClient() == null){
            transaction.setClient(new Client());
        }
        if (transaction.getEmployee() == null){
            transaction.setEmployee(new Employee());
        }
        if (transaction.getCar() == null){
            transaction.setCar(new Car());
        }
        return transaction == null ? null : TransactionDto.builder()
                .id(transaction.getId())
                .price(transaction.getPrice())
                .transactionDate(transaction.getTransactionDate())
                .employeeId(transaction.getEmployee().getId())
                .carId(transaction.getCar().getId())
                .clientId(transaction.getClient().getId())
                .build();
    }

    public Transaction transactionDtoToTransaction(TransactionDto transactionDto){

        return Transaction.builder()
                .id(transactionDto.getId())
                .price(transactionDto.getPrice())
                .transactionDate(transactionDto.getTransactionDate())
                .employeeId(new Employee(transactionDto.getEmployeeId(),null,null,null,null,null,null,null,null))
                .carId(new Car(transactionDto.getCarId(),null,null,null,null,null,null,null,null,null,null,null))
                .clientId(new Client(transactionDto.getClientId(),null,null,null,null,null))
                .build();
    }
}
