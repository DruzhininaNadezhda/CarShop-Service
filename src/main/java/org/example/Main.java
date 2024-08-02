package org.example;

import org.example.console.in.CarIn;
import org.example.console.in.OrderIn;
import org.example.console.in.PersonIn;
import org.example.console.out.CarOut;
import org.example.console.out.OrderOut;
import org.example.console.out.PersonOut;
import org.example.dto.CarDto;
import org.example.dto.OrderDto;
import org.example.dto.PersonDto;
import org.example.dto.ServiceDto;
import org.example.dto.enums.CarCondition;
import org.example.dto.enums.CarStatus;
import org.example.dto.enums.RoleUser;
import java.util.*;

public class Main {
    Map<String, PersonDto> personsMap;
    Map<Integer, CarDto> cars;
    Map<Integer, OrderDto> ordersMap;
    Map<Integer, ServiceDto> serviceMap;

    Main() {
        personsMap = new HashMap<>();
        cars = new TreeMap<>();
        ordersMap = new TreeMap<>();
        serviceMap= new TreeMap<>();
    }

    public static void main(String[] args) {
        PersonIn personIn = new PersonIn();
        PersonOut personOut = new PersonOut();
        OrderOut orderOut = new OrderOut();
        OrderIn orderIn = new OrderIn();
        CarOut carOut = new CarOut();
        CarIn carIn = new CarIn();
        Scanner sc = new Scanner(System.in);
        Main main = new Main();
        int choice;
        while (true) {
            System.out.println("1. Регистрация");
            System.out.println("2. Авторизация");
            System.out.print("Напишите номер действия : ");
            choice = sc.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.print("выбери корректный номер :  ");
                choice = sc.nextInt();
            }
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.print("Фамилия : ");
                    String surname = sc.nextLine();
                    System.out.print("Имя : ");
                    String name = sc.nextLine();
                    System.out.print("Логин : ");
                    String login = sc.nextLine();
                    System.out.print("Пароль : ");
                    String password = sc.nextLine();
                    System.out.print("роль (напиши соответствующий номер) :  ");
                    System.out.println("\n1. Администратор");
                    System.out.println("2. Менеджер");
                    System.out.println("3. Клиент");
                    int role = sc.nextInt();
                    while (role != 1 && role != 2 && role != 3) {
                        System.out.print("роль (выбери корректный номер) :  ");
                        role = sc.nextInt();
                    }
                    String roleUser = role == 1 ? "Admin" : role == 2 ? "Manager" : "Client";
                    PersonDto personDto = new PersonDto(surname, name, password, RoleUser.getRoleUser(roleUser),login);
                    System.out.println(personIn.add(personDto, main.personsMap));
                    break;
                case 2:
                    System.out.print("Логин : ");
                    login = sc.nextLine();
                    System.out.print("Пароль : ");
                    password = sc.nextLine();
                    PersonDto user = personIn.authorization(login, password, main.personsMap);
                    if (user != null) {
                        boolean client = true;
                        while (client) {
                            switch (user.getRoleUser().getRoleUser()) {
                                case "Client":
                                    System.out.println("1. Список заказов");
                                    System.out.println("2. Список автомобилей");
                                    System.out.println("3. Поиск по автомобилям");
                                    System.out.println("4. Новый заказ");
                                    System.out.println("5. Изменить заказ");
                                    System.out.println("6. Удалить заказ");
                                    System.out.println("7. Обслуживание авто");
                                    System.out.println("8. Выход");
                                    choice = sc.nextInt();
                                    while (choice != 1 && choice != 2 && choice != 3 && choice != 4&& choice != 5&& choice != 6 && choice != 7 && choice !=8) {
                                        System.out.print("выбери корректный номер :  ");
                                        choice = sc.nextInt();
                                    }
                                    switch (choice) {
                                        case 1:
                                            System.out.println(orderOut.getPersonOrders(user, main.ordersMap));
                                            break;
                                        case 2:
                                            carOut.getFreeCars(main.cars);
                                            break;
                                        case 3:
                                            System.out.print("Что искать? ");
                                            sc.nextInt();
                                            String filter = sc.nextLine();
                                            carOut.filterCar(filter,main.cars);
                                            break;
                                        case 8:
                                            client = false;
                                            break;
                                        case 4:
                                            System.out.print("Номер машины из каталога : ");
                                            int numberCar = sc.nextInt();
                                            if (carOut.getForNumber(numberCar, main.cars)) {
                                                orderIn.newOrder(user, main.cars.get(numberCar), main.ordersMap);
                                            }
                                            break;
                                        case 5:
                                            System.out.print("Номер заказа : ");
                                            int numberOrder = sc.nextInt();
                                            if (orderOut.getForNumber(numberOrder, main.ordersMap,user)) {
                                                System.out.print("\nИзменения в заказе " + main.cars.get(numberOrder));
                                                System.out.print("Номер машины из каталога : ");
                                                numberCar = sc.nextInt();
                                                if (carOut.getForNumber(numberCar, main.cars)) {
                                                    orderIn.updateOrder(numberOrder, main.cars.get(numberCar), main.ordersMap);
                                                }
                                            }
                                            break;
                                        case 6:
                                            System.out.print("Номер заказа : ");
                                             numberOrder = sc.nextInt();
                                            if (orderOut.getForNumber(numberOrder, main.ordersMap,user)) {
                                                    orderIn.deleteOrder(numberOrder, main.ordersMap);
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
                                            orderIn.newOrderService(carDto, problem, main.serviceMap,main.personsMap.get(login));
                                            break;
                                    }
                                    break;
                                case "Manager":
                                    System.out.println("1. Список всех заказов");
                                    System.out.println("2. Список автомобилей");
                                    System.out.println("3. Добавить автомобиль");
                                    System.out.println("4. Изменить данные о автомобиле");
                                    System.out.println("5. Удалить данные о автомобиле");
                                    System.out.println("6. Обработка заказов на покупку");
                                    System.out.println("7. Обработка заявок на сервис");
                                    System.out.println("8. Выход");
                                    choice = sc.nextInt();
                                    sc.nextLine();
                                    while (choice != 1 && choice != 2 && choice != 3 && choice != 4&& choice != 5&& choice != 7&& choice != 6 && choice != 8) {
                                        System.out.print("выбери корректный номер :  ");
                                        choice = sc.nextInt();
                                    }
                                    switch (choice) {
                                        case 1:
                                            orderOut.getAllOrders(main.ordersMap);
                                            break;
                                        case 2:
                                            carOut.getAllCars(main.cars);
                                            break;
                                        case 8:
                                            client = false;
                                            break;
                                        case 3:
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
                                            carIn.addCar(carDto, main.cars);
                                            break;
                                        case 4:
                                            System.out.print("Номер по каталогу :");
                                            int number = sc.nextInt();
                                            sc.nextLine();
                                            if (carOut.getForNumber(number,main.cars)){
                                                System.out.println("Машина " +main.cars.get(number));
                                                System.out.print("Марка :");
                                                 brand = sc.nextLine();
                                                System.out.print("Модель : ");
                                                 model = sc.nextLine();
                                                System.out.print("Год : ");
                                                 year = sc.nextLine();
                                                while (!year.matches("19[3-9][0-9]") && !year.matches("20[0-9][0-9]")) {
                                                    System.out.print("введите год производства верно  ");
                                                    year = sc.nextLine();
                                                }
                                                System.out.print("состояние :  ");
                                                System.out.println("\n1. Новое");
                                                System.out.println("2. БУ");
                                                 condition = sc.nextInt();
                                                while (condition != 1 && condition != 2) {
                                                    System.out.print("выбери корректный номер :  ");
                                                    condition = sc.nextInt();
                                                }
                                                 conditionCar = condition == 1 ? "NewCar" : "UsedCar";
                                                System.out.print("Цена : ");
                                                 price = sc.nextDouble();
                                                CarDto carDto1 = new CarDto(brand, model, Integer.parseInt(year), price, CarCondition.getCondition(conditionCar), CarStatus.free);
                                                carIn.updateCar(number,carDto1, main.cars);
                                                System.out.println("Изменения внесены");
                                            }
                                            break;
                                        case 5:
                                            System.out.print("Номер по каталогу :");
                                             number = sc.nextInt();
                                            sc.nextLine();
                                            if (carOut.getForNumber(number,main.cars)){
                                                System.out.println("Машина " +main.cars.get(number)+" удалена");
                                                carIn.deleteCar(number,main.cars);
                                            }
                                            break;
                                        case 6:
                                            System.out.print("Номер заказа :");
                                            number = sc.nextInt();
                                            sc.nextLine();
                                            if (orderOut.getForNumber(number,main.ordersMap)){
                                                System.out.println("1. Принять в работу заказ " + number);
                                                System.out.println("2. Закрыть заказ (успешная продажа) " + number);
                                                System.out.println("3. Отменить заказ " + number);
                                                choice = sc.nextInt();
                                                sc.nextLine();
                                                while (choice != 1 && choice != 2 && choice != 3) {
                                                    System.out.print("выбери корректный номер :  ");
                                                    choice = sc.nextInt();
                                                    System.out.println( choice==1?orderIn.processOrder(number,main.ordersMap):
                                                            choice==2?orderIn.closeOrder(number,main.ordersMap):
                                                            orderIn.deleteOrder(number,main.ordersMap));
                                                }
                                            }break;
                                        case 7:
                                            System.out.println("Заказы на сервис :");
                                            orderOut.getAllOrdersService(main.serviceMap);
                                            System.out.print("Номер заказа :");
                                            number = sc.nextInt();
                                            sc.nextLine();
                                            if (orderOut.getOrdersServiceOfNumber(main.serviceMap,number)){
                                                System.out.println("1. Принять в работу заявку " + number);
                                                System.out.println("2. Закрыть заявку (ремонт) " + number);
                                                System.out.println("3. Отменить заказ " + number);
                                                choice = sc.nextInt();
                                                sc.nextLine();
                                                while (choice != 1 && choice != 2 && choice != 3) {
                                                    System.out.print("выбери корректный номер :  ");
                                                    choice = sc.nextInt();}

                                                    System.out.println( choice==1?orderIn.processOrderService(number,main.serviceMap):
                                                            choice==2?orderIn.closeOrderService(number,main.serviceMap):
                                                                    orderIn.deleteOrderService(number,main.serviceMap));
                                            }break;
                                    }break;
                                case "Admin":
                                        System.out.println("1. Просмотр всех клиентов");
                                        System.out.println("2. Просмотр всех сотрудников");
                                        System.out.println("3. Внести изменения в карточку клиента/сотрудника");
                                        System.out.println("4. Выход");
                                        choice = sc.nextInt();
                                        while (choice != 1 && choice != 2&& choice != 3 && choice != 4) {
                                            System.out.print("выбери корректный номер :  ");
                                            choice = sc.nextInt();
                                        }
                                        sc.nextLine();
                                        switch (choice) {
                                            case 4:
                                                client = false;
                                                break;
                                            case 1:
                                                personOut.getAllClients(main.personsMap);
                                                break;
                                            case 2:
                                                personOut.getAllEmployee(main.personsMap);
                                                break;
                                            case 3:
                                                System.out.println("Введите логин : ");
                                                login = sc.nextLine();
                                                if(personOut.getPersonForLogin(login, main.personsMap)){
                                                    System.out.println("1. Изменить роль " + main.personsMap.get(login));
                                                    System.out.println("2. Изменить данные "+ main.personsMap.get(login));
                                                    System.out.println("3. Удалить данные "+ main.personsMap.get(login));
                                                    choice = sc.nextInt();
                                                    while (choice != 1 && choice != 2&& choice != 3) {
                                                        System.out.print("выбери корректный номер :  ");
                                                        choice = sc.nextInt();
                                                    }
                                                    sc.nextLine();
                                                    switch (choice){
                                                        case 1:
                                                            System.out.print("роль (напиши соответствующий номер) :  ");
                                                            System.out.println("\n1. Администратор");
                                                            System.out.println("2. Менеджер");
                                                            System.out.println("3. Клиент");
                                                             role = sc.nextInt();
                                                            while (role != 1 && role != 2 && role != 3) {
                                                                System.out.print("роль (выбери корректный номер) :  ");
                                                                role = sc.nextInt();
                                                            }
                                                             roleUser = role == 1 ? "Admin" : role == 2 ? "Manager" : "Client";
                                                            personIn.updatePersonRole(login, main.personsMap, roleUser);
                                                            break;
                                                        case 2:
                                                            personIn.updatePerson(main.personsMap.get(login), main.personsMap);
                                                            break;
                                                        case 3:
                                                            personIn.deletePerson(login, main.personsMap);
                                                            break;
                                                    }
                                                }
                                                break;

                                        }

                            }
                        }
                    }
            }
        }
    }
}