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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainPageController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private ChoiceBox userTypeChoiceBoxLogin;
    @FXML
    private Button loginButton;
    @FXML
    private Label forgotAccountLabel;
    @FXML
    private Label signUpAsCitizenLabel;
    @FXML
    private PasswordField loginPasswordField;

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
            Parent nextnewGUI = FXMLLoader.load(getClass().getResource("AdminHomeScene.fxml"));

            Scene newScene = new Scene(nextnewGUI);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        }
        
        else if(userTypeChoiceBoxLogin.getValue().toString().equals("Citizen")){
            Parent nextnewGUI = FXMLLoader.load(getClass().getResource("CitizenHomeScene.fxml"));

            Scene newScene = new Scene(nextnewGUI);

            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
        }
    }

    @FXML
    private void forgotAccountLabelOnClick(MouseEvent event) throws IOException {
        Parent forgotAccountPopup = FXMLLoader.load(getClass().getResource("ForgotAccntpopup.fxml"));
        Scene popupForgotAccountScene = new Scene(forgotAccountPopup);
        
        Stage window  = new Stage();
        window.setTitle("Pop-up window Forgot Account");
        window.setScene(popupForgotAccountScene);
        window.show();
    }

    @FXML
    private void signUpAsCitizenLabelOnClick(MouseEvent event) throws IOException {
        Parent signupCitizenParent = FXMLLoader.load(getClass().getResource("SignupCitizenScene.fxml"));
        Scene signupCitizenScene = new Scene(signupCitizenParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
        window.setScene(signupCitizenScene);
        window.show();
    }
    
}
