package org.example.service;

import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import java.util.List;

public interface Orders {
    public OrderDto addNewOrder(CarDto car, PersonDto person);
    public List<OrderDto> findAll();
    public OrderDto updateOrder(OrderDto orderDto);
    public boolean deleteOrder (OrderDto orderDto);
    public List<OrderDto> filterOrder (String filter);
}
