package facades;

import dto.PersonDTO;
import entities.Person;
import exceptions.MissingInputException;
import exceptions.PersonNotFoundException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class PersonFacade {

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
    
    
    public Person getPersonById(int id){
        EntityManager em = getEntityManager();
        Person returP = null;
        try{
            returP = em.find(Person.class, id);
            
            return returP;
        }finally{
            em.close();
        }
    }
    
    public List<Person> getAllPersons() {
        EntityManager em = getEntityManager();
        try {
            TypedQuery<Person> q = em.createQuery("SELECT p FROM Person p", Person.class);
            List<Person> all = q.getResultList();

            return all;
        } finally {
            em.close();
        }
    }

    public Person addPerson(String name, String code) throws MissingInputException {
        
        EntityManager em = getEntityManager();
        Person person = null;
        if(name.isEmpty()){
            throw new MissingInputException("Name empty");
        }
        
        if(!code.equals(realCode)){
            throw new MissingInputException("Not the right code");
        }
        try{
            person = new Person(name,code,"");
            
            em.getTransaction().begin();
            em.persist(person);
            em.getTransaction().commit();
            
            
        }finally {
            em.close();
        }
        
        
        return person;
    }
    
    public PersonDTO deletePerson(int id) throws PersonNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public PersonDTO editPerson(PersonDTO p) throws PersonNotFoundException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
}
