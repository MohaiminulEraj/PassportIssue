/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author Nabil16
 */
public class AdminAddNewUserController implements Initializable {

    @FXML
    private Button AddUserButton;
    @FXML
    private TextField userNameTextField;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private ComboBox userTypeComboBoxLogin;
    @FXML
    private Text updateTextFeild;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBoxLogin.getItems().addAll("Employee","Police","Home Ministry","Supplier");
    }    

    @FXML
    private void AddUserButtonOnClick(ActionEvent event) {
        File fLoginInfo = null;
        FileWriter fwLoginInfo = null;
        String uG = String.valueOf(userTypeComboBoxLogin.getValue().toString());
        try{
            fLoginInfo = new File("LoginInfo.txt");
            if(fLoginInfo.exists()) fwLoginInfo = new FileWriter(fLoginInfo, true);
            else fwLoginInfo = new FileWriter(fLoginInfo);
            fwLoginInfo.write(
                    userNameTextField.getText()+","+ loginPasswordField.getText() + ","+uG+","
            );
        }catch(Exception e){
            System.out.println(e);
        }finally {
            try {
                
                if(fwLoginInfo != null) fwLoginInfo.close();
                updateTextFeild.setText(uG+" info has been added.");
                
            } catch (IOException ex) {
                Logger.getLogger(SignupCitizenSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    }
    @FXML
    private void addUserMouseClick(MouseEvent event) {
        userNameTextField.setText("");
    }

    @FXML
    private void addPassMouseClick(MouseEvent event) {
        loginPasswordField.setText("");
    }
    
}
