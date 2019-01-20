package com.app.controllers;
import com.app.models.dao.EmployeeDao;
import com.app.models.dto.CarDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/")
    public String loginGet(Model model) {
        return "employee/login";
    }

    /*todo below*/

    @PostMapping("/")
    public String loginPost(@ModelAttribute String login, @ModelAttribute String password) {
        if(login != null && password != null && employeeDao !=null){
            if (employeeDao.findByUsernameAndPassword(login,password).isPresent()){
                return "employee/carsEmployeeView";
            }
        }
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
