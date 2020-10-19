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

    private String name;
    private int id;
    private String created;
    private String code;

    public PersonDTO(Person person) {
        this.name = person.getName();
        this.created = person.getCreated();
        this.id = person.getId();
        this.code = person.getCode();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public String getCreated() {
        return created;
    }

}
