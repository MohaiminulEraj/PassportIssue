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
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class MainPageController implements Initializable {

    @FXML
    private Label loginTextLabel;
    @FXML
    private TextField userNameTextField;
    @FXML
    private PasswordField passwordTextField;
    @FXML
    private ChoiceBox userTypeChoiceBoxLogin;
    @FXML
    private Button loginButton;
    @FXML
    private Label signUpLabel;
    @FXML
    private ChoiceBox<?> userTypeChoiceBoxSignUp;
    @FXML
    private Button signUpButton;

    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        userTypeChoiceBoxLogin.getItems().addAll("Admin","Home Ministry", "Citizen","Employee","Police");
    }    
    
    @FXML
    private void userNameTextField(ActionEvent event) {
        
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event)throws IOException {
        if(userTypeChoiceBoxLogin.getValue().toString().equals("Admin")){
        Parent nextnewGUI = FXMLLoader.load(getClass().getResource("AdminPage.fxml"));
        
        Scene newScene = new Scene(nextnewGUI);
        
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(newScene);
        window.show();
        }
    }

    @FXML
    private void signUpButtonOnClick(ActionEvent event) {
    }
    
}
