package org.example.repo;

import org.example.db.DataBase;
import org.example.dto.OrderDto;

import java.util.Optional;
import java.util.TreeMap;

public interface OrdersRepo {
    void createOrder(OrderDto orderDto, DataBase main);
    void delete(int number, DataBase main);
    void update(OrderDto orderDto, DataBase main);
    TreeMap<Integer, OrderDto> addAll(DataBase main);
    Optional<OrderDto> addNumber(int number, DataBase main);
}
