/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/J2EE/EJB30/SessionLocal.java to edit this template
 */
package ejb;

import entity.Stud;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Ashok
 */
@Local
public interface NewSessionBeanLocal {

    List<Stud> display();

    void insert(String name);

    void delete(int id);

    Stud search(int id);
    
}
