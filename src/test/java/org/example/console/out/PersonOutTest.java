package org.example.console.out;

import org.example.console.in.PersonIn;
import org.example.db.DataBase;
import org.example.dto.PersonDto;
import org.example.dto.enums.RoleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

import static org.junit.jupiter.api.Assertions.*;

class PersonOutTest {

    @Test
    void getAllClients() {
        PersonIn personIn=new PersonIn();
        PersonOut personOut=new PersonOut();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Manager,"333");
        personIn.add(personDto1,main);
        Map<String,PersonDto> result =new TreeMap<>();
        result.put("navi",personDto);
        Assertions.assertEquals(personOut.getAllClients(main),result);
    }

    @Test
    void getAllEmployee() {
        PersonIn personIn=new PersonIn();
        PersonOut personOut=new PersonOut();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Manager,"333");
        personIn.add(personDto1,main);
        Map<String,PersonDto> result =new TreeMap<>();
        result.put("333",personDto1);
        Assertions.assertEquals(personOut.getAllEmployee(main),result);
    }

    @Test
    void getPersonForLogin() {
        PersonIn personIn=new PersonIn();
        PersonOut personOut=new PersonOut();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Client,"333");
        personIn.add(personDto1,main);
        Assertions.assertTrue(personOut.getPersonForLogin("navi",main));
    }
    @Test
    void getAllClientsNo() {
        PersonIn personIn=new PersonIn();
        PersonOut personOut=new PersonOut();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Manager,"333");
        personIn.add(personDto1,main);
        Map<String,PersonDto> result =new TreeMap<>();
        result.put("333",personDto1);
        result.put("navi",personDto);
        Assertions.assertNotEquals(personOut.getAllClients(main),result);
    }

    @Test
    void getAllEmployeeNo() {
        PersonIn personIn=new PersonIn();
        PersonOut personOut=new PersonOut();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Manager,"333");
        personIn.add(personDto1,main);
        Map<String,PersonDto> result =new TreeMap<>();
        result.put("navi",personDto);
        Assertions.assertNotEquals(personOut.getAllEmployee(main),result);
    }

    @Test
    void getPersonForLoginNo() {
        PersonIn personIn=new PersonIn();
        PersonOut personOut=new PersonOut();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Client,"333");
        personIn.add(personDto1,main);
        Assertions.assertFalse(personOut.getPersonForLogin("nai",main));
    }
}