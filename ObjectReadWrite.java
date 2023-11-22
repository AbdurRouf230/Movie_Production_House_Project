
package loginproject;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ObjectReadWrite{

    ArrayList<User> arr = new ArrayList();
    


    public void writeObject(User user) {

        FileOutputStream fos = null;
        ObjectOutputStream obj = null;
        File f=null;
        try {
            f = new File("Users.bin");
            if (f.exists()) {
                fos = new FileOutputStream(f, true);
                obj = new AppendableObjectStream(fos);

            } else {
                
                fos = new FileOutputStream(f);
                obj = new ObjectOutputStream(fos);
            }
            
            obj.writeObject(user);
            
        }catch (IOException ex) {
            Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (obj != null) {
                    obj.close();
                }
            } catch (IOException ex) {
                Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }



    }


    public void readObject(){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        User us = null;

        try {

            File f= new File("Users.bin");
            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (true) {
                us = (User) ois.readObject();
                arr.add(us);

            }

        } catch (Exception ex) {}
    }


    


    public int getIncrement() {
        this.readObject();
        return arr.size();
   }


}

