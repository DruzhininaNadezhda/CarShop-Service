package org.example.console.out;
import org.example.db.DataBase;
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

    /**
     * @param user object person - client
     * @param main Database object
     * @return Orders from one customer
     */
    public List<OrderDto> getPersonOrders(PersonDto user,  DataBase main) {
        List<OrderDto> result = new ArrayList<>();
        for (Map.Entry<Integer, OrderDto> entry : main.getOrdersMap().entrySet()) {
            if (entry.getValue().getPerson().getLogin().equals(user.getLogin())) {
                result.add(entry.getValue());
            }
        }
        return result;
    }


    /**
     * @param main Database object
     * @return All orders
     */
    public Map<Integer, OrderDto>  getAllOrders(DataBase main) {
        for (Integer number : main.getOrdersMap().keySet()) {
            System.out.println("Номер заказа: " + number + " " + main.getOrdersMap().get(number));
        }
        return main.getOrdersMap();
    }

    /**
     * @param numberOrder int
     * @param main Database object
     * @param user object person - client
     * @return True, if a specific client has such an order
     */
    public boolean getForNumber(int numberOrder, DataBase main, PersonDto user) {
        if (user != null) {
            if (!main.getOrdersMap().containsKey(numberOrder) && !main.getOrdersMap().get(numberOrder).getPerson().getLogin().equals(user.getLogin())) {
                System.out.println("Номер заказа не верный");
                return false;
            } else {
                return true;
            }
        }else {
            if (!main.getOrdersMap().containsKey(numberOrder)){
                System.out.println("Номер заказа не верный");
                return false;
            } else {return true;}
        }
    }
    /**
     * For managers
     * @param numberOrder int
     * @param main Database object
     * @return True, if such an order exists
     */
    public boolean getForNumber(int numberOrder, DataBase main) {
            if (!main.getOrdersMap().containsKey(numberOrder)){
                System.out.println("Номер заказа неверный");
                return false;
            } else {return true;}
        }
    /**
     * @param main Database object
     * @return All service orders
     */
    public Map<Integer, ServiceDto>  getAllOrdersService(DataBase main) {
        if (!main.getServiceMap().isEmpty()){
            for (Map.Entry<Integer, ServiceDto> entry: main.getServiceMap().entrySet()){
                System.out.println(entry);
            }
        } else {
        System.out.println("Нет заявок");}
        return main.getServiceMap();
    }
    /**
     * For managers
     * @param number int
     * @param main Database object
     * @return True, if such a service order exists
     */
    public boolean getOrdersServiceOfNumber(DataBase main,Integer number) {
        if (!main.getServiceMap().isEmpty()){
            if (main.getServiceMap().containsKey(number)){
                System.out.println("Заказ :" + main.getServiceMap().get(number));
                return true;
            }
        } else {
            System.out.println("Неправильный номер заказа");}
        return false;
    }

    /**
     * Filtering by all fields with search for matching string.
     * Case is not important
     * @param filter search parameters
     * @param main Database object
     * @return filtered orders
     */
    public Map<Integer, OrderDto> filterOrder(String filter, DataBase main) {
        Map<Integer, OrderDto> filterOrders=new TreeMap<>();
        if (!main.getOrdersMap().isEmpty()) {
            for (Map.Entry<Integer, OrderDto> entry : main.getOrdersMap().entrySet()) {
                String result = entry.getValue().toString().toLowerCase();
                if (result.matches(".*"+ filter.toLowerCase()+"*.")) {
                    filterOrders.put(entry.getKey(),entry.getValue());
                    System.out.println(entry);
                }
            }
        }
        return filterOrders;
    }
    /**
     * Filtering by all fields with search for matching string.
     * Case is not important
     * @param filter search parameters
     * @param main Database object
     * @return filtered service orders
     */
    public Map<Integer, ServiceDto> filterOrderService(String filter, DataBase main) {
        Map<Integer, ServiceDto> filterOrders=new TreeMap<>();
        if (!main.getServiceMap().isEmpty()) {
            for (Map.Entry<Integer, ServiceDto> entry : main.getServiceMap().entrySet()) {
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

