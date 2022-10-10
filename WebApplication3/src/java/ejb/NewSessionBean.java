/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/StatelessEjbClass.java to edit this template
 */
package ejb;

import entity.Stud;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Ashok
 */
@Stateless
public class NewSessionBean implements NewSessionBeanLocal {

    @PersistenceContext(unitName = "WebApplication3PU")
    private EntityManager em;

    
    @Override
    public List<Stud> display() {
        List<Stud> st = em.createNamedQuery("Stud.findAll").getResultList();
        return st;
    }

    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    public void persist(Object object) {
        em.persist(object);
    }

    @Override
    public void insert(String name) {
        
        Stud st= new Stud();
        st.setName(name);
        em.persist(st);
        
    }

    @Override
    public void delete(int id) {
        
        Stud st= em.find(Stud.class,id);
        em.remove(st);
    }

    @Override
    public Stud search(int id) {
        
        Stud sh=em.find(Stud.class, id);
        return sh;
    }
    
}
