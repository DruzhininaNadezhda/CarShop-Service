package org.example.console.out;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import org.example.dto.ServiceDto;
import org.example.repo.Impl.OrdersRepoImpl;
import org.example.repo.OrdersRepo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class OrderOut {
    OrdersRepo ordersRepo=new OrdersRepoImpl();

    public List<OrderDto> getPersonOrders(PersonDto user, Map<Integer, OrderDto> orders) {
        List<OrderDto> result = new ArrayList<>();
        for (Map.Entry<Integer, OrderDto> entry : orders.entrySet()) {
            if (entry.getValue().getPerson().getLogin().equals(user.getLogin())) {
                result.add(entry.getValue());
            }
        }
        return result;
    }

    public void getAllOrders(Map<Integer, OrderDto> orders) {
        for (Integer number : orders.keySet()) {
            System.out.println("Номер заказа: " + number + " " + orders.get(number));
        }
    }

    public boolean getForNumber(int numberOrder, Map<Integer, OrderDto> orders, PersonDto user) {
        if (user != null) {
            if (!orders.containsKey(numberOrder) && !orders.get(numberOrder).getPerson().getLogin().equals(user.getLogin())) {
                System.out.println("Номер заказа неверный");
                return false;
            } else {
                return true;
            }
        }else {
            if (!orders.containsKey(numberOrder)){
                System.out.println("Номер заказа неверный");
                return false;
            } else {return true;}
        }
    }
    public boolean getForNumber(int numberOrder, Map<Integer, OrderDto> orders) {
            if (!orders.containsKey(numberOrder)){
                System.out.println("Номер заказа неверный");
                return false;
            } else {return true;}
        }

    public void getAllOrdersService(Map<Integer, ServiceDto> serviceMap) {
        if (!serviceMap.isEmpty()){
            for (Map.Entry<Integer, ServiceDto> entry: serviceMap.entrySet()){
                System.out.println(entry);
            }
        } else {
        System.out.println("Нет заявок");}
    }
    public boolean getOrdersServiceOfNumber(Map<Integer, ServiceDto> serviceMap,Integer number) {
        if (!serviceMap.isEmpty()){
            if (serviceMap.containsKey(number)){
                System.out.println("Заказ :" + serviceMap.get(number));
                return true;
            }
        } else {
            System.out.println("Неправильный номер заказа");}
        return false;
    }
    public Map<Integer, OrderDto> filterOrder(String filter, Map<Integer, OrderDto> orders) {
        Map<Integer, OrderDto> filterOrders=new TreeMap<>();
        if (!orders.isEmpty()) {
            for (Map.Entry<Integer, OrderDto> entry : orders.entrySet()) {
                String result = entry.getValue().toString().toLowerCase();
                if (result.matches(filter.toLowerCase())) {
                    filterOrders.put(entry.getKey(),entry.getValue());
                    System.out.println(entry);
                }
            }
        }
        return filterOrders;
    }
    public Map<Integer, ServiceDto> filterOrderService(String filter, Map<Integer, ServiceDto> ordersServer) {
        Map<Integer, ServiceDto> filterOrders=new TreeMap<>();
        if (!ordersServer.isEmpty()) {
            for (Map.Entry<Integer, ServiceDto> entry : ordersServer.entrySet()) {
                String result = entry.getValue().toString().toLowerCase();
                if (result.matches(filter.toLowerCase())) {
                    filterOrders.put(entry.getKey(),entry.getValue());
                    System.out.println(entry);
                }
            }
        }
        return filterOrders;
    }
}

