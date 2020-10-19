package facades;

import dto.PersonDTO;
import dto.PersonsDTO;
import entities.Person;
import exceptions.MissingInputException;
import exceptions.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PersonFacade implements IPersonFacade {

    private static PersonFacade instance;
    private static EntityManagerFactory emf;
    
    private final String realCode = "kodeordet";
    
    private PersonFacade() {
    }

    /**
     *
     * @param _emf
     * @return an instance of this facade class.
     */
    public static PersonFacade getPersonFacade(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new PersonFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    @Override
    public PersonsDTO getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p", Person.class);
            PersonsDTO all = new PersonsDTO(q.getResultList());
            System.out.println(all);
            return all;
        } finally {
            em.close();
        }
    }

    @Override
    public PersonDTO addPerson(String name, String code) throws MissingInputException {
        
        EntityManager em = getEntityManager();
        Person person = null;
        if(name.isEmpty()){
            throw new MissingInputException("Name empty");
        }
        
        if(!code.equals(realCode)){
            throw new MissingInputException("Not the right code");
        }
        try{
            person = new Person(name,code);
            
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            
            
        }finally {
            em.close();
        }
        
        
        return new PersonDTO(person);
    }
    
    @Override
    public PersonDTO deletePerson(int id) throws PersonNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO getPerson(int id) throws PersonNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public PersonDTO editPerson(PersonDTO p) throws PersonNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
