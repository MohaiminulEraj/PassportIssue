/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.Label;
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
    private PasswordField citizenSignunpasswordField;
    @FXML
    private DatePicker citizenDobDatePicker;
    @FXML
    private ChoiceBox citizenReligionChoiceBox;
    @FXML
    private ChoiceBox guardianReligionChoiceBox;
    @FXML
    private Label warningLabel;
    @FXML
    private ChoiceBox citizenPresentAddrDivisionChoiceBox;
    @FXML
    private ChoiceBox citizenPermanentAddrDivisionChoiceBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       citizenReligionChoiceBox.getItems().addAll("Islam","Hinduism","Buddhism","Christianity");
       guardianReligionChoiceBox.getItems().addAll("Islam","Hinduism","Buddhism","Christianity");
       citizenPresentAddrDivisionChoiceBox.getItems().addAll("Barisal","Chittagong","Dhaka","Khulna","Mymensingh","Rajshahi","Rangpur","Sylhet");
       citizenPermanentAddrDivisionChoiceBox.getItems().addAll("Barisal","Chittagong","Dhaka","Khulna","Mymensingh","Rajshahi","Rangpur","Sylhet");
       
       secondaryCountryTextField.setDisable(true);
       
    }    

    
    @FXML
    private void citizenSignupButtonOnClick(ActionEvent event) throws IOException {
        
        
        
        boolean signupable = false;
        
        
        File f = null;
        FileWriter fw = null; 
        
        File fLoginInfo = null;
        FileWriter fwLoginInfo = null;
        
        File fBin = null;
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        DataOutputStream dos = null;
        ObjectOutputStream oos = null;
        RadioButton selectedRadioButton = (RadioButton) gender.getSelectedToggle();
        String toogleGenderValue = selectedRadioButton.getText();
        String guardianNationality = selectedRadioButton.getText();
        
        LocalDate localDate = citizenDobDatePicker.getValue();
        String cEmail = citizenEmailTextField.getText();
        String cPass;
        
        String[] atS = cEmail.split("@");
        String[] dotS = cEmail.split("\\.");
        for(int i=0; i<dotS.length; i++){
            if(atS.length>1 && dotS.length>1){
                cPass = citizenSignunpasswordField.getText();
                if(!cPass.isEmpty()){
                signupable = true;
                } 
                else {
                    
                    warningLabel.setText("Password Required!!!");
                }
            }
            else {
            warningLabel.setText("Invalid Email Address!!!");
        }
        }
        if(signupable == true){
        try {
            f = new File("CitizenSignUpForm.txt");
            if(f.exists()) fw = new FileWriter(f, true);
            else fw = new FileWriter(f);
            
            fw.write(
                    citizenEmailTextField.getText() +" "+ citizenFullNameTextField.getText()+" "
                    +toogleGenderValue +" "+ localDate+" "
                    +nationalIdTextField.getText() +" "+ heightTextField.getText()+" "
                    +citizenReligionChoiceBox.getValue() +" "+ citizenPhoneNoTextField.getText()+" "
                    +citizenPresentAddrVill.getText()+" "
                    +citizenPresentAddrRoad.getText()+" "
                    +citizenPresentAddrDivisionChoiceBox.getValue()+" "
                    +citizenPresentAddrPO.getText()+" "
                    +citizenPresentAddrZip.getText()+" "
                    +citizenPermanentAddrVill.getText()+" "
                    +citizenPermanentAddrRoad.getText()+" "
                    +citizenPermanentAddrDivisionChoiceBox.getValue()+" "
                    +citizenPermanentAddrPO.getText()+" "
                    +citizenPermanentAddrZip.getText()+" "
                    +citizenRelationGuadianTextField.getText()+" "
                    +citizenGuardianFullNameTextField.getText()+" "
                    +guardianNationality+" "
                    +guardianReligionChoiceBox.getValue()+" "
                    +citizenGuardianPhoneNoTextField.getText()+" "
                    +citizenGuardianEmailTextField.getText()+" "
                    +secondaryCountryTextField.getText()+" "
            );
            
            fLoginInfo = new File("LoginInfo.txt");
            if(fLoginInfo.exists()) fwLoginInfo = new FileWriter(fLoginInfo, true);
            else fwLoginInfo = new FileWriter(fLoginInfo);
            
            fwLoginInfo.write(
                    citizenEmailTextField.getText()+","+ citizenSignunpasswordField.getText() + ",Citizen,"
            );
            
            fBin = new File("loginInfo.bin");
            if(fBin.exists()) fos = new FileOutputStream(fBin,true);
            else fos = new FileOutputStream(fBin);
            
            //fos = new FileOutputStream("loginInfo.bin");
            //oos = new ObjectOutputStream(fos);
            bos = new BufferedOutputStream(fos);
            dos = new DataOutputStream(bos);
            
            String sr=citizenEmailTextField.getText()+","+citizenSignunpasswordField.getText()+",Citizen";
            dos.writeUTF(sr);
            System.out.println(sr);
            //dos.writeUTF(citizenSignunpasswordField.getText());
            //dos.writeUTF("Citizen ");
              
        } catch (IOException ex) {
            Logger.getLogger(SignupCitizenSceneController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                //if(oos != null) oos.close();
                if(dos != null) dos.close();
                if(fw != null) fw.close();
                if(fwLoginInfo != null) fwLoginInfo.close();
                
            } catch (IOException ex) {
                Logger.getLogger(SignupCitizenSceneController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        Parent mainPageParent = FXMLLoader.load(getClass().getResource("CitizenHomeScene.fxml"));
        Scene mainPageScene = new Scene(mainPageParent);
        Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        window.setScene(mainPageScene);
        window.show();
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
                    citizenPermanentAddrDivisionChoiceBox.setValue(citizenPresentAddrDivisionChoiceBox.getValue());
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
