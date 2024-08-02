package org.example.dto;
import org.example.dto.enums.RoleUser;
import java.util.Objects;
public class PersonDto {
    private String surname;
    private String name;
    private String login;
    private String password;
    private RoleUser roleUser;
    public PersonDto(){};

    public PersonDto(String surname, String name, String password, RoleUser roleUser, String login) {
        this.surname = surname;
        this.name = name;
        this.password = password;
        this.roleUser = roleUser;
        this.login = login;

    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public RoleUser getRoleUser() {
        return roleUser;
    }

    public void setRoleUser(RoleUser roleUser) {
        this.roleUser = roleUser;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PersonDto personDto)) return false;
        return Objects.equals(surname, personDto.surname) && Objects.equals(name, personDto.name) && Objects.equals(login, personDto.login) && Objects.equals(password, personDto.password) && roleUser == personDto.roleUser;
    }

    @Override
    public int hashCode() {
        return Objects.hash(surname, name, login, password, roleUser);
    }

    @Override
    public String toString() {
        return "PersonDto{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", roleUser=" + roleUser.getRoleUser() +
                '}';
    }
}
