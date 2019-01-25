package com.app.controllers;

import com.app.models.dao.CarDao;
import com.app.models.dao.ClientDao;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("employee")
public class EmployeeClientController {

    private ClientDao clientDao;

    public EmployeeClientController(ClientDao clientDao) {
        this.clientDao = clientDao;
    }

    @GetMapping("/clients")
    public String clientsForm(Model model) {
        model.addAttribute("clients", clientDao.findAll());

        return "employee/clients";
    }

}
