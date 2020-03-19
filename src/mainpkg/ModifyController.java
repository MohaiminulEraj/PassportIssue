/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author ERAJ
 */
public class ModifyController implements Initializable {

    @FXML
    private ComboBox GenderComboBox;
    @FXML
    private ComboBox ReligionComboBox;
    @FXML
    private ComboBox DivisionComboBox;
    @FXML
    private Button searchButton;
    @FXML
    private TextArea genderTextArea;
    @FXML
    private TextArea ReligionTextArea;
    @FXML
    private TextArea DivisionTextArea;
    @FXML
    private BarChart<String,Number> barChart;
    @FXML
    private Button barChartButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        GenderComboBox.getItems().addAll("Male","Female");
        ReligionComboBox.getItems().addAll("Islam","Hinduism","Buddhism","Christianity");
        DivisionComboBox.getItems().addAll("Barisal","Chittagong","Dhaka","Khulna","Mymensingh","Rajshahi","Rangpur","Sylhet");
    }    

    @FXML
    private void searchButtonOnClick(ActionEvent event) {
        String g = String.valueOf(GenderComboBox.getValue().toString());
        String r = String.valueOf(ReligionComboBox.getValue().toString());
        String d = String.valueOf(DivisionComboBox.getValue().toString());
        
        File f = null;
        Scanner sc;
        try{
            f = new File("CitizenSignUpForm.txt");
            sc = new Scanner(f);
            String temp="";
            String[] arr=null;
            int c=0;
            while(sc.hasNext()){
                temp=sc.nextLine();
                arr=temp.split(" ");
            }
            System.out.println("temp: "+ temp);
            sc.close();
            for(int i=0; i<= (arr.length-24); i=i+24){
                if(arr[i+2].equals(g) && arr[i+6].equals(r) && arr[i+10].equals(d)){
                    genderTextArea.setText(g+"\n");
                    ReligionTextArea.setText(r+"\n");
                    DivisionTextArea.setText(d+"\n");      
                } 
/*
                else if(arr[i+2].equals(g) && !arr[i+6].equals(r) && !arr[i+10].equals(d)){
                    genderTextArea.setText("");
                    ReligionTextArea.setText("");
                    DivisionTextArea.setText("");  
                }
                else if(arr[i+2].equals(g) && arr[i+6].equals(r) && !arr[i+10].equals(d)){
                    genderTextArea.setText("");
                    ReligionTextArea.setText("");
                    DivisionTextArea.setText("");  
                }
                else if(!arr[i+2].equals(g) && !arr[i+6].equals(r) && !arr[i+10].equals(d)){
                    genderTextArea.setText("");
                    ReligionTextArea.setText("");
                    DivisionTextArea.setText("");  
                }
                else if(!arr[i+2].equals(g) && arr[i+6].equals(r) && !arr[i+10].equals(d)){
                    genderTextArea.setText("");
                    ReligionTextArea.setText("");
                    DivisionTextArea.setText("");  
                }
                else if(!arr[i+2].equals(g) && !arr[i+6].equals(r) && arr[i+10].equals(d)){
                    genderTextArea.setText("");
                    ReligionTextArea.setText("");
                    DivisionTextArea.setText("");  
                }
                else if(arr[i+2].equals(g) && arr[i+6].equals(r) && !arr[i+10].equals(d)){
                    genderTextArea.setText("");
                    ReligionTextArea.setText("");
                    DivisionTextArea.setText("");  
                }

*/
            }
            
        }catch(Exception e){
            
            System.out.println(e);
        } 
    }

    @FXML
    private void barChartButtonOnClick(ActionEvent event) {
        
        File f = null;
        Scanner sc;
        String z="";
        try{
            f = new File("CitizenSignUpForm.txt");
            sc = new Scanner(f);
            String temp="";
            String[] arr=null;
            int c=0;
            while(sc.hasNext()){
                temp=sc.nextLine();
                arr=temp.split(" ");
            }
            System.out.println("temp: "+ temp);
            sc.close();
            for(int i=0; i<= (arr.length-24); i=i+24){
                for(int j=i; j<=(arr.length-24); j=j+24){
                if(arr[i+12].equals(arr[j+12])){
                    c++;  
                }
                else {
                    c=1;
                z = arr[j+12];
                CreateChart(z, c);
                }            
                }
                if(c>1){
                    CreateChart(z, c);
                }
//                else {
//                    genderTextArea.setText("");
//                    ReligionTextArea.setText("");
//                    DivisionTextArea.setText("");
//                }
            }
                    genderTextArea.setText("");
                    ReligionTextArea.setText("");
                    DivisionTextArea.setText("");
                
        }catch(Exception e){
            
            System.out.println(e);
        }
    }
    public void CreateChart(String z,int c){
        
        XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
                series1.getData().addAll(new XYChart.Data<String,Number>(z,c));
                series1.setName("Zip Wise Citizen");
                barChart.getData().clear();
                barChart.getData().addAll(series1);
                //c=0;
    }

    
}
