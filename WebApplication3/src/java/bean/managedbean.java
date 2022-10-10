/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSF/JSFManagedBean.java to edit this template
 */
package bean;

import client.NewJerseyClient;
import entity.Stud;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Ashok
 */
@Named(value = "managedbean")
@SessionScoped
public class managedbean implements Serializable {
NewJerseyClient nsj = new NewJerseyClient();
Response rs;
List<Stud> ls;
GenericType<List<Stud>> gen = new GenericType<List<Stud>>(){};
String name;
int id;
public void delete(int id){
    nsj.delete(id);
}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    /**
     * Creates a new instance of managedbean
     */
    public managedbean() {
    }
    public List<Stud> display(){
        rs = nsj.display(Response.class);
        ls = rs.readEntity(gen);
        return ls;
    }
    
    public void insert(){
        nsj.insert(name);
    }
    
}
