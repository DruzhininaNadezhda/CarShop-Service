package org.example.db;

import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import org.example.dto.ServiceDto;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class DataBase {
    private HashMap<String, PersonDto> personsMap;
    private TreeMap<Integer, CarDto> cars;
    private TreeMap<Integer, OrderDto> ordersMap;
    private TreeMap<Integer, ServiceDto> serviceMap;
    public DataBase() {
        personsMap = new HashMap<>();
        cars = new TreeMap<>();
        ordersMap = new TreeMap<>();
        serviceMap= new TreeMap<>();
    }
    public Map<String, PersonDto> getPersonsMap() {
        return personsMap;
    }

    public void setPersonsMap(HashMap<String, PersonDto> personsMap) {
        this.personsMap = personsMap;
    }

    public TreeMap<Integer, CarDto> getCars() {
        return cars;
    }

    public void setCars(TreeMap<Integer, CarDto> cars) {
        this.cars = cars;
    }

    public TreeMap<Integer, OrderDto> getOrdersMap() {
        return ordersMap;
    }

    public void setOrdersMap(TreeMap<Integer, OrderDto> ordersMap) {
        this.ordersMap = ordersMap;
    }

    public TreeMap<Integer, ServiceDto> getServiceMap() {
        return serviceMap;
    }

    public void setServiceMap(TreeMap<Integer, ServiceDto> serviceMap) {
        this.serviceMap = serviceMap;
    }
}
