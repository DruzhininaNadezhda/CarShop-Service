package org.example.console.in;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import org.example.dto.ServiceDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import org.example.dto.enums.OrderStatus;
import java.util.Comparator;
import java.util.Map;

public class OrderIn {
    public String newOrder(PersonDto client, CarDto carDto, Map<Integer,OrderDto> orders){
        OrderDto order = new OrderDto();
        order.setPerson(client);
        order.setCars(carDto);
        order.setOrderStatus(OrderStatus.NotProcessed);
        order.setOrderData(java.time.LocalDate.now());
        if (!orders.isEmpty()){
        int number = orders.keySet().stream().max(Comparator.naturalOrder()).get()+1;
        order.setOrderNumber(number);
        orders.put(number,order);}
        else {orders.put(1,order);}
return "Заказ создан";
    }
    public String updateOrder(Integer number , CarDto carDto, Map<Integer,OrderDto> orders) {
        if (orders.containsKey(number)){
        OrderDto orderDto = orders.get(number);
        orders.get(number).getCars().setCarStatus(CarStatus.free);
        orderDto.setCars(carDto);
        orders.put(number, orderDto);
        return "Изменения внесены";}
        return "";
    }
    public String deleteOrder(Integer number, Map<Integer,OrderDto> orders) {
        if (orders.containsKey(number)){
        orders.get(number).getCars().setCarStatus(CarStatus.free);
        orders.remove(number);
        return "Заказ удален из базы";}
        return "";
    }

    public String processOrder(int number, Map<Integer, OrderDto> ordersMap) {
        String result= ordersMap.get(number).getOrderStatus().getStatus().equals("Processed")?"Заказ уже в работе"
                :ordersMap.get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт"
                :"Заказ принят в работу";
        if(ordersMap.get(number).getOrderStatus().getStatus().equals("NotProcessed")){
            ordersMap.get(number).setOrderStatus(OrderStatus.Processed);
        }

        return result;
    }

    public String closeOrder(int number, Map<Integer, OrderDto> ordersMap) {
        String result= ordersMap.get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт ранее"
                :"Заказ закрыт";
        if(ordersMap.get(number).getOrderStatus().getStatus().equals("NotProcessed")||ordersMap.get(number).getOrderStatus().getStatus().equals("Processed")){
            ordersMap.get(number).setOrderStatus(OrderStatus.Closed);
        }
        return result;
    }

    public String newOrderService(CarDto carDto, String problem, Map<Integer, ServiceDto> serviceMap, PersonDto client) {
        ServiceDto service= new ServiceDto();
        carDto.setCondition(CarCondition.UsedCar);
        carDto.setCarStatus(CarStatus.forService);
        service.setOrderStatus(OrderStatus.NotProcessed);
        service.setPerson(client);
        service.setCars(carDto);
        service.setProblem(problem);
        if (!serviceMap.isEmpty()){
            int number = serviceMap.keySet().stream().max(Comparator.naturalOrder()).get()+1;
            serviceMap.put(number,service);}
        else {serviceMap.put(1,service);}
        System.out.println("Заказ создан");
        return "Заказ создан";
        }

    public String processOrderService(int number, Map<Integer, ServiceDto> serviceMap) {
        String result= serviceMap.get(number).getOrderStatus().getStatus().equals("Processed")?"Заказ уже в работе"
                :serviceMap.get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт"
                :"Заказ принят в работу";
        if(serviceMap.get(number).getOrderStatus().getStatus().equals("NotProcessed")){
            serviceMap.get(number).setOrderStatus(OrderStatus.Processed);
        }

        return result;
    }

    public String closeOrderService(int number, Map<Integer, ServiceDto> serviceMap) {
        String result= serviceMap.get(number).getOrderStatus().getStatus().equals("Closed")?"Заказ уже закрыт ранее"
                :"Заказ закрыт";
        if(serviceMap.get(number).getOrderStatus().getStatus().equals("NotProcessed")||serviceMap.get(number).getOrderStatus().getStatus().equals("Processed")){
            serviceMap.get(number).setOrderStatus(OrderStatus.Closed);
        }
        return result;
    }

    public String deleteOrderService(int number, Map<Integer, ServiceDto> serviceMap) {
        if (serviceMap.containsKey(number)){
            serviceMap.get(number).getCars().setCarStatus(CarStatus.free);
            serviceMap.remove(number);
            return "Заказ удален из базы";}
        return "";
    }

}
