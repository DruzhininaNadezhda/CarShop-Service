package org.example.repo.Impl;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.repo.CarsRepo;

import java.util.Optional;
import java.util.TreeMap;

public class CarsRepoImpl implements CarsRepo {
    @Override
    public void createCar(CarDto carDto, DataBase main) {
        main.getCars().put(carDto.getNumber(),carDto);
    }
    @Override
    public void delete(int number, DataBase main) {
        main.getCars().remove(number);
    }
    @Override
    public void update(CarDto carDto, DataBase main) {
        main.getCars().put(carDto.getNumber(),carDto);
    }

    @Override
    public TreeMap<Integer, CarDto> addAll(DataBase main) {
        return main.getCars();
    }
    @Override
    public Optional<CarDto> addNumber(int number, DataBase main) {
        return Optional.ofNullable(main.getCars().get(number));
    }
}
