package org.example.console.in;

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
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        //Assertions.assertEquals(orderIn.newOrder(personDto,carDto,ordersMap),"Заказ создан");
    }
    @Test
    void newOrderEquals1() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        //orderIn.newOrder(personDto,carDto,ordersMap);
        Assertions.assertEquals(ordersMap.size(),1);
    }
    @Test
    void newOrderEquals2() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        //orderIn.newOrder(personDto,carDto,ordersMap);
        CarDto carDto1=new CarDto("Audi","Q7",2012, 155.0, CarCondition.NewCar, CarStatus.free);
        //orderIn.newOrder(personDto,carDto1,ordersMap);
        Assertions.assertEquals(ordersMap.get(2).getCars(),carDto1);
    }

    @Test
    void updateOrder() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
       OrderDto orderDto=new OrderDto();
       orderDto.setCars(carDto);
       orderDto.setOrderNumber(1);
       orderDto.setPerson(personDto);
       orderDto.setOrderStatus(OrderStatus.NotProcessed);
        ordersMap.put(1,orderDto);
        OrderIn orderIn=new OrderIn();
        //orderIn.updateOrder(1,carDto1,ordersMap);
        Assertions.assertEquals(ordersMap.get(1).getCars(),carDto1);
    }

    @Test
    void deleteOrder() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderDto orderDto=new OrderDto();
        orderDto.setCars(carDto);
        orderDto.setOrderNumber(1);
        orderDto.setPerson(personDto);
        orderDto.setOrderStatus(OrderStatus.NotProcessed);
        ordersMap.put(1,orderDto);
        OrderIn orderIn=new OrderIn();
       // orderIn.deleteOrder(1,ordersMap);
        Assertions.assertFalse(ordersMap.containsKey(1));
    }


    @Test
    void processOrder() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderDto orderDto=new OrderDto();
        orderDto.setCars(carDto);
        orderDto.setOrderNumber(1);
        orderDto.setPerson(personDto);
        orderDto.setOrderStatus(OrderStatus.NotProcessed);
        ordersMap.put(1,orderDto);
        OrderIn orderIn=new OrderIn();
        //Assertions.assertEquals(orderIn.processOrder(1, ordersMap),"Заказ принят в работу");
    }
    @Test
    void processOrder2() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderDto orderDto=new OrderDto();
        orderDto.setCars(carDto);
        orderDto.setOrderNumber(1);
        orderDto.setPerson(personDto);
        orderDto.setOrderStatus(OrderStatus.Closed);
        ordersMap.put(1,orderDto);
        OrderIn orderIn=new OrderIn();
       // Assertions.assertEquals(orderIn.processOrder(1, ordersMap),"Заказ уже закрыт");
    }

    @Test
    void closeOrder() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderDto orderDto=new OrderDto();
        orderDto.setCars(carDto);
        orderDto.setOrderNumber(1);
        orderDto.setPerson(personDto);
        orderDto.setOrderStatus(OrderStatus.Closed);
        ordersMap.put(1,orderDto);
        OrderIn orderIn=new OrderIn();
        Assertions.assertEquals(orderIn.closeOrder(1, ordersMap),"Заказ уже закрыт ранее");
    }
    @Test
    void closeOrder1() {
        Map<Integer, OrderDto> ordersMap=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto.setNumber(1);
        CarDto carDto1=new CarDto("Audi","Q5",2005, 55.0, CarCondition.NewCar, CarStatus.free);
        carDto1.setNumber(2);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderDto orderDto=new OrderDto();
        orderDto.setCars(carDto);
        orderDto.setOrderNumber(1);
        orderDto.setPerson(personDto);
        orderDto.setOrderStatus(OrderStatus.Processed);
        ordersMap.put(1,orderDto);
        OrderIn orderIn=new OrderIn();
        orderIn.closeOrder(1, ordersMap);
        Assertions.assertEquals(orderDto.getOrderStatus().getStatus(),"Closed");
    }
    @Test
     void newOrderService() {
        Map<Integer, ServiceDto> serviceDto=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        String problem = "Что-то там";
        Assertions.assertEquals(orderIn.newOrderService(carDto,problem,serviceDto,personDto), "Заказ создан");
    }
    @Test
    void newOrderService1() {
        Map<Integer, ServiceDto> serviceDto=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        String problem = "Что-то там";
        orderIn.newOrderService(carDto,problem,serviceDto,personDto);
        Assertions.assertEquals(serviceDto.size(),1);
    }
    @Test
    void processOrderService() {
        Map<Integer, ServiceDto> service=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        String problem = "Что-то там";
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setProblem(problem);
        serviceDto.setOrderStatus(OrderStatus.NotProcessed);
        serviceDto.setOrderNumber(1);
        serviceDto.setCars(carDto);
        serviceDto.setPerson(personDto);
        service.put(1,serviceDto);
        Assertions.assertEquals(orderIn.processOrderService(1, service),"Заказ принят в работу");
    }
    @Test
    void closeOrderService() {
        Map<Integer, ServiceDto> service=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        String problem = "Что-то там";
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setProblem(problem);
        serviceDto.setOrderStatus(OrderStatus.NotProcessed);
        serviceDto.setOrderNumber(1);
        serviceDto.setCars(carDto);
        serviceDto.setPerson(personDto);
        service.put(1,serviceDto);
        Assertions.assertEquals(orderIn.closeOrderService(1, service),"Заказ закрыт");
    }
    @Test
    void deleteOrderService() {
        Map<Integer, ServiceDto> service=new TreeMap<>();;
        CarDto carDto=new CarDto("Audi","Q8",2005);
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        OrderIn orderIn=new OrderIn();
        String problem = "Что-то там";
        ServiceDto serviceDto = new ServiceDto();
        serviceDto.setProblem(problem);
        serviceDto.setOrderStatus(OrderStatus.NotProcessed);
        serviceDto.setOrderNumber(1);
        serviceDto.setCars(carDto);
        serviceDto.setPerson(personDto);
        service.put(1,serviceDto);
        orderIn.deleteOrderService(1,service);
        Assertions.assertFalse(service.containsKey(1));
    }

}