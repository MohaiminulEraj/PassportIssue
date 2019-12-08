/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ERAJ
 */
public class EmployeeHomeSceneController implements Initializable {

    @FXML
    private Button empReceivePassportAppButton;
    @FXML
    private Button empObserveApplicationButton;
    @FXML
    private Button empRequPoliceToVerifyButton;
    @FXML
    private Button empContactWithSupplierButton;
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
    private void citizenSubmitDocumentButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void empReceivePassportAppButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void citizenPayPassportButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void empObserveApplicationButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void citizenTrackAppStatButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void empRequPoliceToVerifyButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void citizenReceivePassButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void empContactWithSupplierButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void clearInterfaceButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void clearInterfaceButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
        Parent mainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene mainPageScene = new Scene(mainPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(mainPageScene);
        window.show();
    }
    
}
