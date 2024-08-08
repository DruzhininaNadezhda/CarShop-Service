package org.example.repo.Impl;

import org.example.db.DataBase;
import org.example.dto.PersonDto;
import org.example.repo.PersonRepo;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class PersonRepoImpl implements PersonRepo {
    @Override
    public void createPerson(PersonDto personDto, DataBase main) {
        main.getPersonsMap().put(personDto.getLogin(),personDto);
    }

    @Override
    public void delete(String login, DataBase main) {
        main.getPersonsMap().remove(login);
    }

    @Override
    public void update(PersonDto personDto, DataBase main) {
        main.getPersonsMap().put(personDto.getLogin(),personDto);
    }

    @Override
    public Map<String, PersonDto> addAll(DataBase main) {
        return main.getPersonsMap();
    }

    @Override
    public Optional<PersonDto> addNumber(String login, DataBase main) {
        return Optional.ofNullable(main.getPersonsMap().get(login));
    }
}
