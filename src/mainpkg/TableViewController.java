/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Nabil16
 */
public class TableViewController implements Initializable {

    @FXML
    private TableView<User> userListTableView;
    @FXML
    private TableColumn<User, String> usernameCol;
    @FXML
    private TableColumn<User, String> userTypeCol;
    @FXML
    private TextField userNameTextField;
    @FXML
    private ComboBox userTypeComboBox;
    @FXML
    private Button addUserTableButton;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Admin","Home Ministry", "Citizen","Employee","Police","Supplier");
        
        usernameCol.setCellValueFactory(new PropertyValueFactory<User,String>("userName"));
        userTypeCol.setCellValueFactory(new PropertyValueFactory<User,String>("userType"));
        
        userListTableView.setItems(getUser());
       
    }   
    
    public ObservableList<User> getUser(){
        ObservableList<User> users = FXCollections.observableArrayList();
        users.add(new User("Ahsan", "Habib"));
        users.add(new User("Lisa", "Rahman"));
        users.add(new User("Farid", "Uddin"));
        return users;
    } 

    @FXML
    private void addUserTableButtonOnClick(ActionEvent event) {
        User newUser = new User(userNameTextField.getText(),
                                userTypeComboBox.getValue().toString());
        userListTableView.getItems().add(newUser);
    }
    
}
