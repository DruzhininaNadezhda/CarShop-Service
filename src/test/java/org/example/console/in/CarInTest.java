package org.example.console.in;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
class CarInTest {
    @Test
    void addCarEquals() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        Assertions.assertEquals(carIn.addCar(carDto,main), "Машина добавлена");
    }
    @Test
    void addCarEquals1() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
       carIn.addCar(carDto,main);
        Assertions.assertEquals(main.getCars().size(),1);
    }
    @Test
    void addCarEquals2() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto1,main);
        Assertions.assertEquals(main.getCars().get(2),carDto1);
    }

    @Test
    void updateCar() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        Assertions.assertEquals(carIn.updateCar(1,carDto1,main), "Корректировки внесены");
    }
    @Test
    void updateCar1() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.updateCar(1,carDto1,main);
        Assertions.assertEquals(main.getCars().get(1),carDto1);
    }

    @Test
    void deleteCar() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto1,main);
        carIn.deleteCar(1,main);
        Assertions.assertFalse(main.getCars().containsKey(1));
    }
    @Test
    void updateCarNo() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto1,main);
        Assertions.assertNotEquals(carIn.updateCar(3,carDto,main), "Изменения внесены");
    }
    @Test
    void deleteCarNo() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto1,main);
        int size =main.getCars().size();
        carIn.deleteCar(4,main);
        Assertions.assertEquals(main.getCars().size(),size);
    }
    @Test
    void addCarEquals1No() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        Assertions.assertNotEquals(main.getCars().size(),0);
    }
    @Test
    void addCarEquals2No() {
        CarIn carIn=new CarIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        carIn.addCar(carDto1,main);
        Assertions.assertNotEquals(main.getCars().get(2),carDto);
    }

}