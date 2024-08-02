package org.example.console.in;
import org.example.dto.PersonDto;
import org.example.dto.enums.RoleUser;
import java.util.Map;
public class PersonIn {
    public String add(PersonDto personDto, Map<String,PersonDto> persons){
        if (persons.containsKey(personDto.getLogin())){
            return "Такой логин уже существует";
        }
        persons.put(personDto.getLogin(),personDto);
        return "Контрагент создан";
    }
    public PersonDto authorization(String surname,String password, Map<String,PersonDto> persons){
        for(Map.Entry<String,PersonDto> entry:persons.entrySet()){
            if (entry.getValue().getSurname().equals(surname) && entry.getValue().getPassword().equals(password)){
                System.out.println("Вы вошли в систему");
                return entry.getValue();
            }
        }
        System.out.println("Проверьте данные");
        return null;
    }
    public String updatePerson(PersonDto personDto, Map<String, PersonDto> persons) {
        persons.put(personDto.getLogin(), personDto);
        return "Изменения внесены";
    }
    public String deletePerson(String login, Map<String, PersonDto> persons) {
        persons.remove(login);
        return "Контрагент удален из базы";
    }

    public void updatePersonRole(String login, Map<String, PersonDto> personsMap, String role) {
        personsMap.get(login).setRoleUser(RoleUser.getRoleUser(role));
        System.out.println("Роль изменена");
    }
}
