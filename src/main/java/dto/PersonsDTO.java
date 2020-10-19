package dto;

import entities.Person;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author gamma
 */
public class PersonsDTO {
    List<PersonDTO> all = new ArrayList();;
    
    public PersonsDTO(List<Person> personList) {

        personList.forEach(p -> {
            all.add(new PersonDTO(p));
        });
    }

    public List<PersonDTO> getAll() {
        return all;
    }
    public int size() {
        return all.size();
    }
    
    public PersonDTO get(int index) {
        return all.get(index);
    }

    @Override
    public String toString() {
        String liste ="";
        
        for (PersonDTO personDTO : all) {
            liste += personDTO.getName()+ " " + personDTO.getCreated() ;
        }
        
        return liste;
    }
    
    
}
