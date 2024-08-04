package org.example.console.out;
import org.example.dto.PersonDto;
import org.example.repo.Impl.PersonRepoImpl;
import org.example.repo.PersonRepo;

import java.util.Map;

public class PersonOut {
    public void getAllClients(Map<String, PersonDto> personsMap) {
        if (!personsMap.isEmpty()) {
            for (Map.Entry<String, PersonDto> person : personsMap.entrySet()) {
                if (person.getValue().getRoleUser().getRoleUser().equals("Client")) {
                    System.out.println(person);
                }
            }
        }
    }

    public void getAllEmployee(Map<String, PersonDto> personsMap) {
        if (!personsMap.isEmpty()) {
            for (Map.Entry<String, PersonDto> person : personsMap.entrySet()) {
                if (person.getValue().getRoleUser().getRoleUser().equals("Manager")||person.getValue().getRoleUser().getRoleUser().equals("Admin")) {
                    System.out.println(person);
                }
            }
        }
    }

    public boolean getPersonForLogin(String login, Map<String, PersonDto> personsMap) {
        return personsMap.containsKey(login);
    }
}
