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
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nabil16
 */
public class AdminHomeSceneController implements Initializable {

    @FXML
    private BorderPane borderpane;
    @FXML
    private Button clearInterfaceButton;
    @FXML
    private Button logoutButton;
    @FXML
    private Button adminAddNewUserButton;
    @FXML
    private Button adminRemoveExistingUserButton;
    @FXML
    private MenuItem pieChartButton;
    @FXML
    private MenuItem barChartButton;
    @FXML
    private MenuItem lineChartButton;
    @FXML
    private Button adminUserListButton;

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
    private void adminAddNewUserButtonOnClick(ActionEvent event) {
        loadUI("AdminAddNewUser");
    }


    @FXML
    private void pieChartButton(ActionEvent event) {
        loadUI("CreatePieChart");
    }

    @FXML
    private void barChartButtonOnClick(ActionEvent event) {
        loadUI("CreateBarChart");
    }

    @FXML
    private void lineChartButtonOnClick(ActionEvent event) {
        loadUI("CreateLineChart");
    }
    
    
    @FXML
    private void clearInterfaceButtonOnClick(ActionEvent event) {
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

    @FXML
    private void adminRemoveExistingUserButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void adminUserListButtonOnClick(ActionEvent event) {
        loadUI("TableView");
    }


    
}
