/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Person;
import java.time.LocalDateTime;
import java.util.Date;

/**
 *
 * @author gamma
 */
public class PersonDTO {

    private String personName;
    private int id;
    private String created;
    private String passcode;

    public PersonDTO(Person person) {
        this.personName = person.getName();
        this.created = person.getCreated();
        this.id = person.getId();
        this.passcode = person.getCode();
    }

    public String getName() {
        return personName;
    }

    public void setName(String name) {
        this.personName = name;
    }

    public int getId() {
        return id;
    }

    public void setCode(String code) {
        this.passcode = code;
    }

    public String getCode() {
        return passcode;
    }

    public String getCreated() {
        return created;
    }

}
