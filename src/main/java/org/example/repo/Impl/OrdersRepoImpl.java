package org.example.repo.Impl;

import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.repo.OrdersRepo;

import java.util.Optional;
import java.util.TreeMap;

public class OrdersRepoImpl implements OrdersRepo {

    @Override
    public void createOrder(OrderDto orderDto, DataBase main) {
        main.getOrdersMap().put(orderDto.getOrderNumber(),orderDto);
    }

    @Override
    public void delete(int number, DataBase main) {
        main.getOrdersMap().remove(number);
    }

    @Override
    public void update(OrderDto orderDto, DataBase main) {
        main.getOrdersMap().put(orderDto.getOrderNumber(),orderDto);
    }

    @Override
    public TreeMap<Integer, OrderDto> addAll(DataBase main) {
        return main.getOrdersMap();
    }

    @Override
    public Optional<OrderDto> addNumber(int number, DataBase main) {
        return Optional.ofNullable(main.getOrdersMap().get(number));
    }
}

