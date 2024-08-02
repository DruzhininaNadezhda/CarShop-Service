package org.example.console.out;
import org.example.dto.CarDto;
import java.util.Map;
import java.util.TreeMap;

public class CarOut {
    public void getAllCars(Map<Integer,CarDto> cars) {
        for (Integer number: cars.keySet()){
            System.out.println("Номер в каталоге: "+number +" "+ cars.get(number));
        }
    }
    public void getFreeCars(Map<Integer,CarDto> cars) {
        for (Integer number: cars.keySet()){
            if (cars.get(number).getCarStatus().getStatus().equals("free")){
            System.out.println("Номер в каталоге: "+number +" "+ cars.get(number));}
        }
    }

    public boolean getForNumber(int numberCar, Map<Integer, CarDto> cars) {
        if(!cars.containsKey(numberCar)){
            System.out.println("Машины с таким номером нет в каталоге");
            return false;
        } else if(!cars.get(numberCar).getCarStatus().getStatus().equals("free")){
        System.out.println("Машина забронирована или продана");
        return false;}
        return true;
    }
    public Map<Integer, CarDto> filterCar(String filter, Map<Integer, CarDto> cars) {
        Map<Integer, CarDto> filterCars=new TreeMap<>();
        if (!cars.isEmpty()) {
            for (Map.Entry<Integer, CarDto> entry : cars.entrySet()) {
                String result = entry.getValue().toString().toLowerCase();
                if (result.matches(filter.toLowerCase())) {
                    filterCars.put(entry.getKey(),entry.getValue());
                    System.out.println(entry);
                }
            }
        }
        return filterCars;
    }
}
