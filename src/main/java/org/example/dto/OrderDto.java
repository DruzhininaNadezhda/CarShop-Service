package org.example.dto;
import org.example.dto.enums.OrderStatus;
import java.time.LocalDate;
import java.util.Objects;

public class OrderDto {
    private int orderNumber;
    private LocalDate orderData;
    private CarDto car;
    private PersonDto person;
    private OrderStatus orderStatus;
    public OrderDto(){};
    public OrderDto(int orderNumber, LocalDate orderData, CarDto car, PersonDto person, OrderStatus orderStatus) {
        this.orderNumber = orderNumber;
        this.orderData = orderData;
        this.car = car;
        this.person = person;
        this.orderStatus = orderStatus;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public LocalDate getOrderData() {
        return orderData;
    }

    public void setOrderData(LocalDate orderData) {
        this.orderData = orderData;
    }

    public CarDto getCars() {
        return car;
    }

    public void setCars(CarDto car) {
        this.car = car;
    }

    public PersonDto getPerson() {
        return person;
    }

    public void setPerson(PersonDto person) {
        this.person = person;
    }

    public OrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof OrderDto orderDto)) return false;
        return orderNumber == orderDto.orderNumber && Objects.equals(orderData, orderDto.orderData) && Objects.equals(car, orderDto.car) && Objects.equals(person, orderDto.person) && Objects.equals(orderStatus.getStatus(), orderDto.orderStatus.getStatus());
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderNumber, orderData, car, person, orderStatus);
    }

    @Override
    public String toString() {
        return "OrderDto{" +
                "orderNumber=" + orderNumber +
                ", orderData=" + orderData +
                ", cars=" + car +
                ", person=" + person +
                ", orderStatus=" + orderStatus.getStatus() +
                '}';
    }
}