package com.app.controllers;

import com.app.models.Car;
import com.app.models.dao.CarDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Controller
public class MyController {

    @GetMapping("/")
    public String index(Model model)
    {
        CarDao carDao = CarDao.builder()
                .accidents("bezwypadkowy")
                .brand("Fiat")
                .model("Uno")
                .engine(new BigDecimal(1))
                .fuel("LPG")
                .mileage(new Long("1000"))
                .photo("bonzo.jpg")
                .power(new Long("50"))
                .price(new BigDecimal(55555))
                .publishmentDate(new Date())
                .seller("pan sprzedawca")
                .year(new Long("2018"))
                .build();
        List<CarDao> cars = Arrays.asList(carDao,carDao);
        model.addAttribute("cars", cars);
        return "index";
    }


}
