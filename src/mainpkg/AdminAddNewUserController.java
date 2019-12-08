/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

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
    private ComboBox<?> userTypeComboBoxLogin;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AddUserButtonOnClick(ActionEvent event) {
    }
    
}
