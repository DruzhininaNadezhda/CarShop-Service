package org.example.console.in;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.repo.CarsRepo;
import org.example.repo.Impl.CarsRepoImpl;

import java.util.Comparator;
import java.util.Map;

public class CarIn {
    CarsRepo carsRepo=new CarsRepoImpl();
    /**
     * Adding a new car to the database
     * @param carDto object car
     * @param main Database object
     * @return A line with the result of saving
     */
    public String addCar(CarDto carDto, DataBase main) {
        if (!main.getCars().isEmpty()) {
            int number = main.getCars().keySet().stream().max(Comparator.naturalOrder()).get() + 1;
            carDto.setNumber(number);
            carsRepo.createCar(carDto,main);
                   } else {
            carDto.setNumber(1);
            carsRepo.createCar(carDto,main);;
        }
        return "Машина добавлена";
    }
    /**
     * Updating a car, check for car availability by number
     * @param carDto object car
     * @param main Database object
     * @return A line with the result
     */
    public String updateCar(Integer number , CarDto carDto, DataBase main) {
        if(main.getCars().containsKey(number)){
        carDto.setNumber(number);
            carsRepo.update(carDto,main);
        return "Корректировки внесены";}
        return "";
    }
    /**
     * Deleting a car, check for car availability by number
     * @param number car
     * @param main Database object
     * @return A line with the result
     */
    public String deleteCar(Integer number, DataBase main) {
        if(main.getCars().containsKey(number)){
        carsRepo.delete(number,main);
        return "Машина удалена из базы";
    }return "";
    }
}
