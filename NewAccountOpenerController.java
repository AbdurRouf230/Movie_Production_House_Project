/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package loginproject;

import CrewMembers.Actor;
import CrewMembers.CineMatoGrapher;
import CrewMembers.Client;
import CrewMembers.Director;
import CrewMembers.Producer;
import CrewMembers.ProjectManager;
import CrewMembers.ScriptWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author abdur
 */
public class NewAccountOpenerController implements Initializable {

    @FXML
    private TextField nameFiled;
    @FXML
    private TextField idFiled;
    @FXML
    private DatePicker doj;
    private DatePicker dob;
    private TextField passwordField;
    @FXML
    private TextArea resultBar;
    @FXML
    private ComboBox<String> desigCombo;

    @FXML
    private TableView<User> crewTable;
    @FXML
    private TableColumn<User, String> nameCol;
    @FXML
    private TableColumn<User, Integer> idCol;
    @FXML
    private TableColumn<User, LocalDate> dojCol;
    @FXML
    private TableColumn<User, String> desigCol;
    @FXML
    private TextField movieName;
    public IdCount c;
    @FXML
    private TableColumn<User, String> passCol;
    ArrayList<User> arr;
    User user;
    Validation valid;
    ObjectReadWrite obj;
    int id;
    @FXML
    private TextField passField;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCol.setCellValueFactory(new PropertyValueFactory("name"));
        idCol.setCellValueFactory(new PropertyValueFactory("id"));
        dojCol.setCellValueFactory(new PropertyValueFactory("DOJ"));
        desigCol.setCellValueFactory(new PropertyValueFactory("desig"));
        passCol.setCellValueFactory(new PropertyValueFactory("pass"));
        
        
        desigCombo.getItems().addAll("Producer", "Director", "Project Manger", "Actor", "Actress", "CinematoGrapher",
                "Client", "Script Writer");
        c = new IdCount();
        valid = new Validation();
        arr = new ArrayList();
        obj = new ObjectReadWrite();
        id = 100000+c.getCount()+1;
        idFiled.setText(Integer.toString(id)); 
    }

    @FXML
    private void logInPageAction(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        Parent r = loader.load(getClass().getResource("FXMLDocument.fxml"));
        Scene sc = new Scene(r);

        Stage s = (Stage) ((Node) event.getSource()).getScene().getWindow();

        s.setScene(sc);
        s.show();
    }
    

    @FXML
    private void addCrewAction(ActionEvent event) {
        
        File f = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try {

            
            f = new File("User.bin");
            if(f.exists()){
                fos = new FileOutputStream(f,true);
                oos = new AppendableObjectStream(fos);                
            }
            else{
                fos = new FileOutputStream(f);
                oos = new ObjectOutputStream(fos);               
            }
            
            if (desigCombo.getValue().equals("Producer")) {
                user = new Producer(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());}
            else if (desigCombo.getValue().equals("Director")) {
                user = new Director(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());
            } else if (desigCombo.getValue().equals("Project Manger")) {
                user = new ProjectManager(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());
            } else if (desigCombo.getValue().equals("Client")) {
                user = new Client(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());
            } else if (desigCombo.getValue().equals("Actor")) {
                user = new Actor(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());
            } else if (desigCombo.getValue().equals("Actress")) {
                user = new Actor(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());
            } else if (desigCombo.getValue().equals("CinematoGrapher")) {
                user = new CineMatoGrapher(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());
            } else if (desigCombo.getValue().equals("Script Writer")) {
                user = new ScriptWriter(id, nameFiled.getText(), desigCombo.getValue(), doj.getValue(),passField.getText());
            }

//            user = new Crew(id,nameFiled.getText(),desigCombo.getValue(),doj.getValue(),passField.getText());

            crewTable.getItems().add(user);
            arr.add(user);
            

            oos.writeObject(user);

        } catch (IOException ex) {
            Logger.getLogger(NewAccountOpenerController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(oos != null) oos.close();
            } catch (IOException ex) {
                Logger.getLogger(NewAccountOpenerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        id = id + 1;
        idFiled.setText(Integer.toString(id)); 
    }

    @FXML
    private void createTheTeam(ActionEvent event) {

            if(movieName.getText()==null){
                resultBar.setText("Please Enter The Movie Name");
                return ;
            }
            if(arr.size()==0){
                resultBar.appendText("Please add some crew");
            }
            
            
            File f = null;
            FileOutputStream fos;      
            fos = null;
            ObjectOutputStream oos = null;

            try {

                f = new File( "Projects.bin");
                if(f.exists()){
                    fos = new FileOutputStream(f,true);
                    oos = new AppendableObjectStream(fos);                
                }
                else{
                    fos = new FileOutputStream(f);
                    oos = new ObjectOutputStream(fos);               
                }
                MovieProject newProject = new MovieProject(movieName.getText(),arr);
                oos.writeObject(newProject);
                resultBar.setText("SuccessFully created Team");

            } catch (IOException ex) {
                Logger.getLogger(NewAccountOpenerController.class.getName()).log(Level.SEVERE, null, ex);
            } finally {
                try {
                    if(oos != null) oos.close();
                } catch (IOException ex) {
                    Logger.getLogger(NewAccountOpenerController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }



}
