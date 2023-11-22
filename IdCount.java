/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package loginproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author abdur
 */
public class IdCount implements Serializable{
    File f = null;
    ArrayList<User>arr=new ArrayList();
    public void readObject(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        User us = null;

        try {

            File f= new File("User.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (true) {
                us = (User) ois.readObject();
                arr.add(us);

            }

        } catch (Exception ex) {}
        
        
    }
    public int getCount(){
        this.readObject();
        return arr.size();
    }
    public ArrayList<User> getArr(){
        this.readObject();
        return arr;
    }
    
    
}
