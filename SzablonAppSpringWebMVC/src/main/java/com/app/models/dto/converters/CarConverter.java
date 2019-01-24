package com.app.models.dto.converters;

import com.app.models.Car;
import com.app.models.Client;
import com.app.models.MarkModelCar;
import com.app.models.dao.*;
import com.app.models.dto.CarDto;
import com.app.models.enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.transaction.Transactional;

@Data
@NoArgsConstructor
public class CarConverter {

    private ClientDao clientDao;
    private MarkModelDao markModelDao;

    public CarConverter(ClientDao clientDao, MarkModelDao markModelDao) {
        this.clientDao = clientDao;
        this.markModelDao = markModelDao;
    }

    public CarDto carToCarDto(Car car){
        if (car.getLastOwner() == null){
            car.setLastOwner(new Client());
        }
        if (car.getMarkModel() == null){
            car.setMarkModel(new MarkModelCar());
        }
        return car == null ? null : CarDto.builder()
                .id(car.getId())
                .mileage(car.getMileage())
                .productionYear(car.getProductionYear())
                .engineCapacity(car.getEngineCapacity())
                .power(car.getPower())
                .fuelType(car.getFuelType().name())
                .price(car.getPrice())
                .publishmentDate(car.getPublishmentDate())
                .lastOwnerId(car.getLastOwner().getId())
                .lastOwnerName(car.getLastOwner().getName())
                .lastOwnerSurname(car.getLastOwner().getSurname())
                .mark(car.getMarkModel().getMark())
                .model(car.getMarkModel().getModel())
                .accidents(car.getAccidents() == null ? "powypadkowy" : car.getAccidents() ? "bezwypadkowy" : "powypadkowy")
                .photoPath(car.getPhotoPath())
                .build();
    }

    public Car carDtoToCar(CarDto carDto){

        return Car.builder()
                .id(carDto.getId())
                .accidents(carDto.getAccidents() == null ? null : carDto.getAccidents().equals("bezwypadkowy"))
                .engineCapacity(carDto.getEngineCapacity())
                .fuelType(FuelType.valueOf(carDto.getFuelType()))
                .mileage(carDto.getMileage())
                .power(carDto.getPower())
                .photoPath(carDto.getPhotoPath())
                .lastOwner(new Client(carDto.getLastOwnerId(),carDto.getLastOwnerName(),carDto.getLastOwnerSurname(),null,null,null))
                .markModel(new MarkModelCar(null, carDto.getModel(), carDto.getMark(), null))
                .price(carDto.getPrice())
                .productionYear(carDto.getProductionYear())
                .publishmentDate(carDto.getPublishmentDate())
                .build();
    }
}
