package org.example.console.in;
import org.example.db.DataBase;
import org.example.dto.PersonDto;
import org.example.dto.enums.RoleUser;
import org.example.repo.Impl.PersonRepoImpl;
import org.example.repo.PersonRepo;

import java.util.Map;
public class PersonIn {
    PersonRepo personRepo=new PersonRepoImpl();
    public String add(PersonDto personDto, Map<String,PersonDto> persons){
        if (persons.containsKey(personDto.getLogin())){
            return "Такой логин уже существует";
        }
        persons.put(personDto.getLogin(),personDto);
        return "Контрагент создан";
    }
    public PersonDto authorization(String surname, String password, DataBase main){
        for(Map.Entry<String,PersonDto> entry:main.getPersonsMap().entrySet()){
            if (entry.getValue().getSurname().equals(surname) && entry.getValue().getPassword().equals(password)){
                System.out.println("Вы вошли в систему");
                return entry.getValue();
            }
        }
        System.out.println("Проверьте данные");
        return null;
    }
    public String updatePerson(PersonDto personDto, DataBase main) {
        personRepo.update(personDto,main);
        return "Изменения внесены";
    }
    public String deletePerson(String login, DataBase main) {
       personRepo.delete(login,main);
        return "Контрагент удален из базы";
    }

    public void updatePersonRole(String login, DataBase main, String role) {
        PersonDto personDto=new PersonDto();
        personDto=personRepo.addNumber(login,main).get();
        personDto.setRoleUser(RoleUser.getRoleUser(role));
        personRepo.update(personDto,main);
        System.out.println("Роль изменена");
    }
}
