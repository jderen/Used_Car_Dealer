package com.app.controllers;

import com.app.models.Account;
import com.app.models.Employee;
import com.app.models.dao.AccountsDao;
import com.app.models.dao.EmployeeDao;
import com.app.models.dto.AccountDto;
import com.app.models.dto.EmployeeDto;
import com.app.models.dto.converters.AccountsConverter;
import com.app.models.dto.converters.EmployeeConverter;
import com.app.models.enums.Role;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("myManager")
public class ManagerEmployeesController {
    private EmployeeDao employeeDao;

    public ManagerEmployeesController(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }

    @GetMapping("/employees")
    public String employeesFormGet(Model model) {
        List<Employee> employees = employeeDao.findAll();
        List<EmployeeDto> employeeDto = new ArrayList<>();
        EmployeeConverter employeeConverter = new EmployeeConverter();

        for (Employee employee : employees) {
            employeeDto.add(employeeConverter.employeeToEmployeeDto(employee));
        }

        model.addAttribute("employees", employeeDto);
        model.addAttribute("employeeAdd", new EmployeeDto());
        return "manager/employees";
    }

    @PostMapping("/employees/add")
    public String employeesFormPost(EmployeeDto employeeDto) {
        Employee employee = new EmployeeConverter().employeeDtoToEmployee(employeeDto);
        employeeDao.insert(employee);
        return "redirect:/myManager/employees";
    }

    @GetMapping("/employees/delete/{id}")
    public String deleteEmployee(@PathVariable Long id){
        try{
            employeeDao.delete(id);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/myManager/employees";
    }

    @GetMapping("/employees/update/{id}")
    public String updateEmployee(@PathVariable Long id, Model model){
        EmployeeDto employeeDto = new EmployeeConverter().employeeToEmployeeDto(employeeDao.findById(id).orElseThrow(NullPointerException::new));
        model.addAttribute("employee", employeeDto);

        return "/manager/employeesUpdate";
    }

    @PostMapping("/employees/update/{id}")
    public String updateEmployee(@ModelAttribute EmployeeDto employeeDto, @PathVariable Long id){
        EmployeeConverter employeeConverter = new EmployeeConverter();
        Employee employee = employeeConverter.employeeDtoToEmployee(employeeDto);
        employeeDao.update(employee);
        return "redirect:/myManager/employees";
    }
}
