package com.app.controllers;


import com.app.models.Car;
import com.app.models.Transaction;
import com.app.models.dao.CarDao;
import com.app.models.dao.ClientDao;
import com.app.models.dao.EmployeeDao;
import com.app.models.dao.TransactionDao;
import com.app.models.dto.CarDto;
import com.app.models.dto.TransactionDto;
import com.app.models.dto.converters.CarConverter;
import com.app.models.dto.converters.TransactionConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeTransactionsController {

    private EmployeeDao employeeDao;
    private CarDao carDao;
    private ClientDao clientDao;
    private TransactionDao transactionDao;

    public EmployeeTransactionsController(EmployeeDao employeeDao, CarDao carDao, ClientDao clientDao, TransactionDao transactionDao) {
        this.employeeDao = employeeDao;
        this.carDao = carDao;
        this.clientDao = clientDao;
        this.transactionDao = transactionDao;
    }

    @RequestMapping("/transactions")
    public String transactionsForm(Model model) {
        List<Transaction> list = transactionDao.findAll();
        List<TransactionDto> transactionsDto = new ArrayList<>();
        TransactionConverter transactionConverter = new TransactionConverter();
        TransactionDto transactionDto = new TransactionDto();

        for (Transaction transaction : list) {
            transactionsDto.add(transactionConverter.transactionToTransactionDto(transaction));
        }
        model.addAttribute("transactions", transactionsDto);
        model.addAttribute("transactionAdd", transactionDto);

        return "employee/transactions";
    }

    @PostMapping("/transactions/add")
    public String addTransaction(@ModelAttribute TransactionDto transactionDto) {
        TransactionConverter transactionConverter = new TransactionConverter();
        Transaction transaction = transactionConverter.transactionDtoToTransaction(transactionDto);
        try {
            transaction.setClient(clientDao.findById(transactionDto.getClientId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID KLIENTA NIE ISTNIEJE W BAZIE - NIE DODANO!");
            transaction.setClient(null);
            return "redirect:/employee/transactions";
        }

        try {
            transaction.setEmployee(employeeDao.findById(transactionDto.getEmployeeId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID PRACOWNIKA NIE ISTNIEJE W BAZIE - NIE DODANO!");
            transaction.setEmployee(null);
            return "redirect:/employee/transactions";
        }

        try {
            transaction.setCar(carDao.findById(transactionDto.getCarId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID POJAZDU NIE ISTNIEJE W BAZIE - NIE DODANO!");
            transaction.setCar(null);
            return "redirect:/employee/transactions";
        }

        transaction.setTransactionDate(LocalDate.now());

        transactionDao.insert(transaction);
        return "redirect:/employee/transactions";
    }

    @GetMapping("/transactions/delete/{id}")
    public String deleteTransaction(@PathVariable Long id){
        try{
            transactionDao.delete(id);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/employee/transactions";
    }

    @GetMapping("/transactions/update/{id}")
    public String updateTransaction(@PathVariable Long id, Model model){
        TransactionConverter transactionConverter = new TransactionConverter();
        TransactionDto transactionDto = transactionConverter.transactionToTransactionDto(transactionDao.findById(id).orElseThrow(NullPointerException::new));

        model.addAttribute("transaction", transactionDto);
        return "/employee/updateTransaction";
    }

    @PostMapping("/transactions/update/{id}")
    public String updateTransaction(@ModelAttribute TransactionDto transactionDto, @PathVariable Long id){
        TransactionConverter transactionConverter = new TransactionConverter();
        Transaction transaction = transactionConverter.transactionDtoToTransaction(transactionDto);

        try {
            transaction.setClient(clientDao.findById(transactionDto.getClientId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID KLIENTA NIE ISTNIEJE W BAZIE - NIE DODANO!");
            transaction.setClient(null);
            return "redirect:/employee/transactions";
        }

        try {
            transaction.setEmployee(employeeDao.findById(transactionDto.getEmployeeId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID PRACOWNIKA NIE ISTNIEJE W BAZIE - NIE DODANO!");
            transaction.setEmployee(null);
            return "redirect:/employee/transactions";
        }

        try {
            transaction.setCar(carDao.findById(transactionDto.getCarId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID POJAZDU NIE ISTNIEJE W BAZIE - NIE DODANO!");
            transaction.setCar(null);
            return "redirect:/employee/transactions";
        }

        try{
            transaction.setTransactionDate(transactionDao.findById(transactionDto.getId()).orElseThrow(NullPointerException::new).getTransactionDate());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        transactionDao.update(transaction);
        return "redirect:/employee/transactions";
    }

}
