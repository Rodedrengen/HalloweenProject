/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package facades;

import entities.Person;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Disabled;
import utils.EMF_Creator;

/**
 *
 * @author simon
 */
//@Disabled
public class NewEmptyJUnitTest {

    private static EntityManagerFactory emf;
    private static PersonFacade facade;

    Person p1, p2, p3, p4;

    public NewEmptyJUnitTest() {
    }

    @BeforeAll
    public static void setUpClass() {
        emf = EMF_Creator.createEntityManagerFactoryForTest();
        facade = PersonFacade.getPersonFacade(emf);
    }

    @AfterAll
    public static void tearDownClass() {
    }

    @BeforeEach
    public void setUp() {
        EntityManager em = emf.createEntityManager();
        try {
            em.getTransaction().begin();
            em.createNamedQuery("Person.deleteFrom").executeUpdate();

            p1 = new Person("Simon", "kodeordet", "");
            p2 = new Person("Hanna", "kodeordet", "");
            p3 = new Person("Asta", "kodeordet", "");
            p4 = new Person("Nils", "kodeordet", "");
            
            em.persist(p1);
            em.persist(p2);
            em.persist(p3);
            em.persist(p4);
            
            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    @Test
    public void testFacade() {

        int size = 4;

        int actual = facade.getAllPersons().size();

        assertEquals(size, actual);

    }
}
