/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginproject;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author abdur
 */
public class User implements Serializable{
    int id;
    String name, desig;
    LocalDate DOJ;
    String pass;

    public User(int id, String name, String desig, LocalDate DOJ, String pass) {
        this.id = id;
        this.name = name;
        this.desig = desig;
        this.DOJ = DOJ;
        this.pass = pass;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public LocalDate getDOJ() {
        return DOJ;
    }

    public void setDOJ(LocalDate DOJ) {
        this.DOJ = DOJ;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", name=" + name + ", desig=" + desig + ", DOJ=" + DOJ + ", pass=" + pass + '}';
    }


    
}
