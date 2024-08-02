package org.example.dto;

import org.example.dto.enums.OrderStatus;

import java.time.LocalDate;
import java.util.Objects;

public class ServiceDto extends OrderDto{
    private String problem;
    public ServiceDto(){}
    public ServiceDto(int orderNumber, LocalDate orderData, CarDto car, PersonDto person, OrderStatus orderStatus, String problem) {
        super(orderNumber, orderData, car, person, orderStatus);
        this.problem=problem;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ServiceDto that)) return false;
        if (!super.equals(o)) return false;
        return Objects.equals(problem, that.problem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), problem);
    }

    @Override
    public String toString() {
        return super.toString()+
                "problem='" + problem + '\'' +
                '}';
    }
}
