package org.example.console.in;

import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import org.example.dto.ServiceDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import org.example.dto.enums.OrderStatus;
import org.example.dto.enums.RoleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class OrderInTest {

    @Test
    void newOrderEquals() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        Assertions.assertEquals(orderIn.newOrder(personDto,carDto,main),"Заказ создан");
    }
    @Test
    void newOrderEquals1() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        Assertions.assertEquals(main.getOrdersMap().size(),1);
    }
    @Test
    void newOrderEquals2() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        orderIn.newOrder(personDto,carDto1,main);
        Assertions.assertEquals(main.getOrdersMap().get(2).getCars(),carDto1);
    }

    @Test
    void updateOrder() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.updateOrder(personDto,1,carDto1,main);
        Assertions.assertEquals(main.getOrdersMap().get(1).getCars(),carDto1);
    }

    @Test
    void deleteOrder() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.deleteOrder(1,main);
        Assertions.assertFalse(main.getOrdersMap().containsKey(1));
    }


    @Test
    void processOrder() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        Assertions.assertEquals(orderIn.processOrder(1, main),"Заказ принят в работу");
    }
    @Test
    void processOrder2() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.closeOrder(1, main);
        Assertions.assertEquals(orderIn.processOrder(1, main),"Заказ уже закрыт");
    }

    @Test
    void closeOrder() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.closeOrder(1, main);
       Assertions.assertEquals(orderIn.closeOrder(1, main),"Заказ уже закрыт ранее");
    }
    @Test
    void closeOrder1() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.closeOrder(1, main);
        Assertions.assertEquals(main.getOrdersMap().get(1).getOrderStatus().getStatus(),"Closed");
    }
    @Test
     void newOrderService() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        Assertions.assertEquals(orderIn.newOrderService(carDto,problem,main,personDto), "Заказ создан");
    }
    @Test
    void newOrderService1() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        Assertions.assertEquals(main.getServiceMap().size(),1);
    }
    @Test
    void processOrderService() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        Assertions.assertEquals(orderIn.processOrderService(1, main),"Заказ принят в работу");
    }
    @Test
    void closeOrderService() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        Assertions.assertEquals(orderIn.closeOrderService(1, main),"Заказ закрыт");
    }
    @Test
    void deleteOrderService() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        orderIn.deleteOrderService(1,main);
        Assertions.assertFalse(main.getServiceMap().containsKey(1));
    }
    @Test
    void newOrderEqualsNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.sold);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        Assertions.assertNotEquals(orderIn.newOrder(personDto,carDto,main),"Заказ создан");
    }
    @Test
    void newOrderEquals1No() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        Assertions.assertNotEquals(main.getOrdersMap().size(),0);
    }
    @Test
    void newOrderEquals2No() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        orderIn.newOrder(personDto,carDto1,main);
        Assertions.assertNotEquals(main.getOrdersMap().get(2).getCars(),carDto);
    }

    @Test
    void updateOrderNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.updateOrder(personDto,1,carDto1,main);
        Assertions.assertNotEquals(main.getOrdersMap().get(1).getCars(),carDto);
    }

    @Test
    void deleteOrderNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.deleteOrder(1,main);
        Assertions.assertFalse(main.getOrdersMap().containsKey(1));
    }


    @Test
    void processOrderNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.closeOrder(1,main);
        Assertions.assertNotEquals(orderIn.processOrder(1, main),"Заказ принят в работу");
    }
    @Test
    void processOrder2No() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        Assertions.assertNotEquals(orderIn.processOrder(1, main),"Заказ уже закрыт");
    }

    @Test
    void closeOrderNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        Assertions.assertNotEquals(orderIn.closeOrder(1, main),"Заказ уже закрыт ранее");
    }
    @Test
    void closeOrder1No() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        orderIn.newOrder(personDto,carDto,main);
        orderIn.closeOrder(1, main);
        Assertions.assertNotEquals(main.getOrdersMap().get(1).getOrderStatus().getStatus(),"NotProcessed");
    }
    @Test
    void newOrderServiceNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        Assertions.assertNotEquals(orderIn.newOrderService(carDto,problem,main,personDto), "");
    }
    @Test
    void newOrderService1No() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        Assertions.assertNotEquals(main.getServiceMap().size(),0);
    }
    @Test
    void processOrderServiceNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        Assertions.assertNotEquals(orderIn.processOrderService(1, main),"");
    }
    @Test
    void closeOrderServiceNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        orderIn.closeOrderService(1, main);
        Assertions.assertNotEquals(orderIn.closeOrderService(1, main),"Заказ закрыт");
    }
    @Test
    void deleteOrderServiceNo() {
        OrderIn orderIn=new OrderIn();
        DataBase main = new DataBase();
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,main,personDto);
        orderIn.deleteOrderService(3,main);
        Assertions.assertTrue(main.getServiceMap().containsKey(1));
    }

}