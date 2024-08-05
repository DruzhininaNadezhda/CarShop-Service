package org.example.views;

import org.example.console.in.PersonIn;
import org.example.db.DataBase;
import org.example.dto.PersonDto;
import org.example.dto.enums.RoleUser;

import java.util.Scanner;

/**
 * registration of all users
 */
public class Registration {
    public void registration(DataBase main) {
        PersonIn personIn = new PersonIn();
        Authorization authorization= new Authorization();
        Scanner sc = new Scanner(System.in);
        System.out.print("Фамилия : ");
        String surname = sc.nextLine();
        System.out.print("Name : ");
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
        PersonDto personDto = new PersonDto(surname, name, password, RoleUser.getRoleUser(roleUser), login);
        System.out.println(personIn.add(personDto, main));
       authorization.authorization(main);
    }
}
