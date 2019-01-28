package com.app.controllers;

import com.app.models.Car;
import com.app.models.dao.CarDao;
import com.app.models.dao.ClientDao;
import com.app.models.dao.EmployeeDao;
import com.app.models.dao.MarkModelDao;
import com.app.models.dto.CarDto;
import com.app.models.dto.converters.CarConverter;
import com.app.models.enums.FuelType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("myManager")
public class ManagerCarsController {

    private EmployeeDao employeeDao;
    private CarDao carDao;
    private ClientDao clientDao;
    private MarkModelDao markModelDao;

    public ManagerCarsController(EmployeeDao employeeDao, CarDao carDao, ClientDao clientDao, MarkModelDao markModelDao) {
        this.employeeDao = employeeDao;
        this.carDao = carDao;
        this.clientDao = clientDao;
        this.markModelDao = markModelDao;
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
        return "manager/carsClientViewTL";
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

        return "manager/carsEmployeeViewTL";
    }

    @PostMapping("/cars/add")
    public String addCar(@ModelAttribute CarDto carDto) {
        CarConverter carConverter = new CarConverter();
        Car car = carConverter.carDtoToCar(carDto);
        try {
            car.setLastOwner(clientDao.findById(carDto.getLastOwnerId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID KLIENTA NIE ISTNIEJE W BAZIE - NIE DODANO!");
            car.setLastOwner(null);
            return "redirect:/myManager/carsList";
        }

        try {
            car.setMarkModel(markModelDao.findByMarkAndModel(carDto.getMark(), carDto.getModel()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            markModelDao.insert(car.getMarkModel());
            car.setMarkModel(markModelDao.findByMarkAndModel(car.getMarkModel().getMark(),car.getMarkModel().getModel()).orElse(null));
        }
        car.setPublishmentDate(LocalDate.now());

        carDao.insert(car);
        return "redirect:/myManager/carsList";
    }

    @GetMapping("/cars/delete/{id}")
    public String deleteCar(@PathVariable Long id){
        try{
            carDao.delete(id);
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
        return "redirect:/myManager/carsList";
    }


    @GetMapping("/cars/update/{id}")
    public String updateCar(@PathVariable Long id, Model model){
        CarConverter carConverter = new CarConverter();
        CarDto carDto = carConverter.carToCarDto(carDao.findById(id).orElseThrow(NullPointerException::new));

        model.addAttribute("car", carDto);
        model.addAttribute("fuels", FuelType.values());
        return "/manager/updateCar";
    }

    @PostMapping("/cars/update/{id}")
    public String updateCar(@ModelAttribute CarDto carDto, @PathVariable Long id){
        CarConverter carConverter = new CarConverter();
        Car car = carConverter.carDtoToCar(carDto);

        try {
            car.setMarkModel(markModelDao.findByMarkAndModel(carDto.getMark(), carDto.getModel()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            markModelDao.insert(car.getMarkModel());
            car.setMarkModel(markModelDao.findByMarkAndModel(car.getMarkModel().getMark(),car.getMarkModel().getModel()).orElse(null));
        }

        try {
            car.setLastOwner(clientDao.findById(carDto.getLastOwnerId()).orElseThrow(NullPointerException::new));
        } catch (NullPointerException e) {
            System.out.println(e.getMessage());
            System.out.println("PODANE ID KLIENTA NIE ISTNIEJE W BAZIE - BRAK MODYFIKCAJI!");
            return "redirect:/myManager/carsList";
        }

        try{
            car.setPublishmentDate(carDao.findById(carDto.getId()).orElseThrow(NullPointerException::new).getPublishmentDate());
        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }

        carDao.update(car);
        return "redirect:/myManager/carsList";
    }
}
