package org.example.console.in;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import org.example.dto.ServiceDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import org.example.dto.enums.OrderStatus;
import org.example.repo.Impl.OrdersRepoImpl;
import org.example.repo.Impl.ServiceRepoImpl;
import org.example.repo.OrdersRepo;
import org.example.repo.ServiceRepo;

import java.util.Comparator;
import java.util.Map;

public class OrderIn {
    OrdersRepo ordersRepo=new OrdersRepoImpl();
    ServiceRepo serviceRepo=new ServiceRepoImpl();
    public String newOrder(PersonDto client, CarDto carDto, DataBase main){
        if (!carDto.getCarStatus().getStatus().equals("free")){
            return "Машина не продаётся";
        } else {
        OrderDto order = new OrderDto();
        order.setPerson(client);
        order.setCars(carDto);
        order.setOrderStatus(OrderStatus.NotProcessed);
        order.setOrderData(java.time.LocalDate.now());
        if (!main.getOrdersMap().isEmpty()){
        int number = main.getOrdersMap().keySet().stream().max(Comparator.naturalOrder()).get()+1;
        order.setOrderNumber(number);
        ordersRepo.createOrder(order,main);}
        else {
            order.setOrderNumber(1);
            ordersRepo.createOrder(order,main);}
        carDto.setCarStatus(CarStatus.sold);
return "Заказ создан";}
    }
    public String updateOrder(Integer number , CarDto carDto, DataBase main) {
        if (main.getOrdersMap().containsKey(number)){
        OrderDto orderDto = main.getOrdersMap().get(number);
        main.getOrdersMap().get(number).getCars().setCarStatus(CarStatus.free);
        orderDto.setCars(carDto);
       ordersRepo.update(orderDto,main);
        return "Изменения внесены";}
        return "";
    }
    public String deleteOrder(Integer number, DataBase main) {
        if (main.getOrdersMap().containsKey(number)){
            main.getOrdersMap().get(number).getCars().setCarStatus(CarStatus.free);
            ordersRepo.delete(number,main);
        return "Заказ удален из базы";}
        return "";
    }

    public String processOrder(int number, DataBase main) {
        String result= main.getOrdersMap().get(number).getOrderStatus().getStatus().equals("Processed")?"Заказ уже в работе"
                :main.getOrdersMap().get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт"
                :"Заказ принят в работу";
        if(main.getOrdersMap().get(number).getOrderStatus().getStatus().equals("NotProcessed")){
            OrderDto orderDto=new OrderDto();
            orderDto=main.getOrdersMap().get(number);
            orderDto.setOrderStatus(OrderStatus.Processed);
            ordersRepo.update(orderDto,main);
        }

        return result;
    }

    public String closeOrder(int number, DataBase main) {
        String result= main.getOrdersMap().get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт ранее"
                :"Заказ закрыт";
        if(main.getOrdersMap().get(number).getOrderStatus().getStatus().equals("NotProcessed")||main.getOrdersMap().get(number).getOrderStatus().getStatus().equals("Processed")){
            OrderDto orderDto=new OrderDto();
            orderDto=main.getOrdersMap().get(number);
            orderDto.setOrderStatus(OrderStatus.Closed);
            ordersRepo.update(orderDto,main);
        }
        return result;
    }

    public String newOrderService(CarDto carDto, String problem, DataBase main, PersonDto client) {
        ServiceDto service= new ServiceDto();
        carDto.setCondition(CarCondition.UsedCar);
        carDto.setCarStatus(CarStatus.forService);
        service.setOrderStatus(OrderStatus.NotProcessed);
        service.setPerson(client);
        service.setCars(carDto);
        service.setProblem(problem);
        if (!main.getServiceMap().isEmpty()){
            int number = main.getServiceMap().keySet().stream().max(Comparator.naturalOrder()).get()+1;
            service.setOrderNumber(number);
           serviceRepo.createOrder(service,main);}
        else {
            service.setOrderNumber(1);
            serviceRepo.createOrder(service,main);}
        System.out.println("Заказ создан");
        return "Заказ создан";
        }

    public String processOrderService(int number, DataBase main) {
        String result= main.getServiceMap().get(number).getOrderStatus().getStatus().equals("Processed")?"Заказ уже в работе"
                :main.getServiceMap().get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт"
                :"Заказ принят в работу";
        if(main.getServiceMap().get(number).getOrderStatus().getStatus().equals("NotProcessed")){
            ServiceDto serviceDto=new ServiceDto();
            serviceDto=main.getServiceMap().get(number);
            serviceDto.setOrderStatus(OrderStatus.Processed);
            serviceRepo.update(serviceDto,main);
        }

        return result;
    }

    public String closeOrderService(int number,DataBase main) {
        String result= main.getServiceMap().get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт ранее"
                :"Заказ закрыт";
        if(main.getServiceMap().get(number).getOrderStatus().getStatus().equals("NotProcessed")||main.getServiceMap().get(number).getOrderStatus().getStatus().equals("Processed")){
            ServiceDto serviceDto=new ServiceDto();
            serviceDto=main.getServiceMap().get(number);
            serviceDto.setOrderStatus(OrderStatus.Closed);
            serviceRepo.update(serviceDto,main);
        }
        return result;
    }

    public String deleteOrderService(int number, DataBase main) {
        if (main.getServiceMap().containsKey(number)){
            main.getServiceMap().get(number).getCars().setCarStatus(CarStatus.free);
            serviceRepo.delete(number,main);
            return "Заказ удален из базы";}
        return "";
    }

}
