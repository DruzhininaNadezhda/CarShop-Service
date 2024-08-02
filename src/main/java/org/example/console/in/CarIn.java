package org.example.console.in;
import org.example.dto.CarDto;
import java.util.Comparator;
import java.util.Map;

public class CarIn {
    public String addCar(CarDto carDto, Map<Integer, CarDto> cars) {
        if (!cars.isEmpty()) {
            int number = cars.keySet().stream().max(Comparator.naturalOrder()).get() + 1;
            carDto.setNumber(number);
            cars.put(number, carDto);
        } else {
            carDto.setNumber(1);
            cars.put(1, carDto);
        }
        return "Машина добавлена";
    }
    public String updateCar(Integer number , CarDto carDto, Map<Integer, CarDto> cars) {
        if(cars.containsKey(number)){
        carDto.setNumber(number);
            cars.put(number, carDto);
        return "Изменения внесены";}
        return "";
    }
    public String deleteCar(Integer number, Map<Integer, CarDto> cars) {
        if(cars.containsKey(number)){
        cars.remove(number);
        return "Машина удалена из базы";
    }return "";
    }
}
