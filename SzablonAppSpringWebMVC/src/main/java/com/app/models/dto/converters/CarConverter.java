package com.app.models.dto.converters;

import com.app.models.Car;
import com.app.models.Client;
import com.app.models.MarkModelCar;
import com.app.models.dao.ClientDao;
import com.app.models.dao.ClientDaoImpl;
import com.app.models.dao.MarkModelDao;
import com.app.models.dao.MarkModelDaoImpl;
import com.app.models.dto.CarDto;
import com.app.models.enums.FuelType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CarConverter {
    public CarDto carToCarDto(Car car){
        return CarDto.builder()
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
                .accidents(car.getAccidents() == null ? "null" : car.getAccidents() ? "bezwypadkowy" : "powypadkowy")
                .photoPath(car.getPhotoPath())
                .build();
    }

    public Car carDtoToCar(CarDto carDto){
        return Car.builder()
                .id(carDto.getId())
                .accidents(carDto.getAccidents() == null ? null : carDto.getAccidents().equals("bezwypadkowy"))
                .engineCapacity(carDto.getEngineCapacity())
                .fuelType(FuelType.valueOf(carDto.getFuelType()))
                .lastOwner(new ClientDaoImpl().findById(carDto.getId()).orElseThrow(NullPointerException::new))
                .markModel(new MarkModelDaoImpl().findByMarkAndModel(carDto.getMark(),carDto.getModel()).orElseThrow(NullPointerException::new))
                .mileage(carDto.getMileage())
                .power(carDto.getPower())
                .photoPath(carDto.getPhotoPath())
                .price(carDto.getPrice())
                .productionYear(carDto.getProductionYear())
                .publishmentDate(carDto.getPublishmentDate())
                .build();
    }
}
