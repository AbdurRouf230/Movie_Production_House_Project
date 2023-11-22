package loginproject;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import loginproject.User;
//import movieproductionhouse.FXMLDocumentController;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class FXMLDocumentController implements Initializable {

    @FXML
    private TextField IdField;
    @FXML
    private TextField passwordField;
    ArrayList<User> arr;
    /**
     * Initializes the controller class.
     */

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        arr =  new ArrayList();
        
    }   
    public void readObject() {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        User us = null;
        File f = null;
        try {
            f = new File("User.bin");

            fis = new FileInputStream(f);
            ois = new ObjectInputStream(fis);
            while (true) {
                us = (User) ois.readObject();
                arr.add(us);

            }

        } catch (Exception ex) {}
    }

    @FXML
    private void loginAction(ActionEvent event) throws IOException, ClassNotFoundException {
        int id = Integer.parseInt(IdField.getText());
        String pass = passwordField.getText();
        this.readObject();

        for (User i : arr){
            if (i.getId()==id && i.getPass().equals(pass)){
                Parent r = FXMLLoader.load(getClass().getResource("dashBoard.fxml"));
                Scene sc = new Scene(r);
                Stage stg =(Stage)((Node)event.getSource()).getScene().getWindow();
                stg.setScene(sc);
                stg.show();
        
            }
            else{
               passwordField.setText("Wrong Password or id");
        
            }
           
        }
        
            
        
        

    }

    @FXML
    private void forgotPasswordAction(ActionEvent event) {

                      


        
    }

    @FXML
    private void CreateNewAccountAction(ActionEvent event) throws IOException {
            FXMLLoader loader = new FXMLLoader();
            Parent r = loader.load(getClass().getResource("NewAccountOpener.fxml"));
            Scene sc = new Scene(r);
            Stage s =(Stage)((Node)event.getSource()).getScene().getWindow();
            s.setScene(sc);
            s.show();
    }
    
}
