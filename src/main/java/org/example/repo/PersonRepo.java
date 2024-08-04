package org.example.repo;

import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.PersonDto;

import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public interface PersonRepo {
    void createPerson(PersonDto personDto, DataBase main);
    void delete(String login, DataBase main);
    void update(PersonDto personDto, DataBase main);
    Map<String, PersonDto> addAll(DataBase main);
    Optional<PersonDto> addNumber(String login, DataBase main);
}
