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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nabil16
 */
public class CitizenNewPassController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private TextArea userDetailsTextArea;
    @FXML
    private Button loadInfoButton;
    @FXML
    private Label confirmationLabel;
    @FXML
    private Button applyPassButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void userNameTextField(ActionEvent event) {
    }

    @FXML
    private void loadInfoButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void applyPassButtonOnClick(ActionEvent event) {
    }
    
}
