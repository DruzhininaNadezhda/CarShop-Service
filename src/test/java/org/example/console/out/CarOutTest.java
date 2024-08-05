package org.example.console.out;

import org.example.console.in.CarIn;
import org.example.console.in.PersonIn;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class CarOutTest {

    @Test
    void getAllCars() {
        CarIn carIn=new CarIn();
        CarOut carOut=new CarOut();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        Map<Integer,CarDto> result=new TreeMap<>();
        result.put(1,carDto);
        Assertions.assertEquals(carOut.getAllCars(main),result);

    }

    @Test
    void getFreeCars() {
        CarIn carIn=new CarIn();
        CarOut carOut=new CarOut();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        Map<Integer,CarDto> result=new TreeMap<>();
        result.put(1,carDto);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.sold);
        carIn.addCar(carDto1,main);
        Assertions.assertEquals(carOut.getFreeCars(main),result);
    }

    @Test
    void getForNumber() {
        CarIn carIn=new CarIn();
        CarOut carOut=new CarOut();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.sold);
        carIn.addCar(carDto1,main);
        Assertions.assertTrue(carOut.getForNumber(1,main));
    }
    @Test
    void getAllCarsNo() {
        CarIn carIn=new CarIn();
        CarOut carOut=new CarOut();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        Map<Integer,CarDto> result=new TreeMap<>();
        result.put(1,carDto);
        result.put(2,carDto);
        Assertions.assertNotEquals(carOut.getAllCars(main),result);

    }

    @Test
    void getFreeCarsNo() {
        CarIn carIn=new CarIn();
        CarOut carOut=new CarOut();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.sold);
        carIn.addCar(carDto1,main);
        Map<Integer,CarDto> result=new TreeMap<>();
        result.put(1,carDto1);
        Assertions.assertNotEquals(carOut.getFreeCars(main),result);
    }

    @Test
    void getForNumberNo() {
        CarIn carIn=new CarIn();
        CarOut carOut=new CarOut();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.sold);
        carIn.addCar(carDto1,main);
        Assertions.assertFalse(carOut.getForNumber(3,main));
    }
}