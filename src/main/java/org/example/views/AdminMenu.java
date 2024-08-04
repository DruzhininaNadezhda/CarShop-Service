package org.example.views;

import org.example.console.in.PersonIn;
import org.example.console.out.PersonOut;
import org.example.db.DataBase;
import org.example.dto.PersonDto;

import java.util.Scanner;

public class AdminMenu {
    public void adminMenu(DataBase main, PersonDto user) {
        Scanner sc = new Scanner(System.in);
        PersonIn personIn = new PersonIn();
        PersonOut personOut = new PersonOut();
        Authorization authorization = new Authorization();
        while (true) {
            System.out.println("1. Просмотр всех клиентов");
            System.out.println("2. Просмотр всех сотрудников");
            System.out.println("3. Внести изменения в карточку клиента/сотрудника");
            System.out.println("4. Выход");
            int choice = sc.nextInt();
            while (choice != 1 && choice != 2 && choice != 3 && choice != 4) {
                System.out.print("выбери корректный номер :  ");
                choice = sc.nextInt();
            }
            sc.nextLine();
            switch (choice) {
                case 4:
                    authorization.authorization(main);
                    break;
                case 1:
                    personOut.getAllClients(main.getPersonsMap());
                    break;
                case 2:
                    personOut.getAllEmployee(main.getPersonsMap());
                    break;
                case 3:
                    System.out.println("Введите логин : ");
                    String login = sc.nextLine();
                    if (personOut.getPersonForLogin(login, main.getPersonsMap())) {
                        System.out.println("1. Изменить роль " + main.getPersonsMap().get(login));
                        System.out.println("2. Изменить данные " + main.getPersonsMap().get(login));
                        System.out.println("3. Удалить данные " + main.getPersonsMap().get(login));
                        choice = sc.nextInt();
                        while (choice != 1 && choice != 2 && choice != 3) {
                            System.out.print("выбери корректный номер :  ");
                            choice = sc.nextInt();
                        }
                        sc.nextLine();
                        switch (choice) {
                            case 1:
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
                                personIn.updatePersonRole(login, main, roleUser);
                                break;
                            case 2:
                                personIn.updatePerson(main.getPersonsMap().get(login), main);
                                break;
                            case 3:
                                personIn.deletePerson(login, main);
                                break;
                        }
                    }
            }
        }
    }
}
