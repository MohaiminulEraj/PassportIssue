/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nabil16
 */
public class CitizenNewPassController implements Initializable {

    @FXML
    private TextField userNameTextField;
    @FXML
    private TextArea userDetailsTextArea;
    @FXML
    private Button loadInfoButton;
    @FXML
    private Label confirmationLabel;
    @FXML
    private Button applyPassButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void loadInfoButtonOnClick(ActionEvent event) {
        File f = null;
        Scanner sc;
        String temp = "";
        String[] line = null;
        String[] space = null;
        try{
            f = new File("CitizenSignUpForm.txt");
            sc = new Scanner(f);
            while(sc.hasNext()){
                temp = sc.nextLine();
                line = temp.split(" \n");
                space = temp.split(" ");
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }

    /*
    @FXML
    private void loadInfoButtonOnClick(ActionEvent event) {
        FileReader fr = null;
        BufferedReader br = new BufferedReader(fr);
        try{
            fr = new FileReader("CitizenSignUpForm.txt");
            //if(!) System.out.println("File Not Found");
            
            Scanner sc=new Scanner (fr);
            
            ArrayList<String> aList=  new ArrayList<String>();
            String line = br.readLine();
            String []words =line.split(" ");
            aList.add(words[0]);
            
            sc.useDelimiter(" ");
            while (sc.hasNextLine()){
                String data = sc.nextLine();
                userDetailsTextArea.setText(data);
            }
            sc.close();
            
            }catch(Exception e){
                System.out.println(e);
            } finally{
            try{
                //sc.close();
            } catch(Exception e){
                System.out.println(e);
            }
        }
    }
    */
    @FXML
    private void applyPassButtonOnClick(ActionEvent event) {
        if(userNameTextField.getText().equals(""))
            confirmationLabel.setText("Please Write down your username.");
        else 
            confirmationLabel.setText("Applied successfully.\nYou'll be notified soon.");
            
    }
    
}
