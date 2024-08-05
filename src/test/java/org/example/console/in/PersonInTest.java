package org.example.console.in;

import org.example.db.DataBase;
import org.example.dto.CarDto;
import org.example.dto.PersonDto;
import org.example.dto.enums.RoleUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonInTest {

    @Test
    void add() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        Assertions.assertEquals(main.getPersonsMap().size(),1);
    }

    @Test
    void authorization() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        Assertions.assertEquals(personIn.authorization(personDto.getLogin(),personDto.getPassword(),main),personDto);
    }

    @Test
    void updatePerson() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Client,"navi");
        personIn.updatePerson(personDto1,main);
        Assertions.assertEquals(main.getPersonsMap().get("navi"),personDto1);
    }

    @Test
    void deletePerson() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        personIn.deletePerson("navi",main);
        Assertions.assertEquals(main.getPersonsMap().size(),0);
    }

    @Test
    void updatePersonRole() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        personIn.updatePersonRole("navi",main,"Manager");
        Assertions.assertEquals(main.getPersonsMap().get("navi").getRoleUser().getRoleUser(),"Manager");
    }
    @Test
    void addNo() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        Assertions.assertNotEquals(main.getPersonsMap().size(),0);
    }

    @Test
    void authorizationNo() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        Assertions.assertNotEquals(personIn.authorization("kkkk",personDto.getPassword(),main),personDto);
    }

    @Test
    void updatePersonNo() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        PersonDto personDto1=new PersonDto("Ivanov","Ivan","222", RoleUser.Client,"ni");
        personIn.updatePerson(personDto1,main);
        Assertions.assertNotEquals(main.getPersonsMap().get("navi"),personDto1);
    }

    @Test
    void deletePersonNo() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        personIn.deletePerson("n",main);
        Assertions.assertNotEquals(main.getPersonsMap().size(),0);
    }

    @Test
    void updatePersonRoleNo() {
        PersonIn personIn=new PersonIn();
        DataBase main = new DataBase();
        PersonDto personDto=new PersonDto("Ivanov","Neivan","222", RoleUser.Client,"navi");
        personIn.add(personDto,main);
        personIn.updatePersonRole("navi",main,"Manager");
        Assertions.assertNotEquals(main.getPersonsMap().get("navi").getRoleUser().getRoleUser(),"Client");
    }
}