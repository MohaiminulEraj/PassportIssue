/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nabil Akhunjee
 */
public class CitizenHomeSceneController implements Initializable {

    @FXML
    private MenuButton citizenApplyButton;
    @FXML
    private MenuItem citizenApplyNewPassButton;
    @FXML
    private MenuItem citizenApplyReissuePassButton;
    @FXML
    private MenuItem citizenApplyRetrievePassButton;
    @FXML
    private Button citizenPayPassportButton;
    @FXML
    private Button citizenTrackAppStatButton;
    @FXML
    private Button citizenReceivePassButton;
    @FXML
    private Button citizenSystemRatingButton;
    @FXML
    private Button clearInterfaceButton;
    @FXML
    private Button logoutButton;
    @FXML
    private BorderPane borderpane;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource(ui+".fxml"));
            borderpane.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(AdminHomeSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void citizenApplyNewPassButtonOnclick(ActionEvent event) {
        loadUI("CitizenNewPass");
    }

    @FXML
    private void citizenApplyReissuePassButtonOnclick(ActionEvent event) {
        loadUI("CitizenReissuePass");
    }

    @FXML
    private void citizenApplyRetrievePassButtonOnclick(ActionEvent event) {
        loadUI("CitizenRetrievePass");
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
    private void citizenSubmitDocumentButtonOnClick(MouseEvent event) {
    }

    @FXML
    private void citizenSystemRatingButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void clearInterfaceButtonOnClick(MouseEvent event) {
        borderpane.setCenter(null);
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
