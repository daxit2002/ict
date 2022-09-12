
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;




/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Ashok
 */
@ManagedBean
@RequestScoped
public class User {
    String name;
    
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    
}
