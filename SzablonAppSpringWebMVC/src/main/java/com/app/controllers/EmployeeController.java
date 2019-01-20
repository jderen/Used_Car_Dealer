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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    private CarDao carDao;
    private ClientDao clientDao;
    private MarkModelDao markModelDao;

    public EmployeeController(EmployeeDao employeeDao, CarDao carDao, ClientDao clientDao, MarkModelDao markModelDao) {
        this.employeeDao = employeeDao;
        this.carDao = carDao;
        this.clientDao = clientDao;
        this.markModelDao = markModelDao;
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
        CarDto carDto = new CarDto();

        for (Car car : list) {
            carsDto.add(carConverter.carToCarDto(car));
        }

        model.addAttribute("fuels", FuelType.values());
        model.addAttribute("cars", carsDto);
        model.addAttribute("carAdd", carDto);

        return "employee/carsEmployeeView";
    }

    @Transactional
    @PostMapping("/carsList")
    public String addCar(@ModelAttribute CarDto carDto) {
        CarConverter carConverter = new CarConverter();
        Car car = carConverter.carDtoToCar(carDto);

        try {
            car.setLastOwner(clientDao.findById(carDto.getLastOwnerId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            car.setLastOwner(null);
        }

        try {
            car.setMarkModel(markModelDao.findByMarkAndModel(carDto.getMark(), carDto.getModel()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            markModelDao.insert(car.getMarkModel());
        }

        carDao.insert(car);
        return "redirect:/employee/carsList";
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
