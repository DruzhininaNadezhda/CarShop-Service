package org.example.console.in;
import org.example.dto.CarDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CarInTest {
    @Test
    void addCarEquals() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        Assertions.assertEquals(carIn.addCar(carDto,cars), "Машина добавлена");
    }
    @Test
    void addCarEquals1() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,cars);
        Assertions.assertEquals(cars.size(),1);
    }
    @Test
    void addCarEquals2() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        cars.put(1,carDto);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto1,cars);
        Assertions.assertEquals(cars.get(2),carDto1);
    }

    @Test
    void updateCar() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        cars.put(1,carDto);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        Assertions.assertEquals(carIn.updateCar(1,carDto1,cars), "Изменения внесены");
    }
    @Test
    void updateCar1() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        cars.put(1,carDto);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.updateCar(1,carDto1,cars);
        Assertions.assertEquals(cars.get(1),carDto1);
    }

    @Test
    void deleteCar() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        cars.put(1,carDto);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        cars.put(2,carDto1);
        carIn.deleteCar(1,cars);
        Assertions.assertFalse(cars.containsKey(1));
    }
    @Test
    void addCarNoUpdateCar() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        cars.put(1,carDto);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        cars.put(1,carDto1);
        Assertions.assertNotEquals(carIn.updateCar(3,carDto,cars), "Изменения внесены");
    }
    @Test
    void deleteCarNo() {
        CarIn carIn=new CarIn();
        Map<Integer, CarDto> cars= new TreeMap<>();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        cars.put(1,carDto);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        cars.put(2,carDto1);
        int size =cars.size();
        carIn.deleteCar(4,cars);
        Assertions.assertEquals(cars.size(),size);
    }

}