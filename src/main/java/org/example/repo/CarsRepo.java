package org.example.repo;

import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.PersonDto;

import java.util.HashMap;
import java.util.Optional;
import java.util.TreeMap;

public interface CarsRepo {
    void createCar(CarDto carDto, DataBase main);
    void delete(int number, DataBase main);
    void update(CarDto carDto, DataBase main);
    TreeMap<Integer, CarDto> addAll(DataBase main);
    Optional<CarDto> addNumber(int number, DataBase main);
}
