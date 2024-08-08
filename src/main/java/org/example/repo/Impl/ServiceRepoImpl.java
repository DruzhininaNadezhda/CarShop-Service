package org.example.repo.Impl;

import org.example.db.DataBase;
import org.example.dto.ServiceDto;
import org.example.repo.ServiceRepo;

import java.util.Optional;
import java.util.TreeMap;

public class ServiceRepoImpl implements ServiceRepo {

    @Override
    public void createOrder(ServiceDto serviceDto, DataBase main) {
        main.getServiceMap().put(serviceDto.getOrderNumber(),serviceDto);
    }

    @Override
    public void delete(int number, DataBase main) {
        main.getServiceMap().remove(number);
    }

    @Override
    public void update(ServiceDto serviceDto, DataBase main) {
        main.getServiceMap().put(serviceDto.getOrderNumber(),serviceDto);
    }

    @Override
    public TreeMap<Integer, ServiceDto> addAll(DataBase main) {
        return main.getServiceMap();
    }

    @Override
    public Optional<ServiceDto> addNumber(int number, DataBase main) {
        return Optional.ofNullable(main.getServiceMap().get(number));
    }
}
