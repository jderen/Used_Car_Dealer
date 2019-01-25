package com.app.controllers;
import com.app.models.Account;
import com.app.models.Car;
import com.app.models.Employee;
import com.app.models.MarkModelCar;
import com.app.models.dao.*;
import com.app.models.dto.CarDto;
import com.app.models.dto.converters.CarConverter;
import com.app.models.enums.FuelType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import javax.validation.constraints.Null;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeDao employeeDao;

    public EmployeeController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/")
    public String loginGet(Model model) {
        Account account = new Account();
        model.addAttribute("account", account);
        return "employee/login";
    }

    /*todo below*/

    @PostMapping("/")
    public String loginPost(@ModelAttribute Account account) {
        if(account.getPassword() != null && account.getPassword() != null && employeeDao !=null){
            try
            {
                Employee e = employeeDao.findByUsernameAndPassword(account.getLogin(),account.getPassword()).orElseThrow(NullPointerException::new);
            }catch (NullPointerException e){
                System.out.println(e.toString());
                return "employee/login";
            }
            return "redirect:/employee/cars";
        }
        return "employee/login";
    }


    @RequestMapping("/transactions")
    public String transactionsForm() {
        return "employee/transactions";
    }

}
