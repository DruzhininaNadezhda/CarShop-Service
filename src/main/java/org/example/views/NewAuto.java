package org.example.views;

import org.example.console.in.CarIn;
import org.example.console.in.OrderIn;
import org.example.console.out.CarOut;
import org.example.console.out.OrderOut;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.PersonDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;

import java.util.Scanner;

public class NewAuto {
    public void newAuto(DataBase main, PersonDto user) {
        CarIn carIn = new CarIn();
        ManagerMenu managerMenu = new ManagerMenu();
        Scanner sc = new Scanner(System.in);
        System.out.print("Марка :");
        String brand = sc.nextLine();
        System.out.print("Модель : ");
        String model = sc.nextLine();
        System.out.print("Год : ");
        String year = sc.nextLine();
        while (!year.matches("19[3-9][0-9]") && !year.matches("20[0-9][0-9]")) {
            System.out.print("введите год производства верно  ");
            year = sc.nextLine();
        }
        System.out.print("состояние :  ");
        System.out.println("\n1. Новое");
        System.out.println("2. БУ");
        int condition = sc.nextInt();
        while (condition != 1 && condition != 2) {
            System.out.print("выбери корректный номер :  ");
            condition = sc.nextInt();
        }
        String conditionCar = condition == 1 ? "NewCar" : "UsedCar";
        System.out.print("Цена : ");
        Double price = sc.nextDouble();
        CarDto carDto = new CarDto(brand, model, Integer.parseInt(year), price, CarCondition.getCondition(conditionCar), CarStatus.free);
        carIn.addCar(carDto, main);
        managerMenu.managerMenu(main,user);
    }
}
