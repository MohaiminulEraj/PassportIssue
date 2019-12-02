/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package citizenpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Nabil Akhunjee
 */
public class LoginCitizenSceneController implements Initializable {

    @FXML
    private MenuButton citizenApplyButton;
    @FXML
    private MenuItem citizenApplyNewPassButton;
    @FXML
    private MenuItem citizenApplyReissuePassButton;
    @FXML
    private MenuItem citizenApplyRetrievePassButton;
    @FXML
    private Button citizenSubmitDocumentButton;
    @FXML
    private Button citizenPayPassportButton;
    @FXML
    private Button citizenTrackAppStatButton;
    @FXML
    private Button citizenReceivePassButton;
    @FXML
    private Button clearInterfaceButton;
    @FXML
    private Button logoutButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void citizenApplyNewPassButtonOnclick(ActionEvent event) {
    }

    @FXML
    private void citizenApplyReissuePassButtonOnclick(ActionEvent event) {
    }

    @FXML
    private void citizenApplyRetrievePassButtonOnclick(ActionEvent event) {
    }

    @FXML
    private void citizenSubmitDocumentButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void citizenPayPassportButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void citizenTrackAppStatButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void citizenReceivePassButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void clearInterfaceButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void logoutButtonOnClick(MouseEvent event) {
    }
    
}
