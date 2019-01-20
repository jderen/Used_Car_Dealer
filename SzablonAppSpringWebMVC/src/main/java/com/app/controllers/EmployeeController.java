package com.app.controllers;
import com.app.models.Account;
import com.app.models.Car;
import com.app.models.Employee;
import com.app.models.dao.CarDao;
import com.app.models.dao.CarDaoImpl;
import com.app.models.dao.EmployeeDao;
import com.app.models.dto.CarDto;
import com.app.models.dto.converters.CarConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;
import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("employee")
public class EmployeeController {

    private EmployeeDao employeeDao;
    private CarDao carDao;

    public EmployeeController(EmployeeDao employeeDao, CarDao carDao) {
        this.employeeDao = employeeDao;
        this.carDao = carDao;
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
        System.out.println("login: " + account.getLogin() + ", password: " + account.getPassword());
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

    @GetMapping("/cars")
    public String carsForm(Model model) {
        List<Car> list = carDao.findAll();
        List<CarDto> carsDto = new ArrayList<>();
        CarConverter carConverter = new CarConverter();

        for (Car car : list) {
            carsDto.add(carConverter.carToCarDto(car));
        }

        model.addAttribute("cars", carsDto);
        return "employee/carsClientViewTL";
    }

    @GetMapping("/carsList")
    public String showCars(Model model) {
        List<Car> list = carDao.findAll();
        List<CarDto> carsDto = new ArrayList<>();
        CarConverter carConverter = new CarConverter();

        for (Car car : list) {
            carsDto.add(carConverter.carToCarDto(car));
        }

        model.addAttribute("cars", carsDto);

        return "employee/carsEmployeeView";
    }

    @PostMapping("/carsList")
    public String addCar(Model model) {
        CarDto carDto = new CarDto();
        model.addAttribute("car", carDto);
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
