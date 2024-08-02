package org.example.service;

import org.example.dto.CarDto;
import org.example.dto.enums.CarCondition;

import java.util.List;

public interface Cars {
   // 2. Управление автомобилями
//- Просмотр списка всех доступных автомобилей.
//- Добавление нового автомобиля (марка, модель, год выпуска, цена, состояние и т.д.).
   //         - Редактирование информации об автомобиле.
   //         - Удаление автомобиля из списка.
    //-- Поиск автомобилей по марке, модели, году выпуска, цене и другим характеристикам.
    public CarDto addNewCar(String brand, String model, int yearOfCarProduction, double carPrice, CarCondition condition);
    public List<CarDto> findAll();
    public CarDto updateCar(CarDto carDto);
    public boolean deleteCar (CarDto carDto);
    public List<CarDto> filterCar (String filter);

}
