/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.PasswordField;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Nabil Akhunjee
 */
public class SignupCitizenSceneController implements Initializable {

    
    @FXML
    private TextField citizenFullNameTextField;
    @FXML
    private ToggleGroup gender;
    @FXML
    private TextField nationalIdTextField;
    @FXML
    private TextField heightTextField;
    @FXML
    private TextField citizenEmailTextField;
    @FXML
    private TextField citizenPhoneNoTextField;
    
    @FXML
    private TextField citizenRelationGuadianTextField;
    @FXML
    private TextField citizenGuardianFullNameTextField;
    @FXML
    private ToggleGroup guardianNationality;
    @FXML
    private TextField citizenGuardianPhoneNoTextField;
    @FXML
    private TextField citizenGuardianEmailTextField;
    @FXML
    private TextField citizenPresentAddrVill;
    @FXML
    private TextField citizenPresentAddrRoad;
    @FXML
    private TextField citizenPresentAddrDistrict;
    @FXML
    private TextField citizenPresentAddrPO;
    @FXML
    private TextField citizenPresentAddrZip;
    @FXML
    private CheckBox isPermanentAddrSame;
    @FXML
    private TextField citizenPermanentAddrVill;
    @FXML
    private TextField citizenPermanentAddrRoad;
    @FXML
    private TextField citizenPermanentAddrDistrict;
    @FXML
    private TextField citizenPermanentAddrPO;
    @FXML
    private TextField citizenPermanentAddrZip;
    @FXML
    private CheckBox isDualCitizen;
    @FXML
    private TextField secondaryCountryTextField;
    @FXML
    private Button citizenSignupButton;
    @FXML
    private Button backToMainButton;
    @FXML
    private TextField citizenNewUsernameTextField;
    @FXML
    private PasswordField citizenSignunpasswordField;
    @FXML
    private DatePicker citizenDobDatePicker;
    @FXML
    private ChoiceBox citizenReligionChoiceBox;
    @FXML
    private ChoiceBox guardianReligionChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       citizenReligionChoiceBox.getItems().addAll("Islam","Hinduism","Buddhism","Christianity");
       guardianReligionChoiceBox.getItems().addAll("Islam","Hinduism","Buddhism","Christianity");
       
       secondaryCountryTextField.setDisable(true);
       
    }    

    
    @FXML
    private void citizenSignupButtonOnClick(ActionEvent event) throws IOException {
        
        Parent mainPageParent = FXMLLoader.load(getClass().getResource("LoginCitizenScene.fxml"));
        Scene mainPageScene = new Scene(mainPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.show();
        
        
        
        File f = null;
        FileWriter fw = null; 
        
        File fLoginInfo = null;
        FileWriter fwLoginInfo = null;
        
        RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
        String toogleGenderValue = selectedRadioButton.getText();
        String guardianNationality = selectedRadioButton.getText();
        
        LocalDate localDate = citizenDobDatePicker.getValue();
        
        try {
            f = new File("CitizenSignUpForm.txt");
            if(f.exists()) fw = new FileWriter(f, true);
            else fw = new FileWriter(f);
            
           
            fw.write(
            	"Personal Information: "+ citizenFullNameTextField.getText()+", "
                    +toogleGenderValue+", "
                    +localDate+", "
                    +nationalIdTextField.getText()+", "
                    +heightTextField.getText()+", "
                    +citizenReligionChoiceBox.getValue()+", "
                    +citizenPhoneNoTextField.getText()+", "
                    +citizenEmailTextField.getText()+
                    "\n Present Address: "
                    +citizenPresentAddrVill.getText()+", "
                    +citizenPresentAddrRoad.getText()+", "
                    +citizenPresentAddrDistrict.getText()+", "
                    +citizenPresentAddrPO.getText()+", "
                    +citizenPresentAddrZip.getText()+
                    "\n Parmanent Address: "
                    +citizenPermanentAddrVill.getText()+", "
                    +citizenPermanentAddrRoad.getText()+", "
                    +citizenPermanentAddrDistrict.getText()+", "
                    +citizenPermanentAddrPO.getText()+", "
                    +citizenPermanentAddrZip.getText()+
                    "\n Guardian Information: "
                    +citizenRelationGuadianTextField.getText()+", "
                    +citizenGuardianFullNameTextField.getText()+", "
                    +guardianNationality+", "
                    +guardianReligionChoiceBox.getValue()+", "
                    +citizenGuardianPhoneNoTextField.getText()+", "
                    +citizenGuardianEmailTextField.getText()+"\n"+
                    " Citizenship Information: "
                    +secondaryCountryTextField.getText()+" \r\n"
            );
            
            fLoginInfo = new File("LoginInfo.txt");
            if(fLoginInfo.exists()) fwLoginInfo = new FileWriter(fLoginInfo, true);
            else fwLoginInfo = new FileWriter(fLoginInfo);
            
            fwLoginInfo.write(
                    citizenNewUsernameTextField.getText()+" "+ citizenSignunpasswordField.getText() +"\r\n"
            );
                 
        } catch (IOException ex) {
            Logger.getLogger(SignupCitizenSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if(fw != null) fw.close();
                if(fwLoginInfo != null) fwLoginInfo.close();
            } catch (IOException ex) {
                Logger.getLogger(SignupCitizenSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 
    }

    @FXML
    private void backToMainButtonOnClick(ActionEvent event) throws IOException {
        Parent mainPageParent = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Scene mainPageScene = new Scene(mainPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.show();
    }

    @FXML
    private void isPermanentAddrSameSelected(ActionEvent event) {
        if(isPermanentAddrSame.isSelected()){
                    citizenPermanentAddrVill.setText(citizenPresentAddrVill.getText());
                    citizenPermanentAddrRoad.setText(citizenPresentAddrRoad.getText());
                    citizenPermanentAddrDistrict.setText(citizenPresentAddrDistrict.getText());
                    citizenPermanentAddrPO.setText(citizenPresentAddrPO.getText());
                    citizenPermanentAddrZip.setText(citizenPresentAddrZip.getText());
                         
        }  
    }

    @FXML
    private void isDualCitizenSelected(ActionEvent event) {
        if(isDualCitizen.isSelected())
            secondaryCountryTextField.setDisable(false);
        else
            secondaryCountryTextField.setDisable(true);
    }
    
}
