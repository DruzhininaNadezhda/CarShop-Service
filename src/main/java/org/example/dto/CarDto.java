package org.example.dto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import java.util.Objects;

public class CarDto {
    private Integer number;
    private String brand;
    private String model;
    private int yearOfCarProduction;
    private double carPrice;
    private CarCondition condition;
    private CarStatus carStatus;
    public CarDto(){};
    public CarDto(String brand, String model, int yearOfCarProduction) {
        this.brand = brand;
        this.model = model;
        this.yearOfCarProduction = yearOfCarProduction;
    }

    public CarDto(String brand, String model, int yearOfCarProduction, double carPrice, CarCondition condition, CarStatus carStatus) {
        this(brand,model,yearOfCarProduction);
        this.carPrice = carPrice;
        this.condition = condition;
        this.carStatus = carStatus;
    }
    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYearOfCarProduction() {
        return yearOfCarProduction;
    }

    public void setYearOfCarProduction(int yearOfCarProduction) {
        this.yearOfCarProduction = yearOfCarProduction;
    }

    public double getCarPrice() {
        return carPrice;
    }

    public void setCarPrice(double carPrice) {
        this.carPrice = carPrice;
    }

    public CarCondition getCondition() {
        return condition;
    }

    public void setCondition(CarCondition condition) {
        this.condition = condition;
    }

    public CarStatus getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(CarStatus carStatus) {
        this.carStatus = carStatus;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CarDto carDto)) return false;
        return yearOfCarProduction == carDto.yearOfCarProduction && Double.compare(carPrice, carDto.carPrice) == 0 && Objects.equals(number, carDto.number) && Objects.equals(brand, carDto.brand) && Objects.equals(model, carDto.model) && condition == carDto.condition && carStatus == carDto.carStatus;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, brand, model, yearOfCarProduction, carPrice, condition, carStatus);
    }

    @Override
    public String toString() {
        return "CarDto{" +number+
                " brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", yearOfCarProduction=" + yearOfCarProduction +
                ", carPrice=" + carPrice +
                ", condition=" + condition.getCondition2() +
                ", carStatus=" + carStatus.getStatus() +
                '}';
    }
}
