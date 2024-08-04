package org.example.views;

import org.example.console.in.CarIn;
import org.example.console.in.OrderIn;
import org.example.console.in.PersonIn;
import org.example.console.out.CarOut;
import org.example.console.out.OrderOut;
import org.example.console.out.PersonOut;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.PersonDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;

import java.util.Scanner;

public class ManagerMenu {
    public void managerMenu(DataBase main, PersonDto user) {
        OrderOut orderOut = new OrderOut();
        OrderIn orderIn = new OrderIn();
        CarOut carOut = new CarOut();
        CarIn carIn = new CarIn();
        Scanner sc = new Scanner(System.in);
        NewAuto newAuto = new NewAuto();
        Authorization authorization = new Authorization();
        while (true) {
            System.out.println("1. Список всех заказов");
            System.out.println("2. Список автомобилей");
            System.out.println("3. Добавить автомобиль");
            System.out.println("4. Изменить данные о автомобиле");
            System.out.println("5. Удалить данные о автомобиле");
            System.out.println("6. Обработка заказов на покупку");
            System.out.println("7. Обработка заявок на сервис");
            System.out.println("8. Выход");
            int choice = sc.nextInt();
            sc.nextLine();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 7 && choice != 6 && choice != 8) {
                System.out.print("выбери корректный номер :  ");
                choice = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    orderOut.getAllOrders(main.getOrdersMap());
                    break;
                case 2:
                    carOut.getAllCars(main.getCars());
                    break;
                case 8:
                    authorization.authorization(main);
                    break;
                case 3:
                    newAuto.newAuto(main,user);
                    break;
                case 4:
                    System.out.print("Номер по каталогу :");
                    int number = sc.nextInt();
                    sc.nextLine();
                    if (carOut.getForNumber(number, main)) {
                        System.out.println("Машина " + main.getCars().get(number));
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
                        double price = sc.nextDouble();
                        CarDto carDto1 = new CarDto(brand, model, Integer.parseInt(year), price, CarCondition.getCondition(conditionCar), CarStatus.free);
                        carIn.updateCar(number, carDto1, main);
                        System.out.println("Изменения внесены");
                    }
                    break;
                case 5:
                    System.out.print("Номер по каталогу :");
                    number = sc.nextInt();
                    sc.nextLine();
                    if (carOut.getForNumber(number, main)) {
                        System.out.println("Машина " + main.getCars().get(number) + " удалена");
                        carIn.deleteCar(number, main);
                    }
                    break;
                case 6:
                    System.out.print("Номер заказа :");
                    number = sc.nextInt();
                    sc.nextLine();
                    if (orderOut.getForNumber(number, main.getOrdersMap())) {
                        System.out.println("1. Принять в работу заказ " + number);
                        System.out.println("2. Закрыть заказ (успешная продажа) " + number);
                        System.out.println("3. Отменить заказ " + number);
                        choice = sc.nextInt();
                        sc.nextLine();
                        while (choice != 1 && choice != 2 && choice != 3) {
                            System.out.print("выбери корректный номер :  ");
                            choice = sc.nextInt();
                            System.out.println(choice == 1 ? orderIn.processOrder(number, main) :
                                    choice == 2 ? orderIn.closeOrder(number, main) :
                                            orderIn.deleteOrder(number, main));
                        }
                    }
                    break;
                case 7:
                    System.out.println("Заказы на сервис :");
                    orderOut.getAllOrdersService(main.getServiceMap());
                    System.out.print("Номер заказа :");
                    number = sc.nextInt();
                    sc.nextLine();
                    if (orderOut.getOrdersServiceOfNumber(main.getServiceMap(), number)) {
                        System.out.println("1. Принять в работу заявку " + number);
                        System.out.println("2. Закрыть заявку (ремонт) " + number);
                        System.out.println("3. Отменить заказ " + number);
                        choice = sc.nextInt();
                        sc.nextLine();
                        while (choice != 1 && choice != 2 && choice != 3) {
                            System.out.print("выбери корректный номер :  ");
                            choice = sc.nextInt();
                        }

                        System.out.println(choice == 1 ? orderIn.processOrderService(number, main) :
                                choice == 2 ? orderIn.closeOrderService(number, main) :
                                        orderIn.deleteOrderService(number, main));
                    }
                    break;
            }
        }
    }
}
