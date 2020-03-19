package mainpkg;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
    @FXML
    private AnchorPane anchorpane;
    
    @Override 
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBoxLogin.getItems().addAll("Admin","Home Ministry", "Citizen","Employee","Police","Supplier");
    }    
    

       @FXML
    private void loginButtonOnClick(ActionEvent event)throws IOException {
        File f = null;
        Scanner sc;
        boolean err=false;
        String[] arr=null;
        String temp="";
        String uN = userNameTextField.getText();
        String uP = loginPasswordField.getText();
        String uG = String.valueOf(userTypeComboBoxLogin.getValue().toString());
        try{
            f = new File("LoginInfo.txt");
        sc = new Scanner(f);
        while(sc.hasNext()){
            temp = sc.nextLine();
            arr = temp.split(",");
        }
        
        for(int i=0; i<=(arr.length-3); i=i+3){
            if(arr[i].equals(uN) && arr[i+1].equals(uP) && arr[i+2].equals(uG)){
                if(uG.equals("Admin")){
                    Parent admin = FXMLLoader.load(getClass().getResource("AdminHomeScene.fxml"));
                    Scene loginScene = new Scene(admin);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(loginScene);
                    window.show();
                }
                else if(uG.equals("Home Ministry")){
                    Parent homeMinistry = FXMLLoader.load(getClass().getResource("HomeMinistryHomeScene.fxml"));
                    Scene loginScene = new Scene(homeMinistry);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(loginScene);
                    window.show();
                }
                
                else if(uG.equals("Citizen")){
                    Parent citizen = FXMLLoader.load(getClass().getResource("CitizenHomeScene.fxml"));
                    Scene loginScene = new Scene(citizen);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(loginScene);
                    window.show();
                }
                else if(uG.equals("Police")){
                    Parent police = FXMLLoader.load(getClass().getResource("PoliceHomeScene.fxml"));
                    Scene loginScene = new Scene(police);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(loginScene);
                    window.show();
                }
                else if(uG.equals("Employee")){
                    Parent employee = FXMLLoader.load(getClass().getResource("EmployeeHomeScene.fxml"));
                    Scene loginScene = new Scene(employee);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(loginScene);
                    window.show();
                }
                else if(uG.equals("Supplier")){
                    Parent supplier = FXMLLoader.load(getClass().getResource("SuppilerHomeScene.fxml"));
                    Scene loginScene = new Scene(supplier);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        
                    window.setScene(loginScene);
                    window.show();
                }
                err=false;
            }
            else {
                //err=true;
            }
            /*
            f = new File("loginInfo.bin");
            String str="";
            String str2="";
            if(!f.exists()){
                System.out.println("file nai :3");
            }
            
            else{
                
                fis = new FileInputStream(f);
                bis = new BufferedInputStream(fis);
                dis = new DataInputStream(bis);
                //String[] ss = str.split("\\?");
                Scanner sc = new Scanner(bis);
                //fr = new FileReader(dis);
                //ois = new ObjectInputStream(fis);
                //str = dis.readUTF();
                while(sc.hasNextLine()){
                    str2 += dis.readUTF();
                    
                    //str += sc.nextLine();
                }
                   dis.close();
                  sc.close();
                
                while(true){
                str += dis.readUTF();
                      
                }
                
                //System.out.println("Str: "+ str);
                
                while(true){
                    str+= ois.readObject()
                         +ois.readUTF()
                         +ois.readUTF();
//                    str+= dis.readUTF()
//                         +dis.readUTF()
//                         +dis.readUTF();
                }
            }
                */
            }
        
        sc.close();
        if(err==true){
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Messege!");
            String s = "The Username or Password is Incorrect!";
            alert.setContentText(s);
            alert.showAndWait();
        }
           } catch(Exception e){
               System.out.println(e);
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
    
    @FXML
    private void closeStage(ActionEvent event) {
        Stage stage = (Stage) anchorpane.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void aboutMenuItem(ActionEvent event) throws IOException {
        Parent aboutPopup = FXMLLoader.load(getClass().getResource("aboutMenuPopUp.fxml"));
        Scene popupForgotAccountScene = new Scene(aboutPopup);
        
        Stage window  = new Stage();
        window.setTitle("About");
        window.setScene(popupForgotAccountScene);
        window.show();
    }
    
}
