package mainpkg;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class MainPageController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private Button loginButton;
    @FXML
    private Label forgotAccountLabel;
    @FXML
    private Label signUpAsCitizenLabel;
    @FXML
    private PasswordField loginPasswordField;
    @FXML
    private ComboBox userTypeComboBoxLogin;
    
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBoxLogin.getItems().addAll("Admin","Home Ministry", "Citizen","Employee","Police");
    }    
    
    @FXML
    private void userNameTextField(ActionEvent event) {
        
    }

    @FXML
    private void loginButtonOnClick(ActionEvent event)throws IOException {
    String uN = userNameTextField.getText();
    String uP = loginPasswordField.getText();
        boolean found = false;
        String tempUsername ="";
        String tempPassword ="";
        String tempGroup="";
        File f = new File("LoginInfo.txt");
        
                Scanner sc=new Scanner (f);
                
        try{            
               sc.useDelimiter(" ");           // Space diya separate krtesi
               while(sc.hasNextLine() && !found){
               
                    tempUsername = sc.next();
                    tempPassword = sc.next();
                    tempGroup = sc.next();
                //if(tempUsername.trim().equals(uN.trim()) && tempPassword.trim().equals(Up.trim())    
                //if(tempUsername.trim().equals(uN.trim()) && tempPassword.trim().equals(uP.trim()) && userTypeComboBoxLogin.getValue().toString().equals("Citizen")){
                if(uN.equals(tempUsername) && uP.equals(tempPassword) && userTypeComboBoxLogin.getValue().toString().equals("Citizen")){
                    
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("CitizenHomeScene.fxml"));
                            //Parent personViewParent = loader.load();
                    Parent nextnewGUI = loader.load(); //FXMLLoader.load(getClass().getResource("CitizenHomeScene.fxml"));
                    
                    Scene newScene = new Scene(nextnewGUI);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(newScene);
                    window.show();
                    found = true;
                }
                if(uN.equals("Nabil") && uP.equals("Eraj") && userTypeComboBoxLogin.getValue().toString().equals("Admin")){
                Parent nextnewGUI = FXMLLoader.load(getClass().getResource("AdminHomeScene.fxml"));
                
                Scene newScene = new Scene(nextnewGUI);

                Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                window.setScene(newScene);
                window.show();
                }
            
                }
            
            //sc.close();
            } catch(Exception e){
                System.out.println(e);
            } finally{
            try{
                if(sc != null) sc.close();
            } catch(Exception e){
                System.out.println(e);
            }
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
    
    /* public void changSceneOnUserType(String userHomeScene) throws IOException{
    Parent nextnewGUI = FXMLLoader.load(getClass().getResource(userHomeScene));
    
    Scene newScene = new Scene(nextnewGUI);
    
    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
    window.setScene(newScene);
    window.show();
    }*/
    
}
