package org.example.console.out;
import org.example.console.in.CarIn;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.repo.CarsRepo;
import org.example.repo.Impl.CarsRepoImpl;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class CarOut {
    CarsRepo carsRepo=new CarsRepoImpl();

    /**
     * @param main Database object
     * @return all cars
     */
    public Map<Integer,CarDto>  getAllCars(DataBase main) {
        for (Integer number: main.getCars().keySet()){
            System.out.println("Номер в каталоге: "+number +" "+ main.getCars().get(number));
        }
        return main.getCars();
    }
    /**
     * @param main Database object
     * @return free cars
     */
    public Map<Integer,CarDto> getFreeCars(DataBase main) {
        Map<Integer,CarDto> freeCars = new HashMap<>();
        for (Integer number: main.getCars().keySet()){
            if (main.getCars().get(number).getCarStatus().getStatus().equals("free")){
                freeCars.put(number,main.getCars().get(number));
            System.out.println("Номер в каталоге: "+number +" "+ main.getCars().get(number));}
        }
        return freeCars;
    }
    /**
     * @param numberCar int
     * @param main Database object
     * @return True, if such a car exists
     */
    public boolean getForNumber(int numberCar, DataBase main) {
        if(!main.getCars().containsKey(numberCar)){
            System.out.println("Машины с таким номером нет в каталоге");
            return false;
        } else if(!carsRepo.addNumber(numberCar,main).get().getCarStatus().getStatus().equals("free")){
        System.out.println("Машина забронирована или продана");
        return false;}
        return true;
    }
    /**
     * Filtering by all fields with search for cars string.
     * Case is not important
     * @param filter search parameters
     * @param main Database object
     * @return filtered cars
     */
    public Map<Integer, CarDto> filterCar(String filter, DataBase main) {
        Map<Integer, CarDto> filterCars=new TreeMap<>();
        if (!main.getCars().isEmpty()) {
            for (Map.Entry<Integer, CarDto> entry : main.getCars().entrySet()) {
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
