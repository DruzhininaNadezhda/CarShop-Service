package org.example.views;

import org.example.console.in.PersonIn;
import org.example.db.DataBase;
import org.example.dto.PersonDto;

import java.util.Scanner;

/**
 * Authorization for all users
 */
public class Authorization {
    /**
     * @param main DataBase object
     */
    public void authorization(DataBase main) {
        Registration registration= new Registration();
        PersonIn personIn = new PersonIn();
        ClientMenu clientMenu = new ClientMenu();
        ManagerMenu managerMenu = new ManagerMenu();
        AdminMenu adminMenu = new AdminMenu();
        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("1. Регистрация");
            System.out.println("2. Авторизация");
            System.out.print("Напишите номер действия : ");
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2) {
                System.out.print("выбери корректный номер :  ");
                choice = sc.nextInt();
            }
            sc.nextLine();
            switch (choice) {
                case 1:
                    registration.registration(main);
                    break;
                case 2:
                    System.out.print("Логин : ");
                    String login = sc.nextLine();
                    System.out.print("Пароль : ");
                    String password = sc.nextLine();
                    PersonDto user = personIn.authorization(login, password, main);
                    if (user != null) {
                        while (true) {
                            switch (user.getRoleUser().getRoleUser()) {
                                case "Client":
                                    clientMenu.clientMenu(main,user);
                                    break;
                                case "Manager":
                                    managerMenu.managerMenu(main,user);
                                    break;
                                case "Admin":
                                    adminMenu.adminMenu(main,user);
                                    break;
                            }
                        }
                    }
            }
        }
    }
}
