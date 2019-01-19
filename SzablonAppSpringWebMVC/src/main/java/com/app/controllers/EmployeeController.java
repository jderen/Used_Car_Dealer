package com.app.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    @GetMapping("/")
    public String loginPost(Model model) {
        return "employee/login";
    }

    @GetMapping("/cars")
    public String carsForm() {
        return "employee/carsClientView";
    }

    @GetMapping("/carsList")
    public String carsListForm() {
        return "employee/carsEmployeeView";
    }

    @RequestMapping("/clients")
    public String clientsForm() {
        return "employee/clients";
    }

    @RequestMapping("/transactions")
    public String transactionsForm() {
        return "employee/transactions";
    }

}
