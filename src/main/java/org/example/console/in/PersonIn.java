package org.example.console.in;
import org.example.db.DataBase;
import org.example.dto.PersonDto;
import org.example.dto.enums.RoleUser;
import org.example.repo.Impl.PersonRepoImpl;
import org.example.repo.PersonRepo;

import java.util.Map;
public class PersonIn {
    PersonRepo personRepo=new PersonRepoImpl();
    /**
     * Adds a person to the collection if the login is unique.
     * If the login is not unique, does not change the collection.
     * @param personDto Person object, divided by roles based on the "role" field.
     * @param main Database object
     * @return String with the result of checking the uniqueness of the login
     */
    public String add(PersonDto personDto, DataBase main){
        if (main.getPersonsMap().containsKey(personDto.getLogin())){
            return "Такой логин уже существует";
        }
        main.getPersonsMap().put(personDto.getLogin(),personDto);
        return "Контрагент создан";
    }
    /**
     * If login and password do not match, returns the authorization menu
     * @param login String
     * @param password String
     * @param main Object database
     * @return Object person
     */
    public PersonDto authorization(String login, String password, DataBase main){
        for(Map.Entry<String,PersonDto> entry:main.getPersonsMap().entrySet()){
            if (entry.getValue().getLogin().equals(login) && entry.getValue().getPassword().equals(password)){
                System.out.println("Вы вошли в систему");
                return entry.getValue();
            }
        }
        System.out.println("Проверьте данные");
        return null;
    }

    /**
     * Making changes to the person object, key - login
     *
     * @param personDto Object person
     * @param main      Object database
     */
    public void updatePerson(PersonDto personDto, DataBase main) {
        if (personRepo.addNumber(personDto.getLogin(),main).isPresent()){
            personRepo.update(personDto,main);
            System.out.println("Корректировки внесены");
        }System.out.println("Логин не верный");
    }

    /**
     * Deletes a person if the login exists
     * @param login person
     * @param main Object database
     */
    public void deletePerson(String login, DataBase main) {
        if (personRepo.addNumber(login,main).isPresent()){
       personRepo.delete(login,main);
        System.out.println("Контрагент удален из базы");
        }System.out.println("Логин не верный");
    }

    /**
     * Changing user role
     * For administrator only
     * @param login person
     * @param main Object database
     * @param role person new
     */
    public void updatePersonRole(String login, DataBase main, String role) {
        if (personRepo.addNumber(login,main).isPresent()){
        PersonDto personDto=new PersonDto();
        personDto=personRepo.addNumber(login,main).get();
        personDto.setRoleUser(RoleUser.getRoleUser(role));
        personRepo.update(personDto,main);
        System.out.println("Роль изменена");
        }System.out.println("Логин не верный");
    }
}
