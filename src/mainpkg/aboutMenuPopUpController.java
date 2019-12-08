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
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nabil Akhunjee
 */
public class aboutMenuPopUpController implements Initializable {

    @FXML
    private Button okayCloseStageButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okayCloseStageButtonOnClick(ActionEvent event) {
        Stage stage  = (Stage) okayCloseStageButton.getScene().getWindow();
        stage.close();
    }
    
}
