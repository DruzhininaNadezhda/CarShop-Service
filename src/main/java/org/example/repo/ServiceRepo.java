package org.example.repo;

import org.example.db.DataBase;
import org.example.dto.OrderDto;
import org.example.dto.ServiceDto;

import java.util.Optional;
import java.util.TreeMap;

public interface ServiceRepo {
    void createOrder(ServiceDto serviceDto, DataBase main);
    void delete(int number, DataBase main);
    void update(ServiceDto serviceDto, DataBase main);
    TreeMap<Integer, ServiceDto> addAll(DataBase main);
    Optional<ServiceDto> addNumber(int number, DataBase main);
}
