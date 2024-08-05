package org.example.console.out;
import org.example.db.DataBase;
import org.example.dto.PersonDto;
import org.example.repo.Impl.PersonRepoImpl;
import org.example.repo.PersonRepo;

import java.util.Map;
import java.util.TreeMap;

public class PersonOut {
    /**
     * @return  all persons with the role "Client"
     * @param  main Database object
     *
     */
    public Map<String, PersonDto> getAllClients(DataBase main) {
        Map<String, PersonDto> client=new TreeMap<>();
        if (!main.getPersonsMap().isEmpty()) {
            for (Map.Entry<String, PersonDto> person : main.getPersonsMap().entrySet()) {
                if (person.getValue().getRoleUser().getRoleUser().equals("Client")) {
                    client.put(person.getKey(),person.getValue());
                    System.out.println(person);
                }
            }
        }
        return client;
    }

    /**
     *@return  all persons with the role "Employee"
     *@param  main Database object where personsMap  key is the login string
     */
    public Map<String, PersonDto> getAllEmployee(DataBase main) {
        Map<String, PersonDto> employee=new TreeMap<>();
        if (!main.getPersonsMap().isEmpty()) {
            for (Map.Entry<String, PersonDto> person : main.getPersonsMap().entrySet()) {
                if (person.getValue().getRoleUser().getRoleUser().equals("Manager")||person.getValue().getRoleUser().getRoleUser().equals("Admin")) {
                    employee.put(person.getKey(),person.getValue());
                    System.out.println(person);
                }
            }
        }
        return employee;
    }

    /**
     * @param login person
     * @param main Database object where personsMap  key is the login string
     * @return true if a person with such a login exists
     */
    public boolean getPersonForLogin(String login, DataBase main) {
        return main.getPersonsMap().containsKey(login);
    }
}
