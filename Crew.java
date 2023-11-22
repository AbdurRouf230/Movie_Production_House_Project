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
public class Crew implements Serializable{
    int id;
    String name,pass,desig;
    LocalDate doj;

    public Crew(int id, String name, String desig, LocalDate doj, String pass) {
        this.id = id;
        this.name = name;
        this.pass = pass;
        this.desig = desig;
        this.doj = doj;
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

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDesig() {
        return desig;
    }

    public void setDesig(String desig) {
        this.desig = desig;
    }

    public LocalDate getDoj() {
        return doj;
    }

    public void setDoj(LocalDate doj) {
        this.doj = doj;
    }

    @Override
    public String toString() {
        return "Crew{" + "id=" + id + ", name=" + name + ", pass=" + pass + ", desig=" + desig + ", doj=" + doj + '}';
    }
    
}
