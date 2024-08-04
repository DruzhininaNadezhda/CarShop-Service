package org.example.views;

import org.example.console.in.OrderIn;
import org.example.console.out.CarOut;
import org.example.console.out.OrderOut;
import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.PersonDto;

import java.util.Scanner;

public class ClientMenu {
    public void clientMenu(DataBase main, PersonDto user) {
        Scanner sc = new Scanner(System.in);
        OrderOut orderOut = new OrderOut();
        OrderIn orderIn = new OrderIn();
        CarOut carOut = new CarOut();
        Authorization authorization = new Authorization();
        while (true) {
            System.out.println("1. Список заказов");
            System.out.println("2. Список автомобилей");
            System.out.println("3. Поиск по автомобилям");
            System.out.println("4. Новый заказ");
            System.out.println("5. Изменить заказ");
            System.out.println("6. Удалить заказ");
            System.out.println("7. Обслуживание авто");
            System.out.println("8. Выход");
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6 && choice != 7 && choice != 8) {
                System.out.print("выбери корректный номер :  ");
                choice = sc.nextInt();
            }
            switch (choice) {
                case 1:
                    System.out.println(orderOut.getPersonOrders(user, main.getOrdersMap()));
                    break;
                case 2:
                    carOut.getFreeCars(main.getCars());
                    break;
                case 3:
                    System.out.print("Что искать? ");
                    sc.nextInt();
                    String filter = sc.nextLine();
                    carOut.filterCar(filter, main.getCars());
                    break;
                case 8:
                    authorization.authorization(main);
                    break;
                case 4:
                    System.out.print("Номер машины из каталога : ");
                    int numberCar = sc.nextInt();
                    if (carOut.getForNumber(numberCar, main)) {
                        orderIn.newOrder(user, main.getCars().get(numberCar), main);
                    }
                    break;
                case 5:
                    System.out.print("Номер заказа : ");
                    int numberOrder = sc.nextInt();
                    if (orderOut.getForNumber(numberOrder, main.getOrdersMap(), user)) {
                        System.out.print("\nИзменения в заказе " + main.getCars().get(numberOrder));
                        System.out.print("Номер машины из каталога : ");
                        numberCar = sc.nextInt();
                        if (carOut.getForNumber(numberCar, main)) {
                            orderIn.updateOrder(numberOrder, main.getCars().get(numberCar), main);
                        }
                    }
                    break;
                case 6:
                    System.out.print("Номер заказа : ");
                    numberOrder = sc.nextInt();
                    if (orderOut.getForNumber(numberOrder, main.getOrdersMap(), user)) {
                        orderIn.deleteOrder(numberOrder, main);
                        System.out.println("Заказ удален");
                    }
                    break;
                case 7:
                    sc.nextLine();
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
                    System.out.print("Опишите проблему : ");
                    String problem = sc.nextLine();
                    CarDto carDto = new CarDto(brand, model, Integer.parseInt(year));
                    orderIn.newOrderService(carDto, problem, main, user);
                    break;
            }
        }
    }
}
