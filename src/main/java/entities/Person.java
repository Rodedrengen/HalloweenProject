package entities;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


//Does not work

@Entity
@NamedQuery(name = "Person.deleteFrom", query = "DELETE from Person")
public class Person implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String personName;
    private String passcode;
    
    private String created;
    
    
    public Person() {
    }
    
    public Person(String name, String code,String created) {
        this.personName = name;
        this.passcode = code;
        
        if(created.isEmpty()){
//            LocalDateTime currentDateTime = LocalDateTime.now();
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
//            this.created = currentDateTime.format(formatter);
            
//            Instant instant = Instant.now();
//            DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy")
//            .withZone(ZoneId.systemDefault());
//            this.created = DATE_TIME_FORMATTER.format(instant);
            
            DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss dd-MM-yyyy");
            ZonedDateTime zdt = ZonedDateTime.now(ZoneId.of("CET"));
            this.created = zdt.format(DATE_TIME_FORMATTER);
        }else{
            this.created = created;
        }
        
    }

    public void setCode(String code) {
        this.passcode = code;
    }

    public String getCode() {
        return passcode;
    }
    
    public String getName() {
        return personName;
    }

    public void setName(String name) {
        this.personName = name;
    }
    
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCreated() {
        return created;
    }
}
