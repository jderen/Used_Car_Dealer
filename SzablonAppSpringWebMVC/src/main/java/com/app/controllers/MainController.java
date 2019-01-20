package com.app.controllers;
import com.app.models.Car;
import com.app.models.Employee;
import com.app.models.dao.CarDao;
import com.app.models.dao.EmployeeDao;
import com.app.models.dao.EmployeeDaoImpl;
import com.app.models.dto.CarDto;
import com.app.models.dto.converters.CarConverter;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.Null;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Controller
public class MainController {

    private EmployeeDao employeeDao;
    private CarDao carDao;

    public MainController(EmployeeDao employeeDao, CarDao carDao) {
        this.employeeDao = employeeDao;
        this.carDao = carDao;
    }

    @GetMapping("/")
    public String showFormGet(Model model) {
        List<Car> list = carDao.findAll();
        List<CarDto> carsDto = new ArrayList<>();
        CarConverter carConverter = new CarConverter();

        for (Car car : list) {
            carsDto.add(carConverter.carToCarDto(car));
        }

        model.addAttribute("cars", carsDto);
        return "carsClientViewTL";
    }

    @GetMapping("/{id}")
    public String showContactInfo(@PathVariable Long id, Model model){
        if (id != null)
        {
            try{
                Random random = new Random();
                Long employeeId = (long) random.nextInt(employeeDao.count().intValue()) + 1;

                Employee employee = employeeDao.findById(employeeId).orElseThrow(NullPointerException::new);
                model.addAttribute("e", employee);
                model.addAttribute("id", id);
            }catch (NullPointerException e){
                System.out.println(e.toString());
                System.out.println("NULL POINTER EXCEPTION - SHOW CONTACT INFO");
            }

            return "carContactInfo";
        }
        return "redirect:/";
    }
}
