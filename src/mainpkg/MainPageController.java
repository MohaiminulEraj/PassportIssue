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
    String uG = userTypeComboBoxLogin.getValue().toString();
        boolean found = false;
        String tempUsername ="";
        String tempPassword ="";
        String tempGroup="";
        File f = null; // new File("loginInfo.bin");
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        DataInputStream dis = null;
        FileReader fr = null;
        ObjectInputStream ois = null;
                
                
        try{
            f = new File("LoginInfo.txt");
            if(!f.exists()) System.out.println("File Not Found");
            
            Scanner sc=new Scanner (f);
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
                /*
                while(true){
                str += dis.readUTF();
                      
                }
                */
                //System.out.println("Str: "+ str);
                /* 
                while(true){
                    str+= ois.readObject()
                         +ois.readUTF()
                         +ois.readUTF();
//                    str+= dis.readUTF()
//                         +dis.readUTF()
//                         +dis.readUTF();
                }
                
            }
            System.out.println("Str: "+str);
            
            String[] user = str2.split(",");
//            for(int i=0; i<= user.length; i++){
//                System.out.println(user[i]);
//            }
            System.out.println("usER len: "+ user.length);
            for(int i=0; i< user.length; i++){
                String a = user[i];
                String[] ar = a.split(",");
            System.out.println("User: "+ ar[i]);
                if(uN.equals(ar[i])  && uP.equals(ar[i+1]) && uG.equals(ar[i+2])){
            
                    FXMLLoader loader = new FXMLLoader();
                    loader.setLocation(getClass().getResource("CitizenHomeScene.fxml"));
                    //Parent personViewParent = loader.load();
                    Parent nextnewGUI = loader.load(); //FXMLLoader.load(getClass().getResource("CitizenHomeScene.fxml"));
            
                    Scene newScene = new Scene(nextnewGUI);
                    Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
                    window.setScene(newScene);
                    window.show();
                   // found = true;
            }
                */
           if(uN.equals("Nabil") && uP.equals("Eraj") && uG.equals("Admin")){
            Parent nextnewGUI = FXMLLoader.load(getClass().getResource("AdminHomeScene.fxml"));
            
            Scene newScene = new Scene(nextnewGUI);
            
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
            }
            
            sc.useDelimiter(" ");           
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
            
            if(uN.equals(tempUsername) && uP.equals(tempPassword) && userTypeComboBoxLogin.getValue().toString().equals("Police")){
            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("PoliceHomeScene.fxml"));
            //Parent personViewParent = loader.load();
            Parent nextnewGUI = loader.load(); //FXMLLoader.load(getClass().getResource("CitizenHomeScene.fxml"));
            
            Scene newScene = new Scene(nextnewGUI);
            Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
            window.setScene(newScene);
            window.show();
            found = true;
            }
            
            
    }   
            //sc.close();
            
        }catch(Exception e){
                System.out.println(e);
            } finally{
            try{
                if(dis != null) dis.close();
               // if(ois != null) ois.close();
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
