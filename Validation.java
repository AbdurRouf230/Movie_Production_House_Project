
package loginproject;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author abdur
 */
public class Validation {
    ObjectReadWrite obj = new ObjectReadWrite();
    int id=100000;
    ArrayList<Integer> arr;
    int size;

    public boolean idVerification(ArrayList<User> arr, int data) {
        for (User i : arr) {
            if (i.getId() == data) {
                return false;

            }

        }

        return true;
    }

    public int idGenerator(){
        id+=obj.getIncrement();

        return id;
        
    
    }

    
}
