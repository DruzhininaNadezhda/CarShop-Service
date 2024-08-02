package org.example.service;
import org.example.dto.CarDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import java.util.ArrayList;
import java.util.List;
public class CarsIml implements Cars {
    List<CarDto> cars;
    @Override
    public CarDto addNewCar(String brand, String model, int yearOfCarProduction, double carPrice, CarCondition condition) {
        if (cars == null || cars.isEmpty()) {
            cars = new ArrayList<>();
        }
        CarDto car = new CarDto(brand, model, yearOfCarProduction, carPrice, condition, CarStatus.free);
        cars.add(car);
        return car;
    }
    @Override
    public List<CarDto> findAll() {
        if (cars == null || cars.isEmpty()) {
            return new ArrayList<>();
        } else {
            return cars;
        }
    }
    @Override
    public CarDto updateCar(CarDto carDto) {
        return null;
    }
    @Override
    public boolean deleteCar(CarDto carDto) {
        return false;
    }
    @Override
    public List<CarDto> filterCar(String filter) {
        return null;
    }
}
