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
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nabil16
 */
public class CitizenReissuePassController implements Initializable {

    @FXML
    private ComboBox passReissueDurationComboBox;
    @FXML
    private Button applyPassButton;
    @FXML
    private TextField oldPassNoTextField;
    @FXML
    private Label confirmationLabel;
    @FXML
    private TextField lostPassLocationTextField;
    @FXML
    private TextField gdCopyNoTextField;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        passReissueDurationComboBox.getItems().addAll("5-years","10-years");
    }
    
    @FXML
    private void applyPassButtonOnClick(ActionEvent event) {
        confirmationLabel.setText("Applied successfully.\nYou'll be notified soon.");
    }
    
}
