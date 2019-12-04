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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Nabil Akhunjee
 */
public class AdminHomeSceneController implements Initializable {

    @FXML
    private Button clearInterfaceButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button policeReceiveVerificationRequButton;
    @FXML
    private Button policeUpdateVerificationStatusButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void citizenSubmitDocumentButtonOnClick(MouseEvent event) {
    }


    @FXML
    private void citizenPayPassportButtonOnClick(MouseEvent event) {
    }




    @FXML
    private void clearInterfaceButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void clearInterfaceButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void policeReceiveVerificationRequButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void policeUpdateVerificationStatusButtonOnClick(ActionEvent event) {
    }

    
}
