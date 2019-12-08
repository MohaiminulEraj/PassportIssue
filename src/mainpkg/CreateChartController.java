/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Nabil16
 */
public class CreateChartController implements Initializable {

    @FXML
    private ComboBox<?> GenderComboBox;
    @FXML
    private ComboBox<?> ReligionComboBox;
    @FXML
    private ComboBox<?> DistrictComboBox;
    @FXML
    private Button LoadChartButton;
    @FXML
    private PieChart pieChart;

    /**
     * Initializes the controller class.
     */
        
    Map <String, Integer> words = new HashMap<String, Integer>();
    @Override
    public void initialize(URL url, ResourceBundle rb){
       
    }    

    static void countWords(String fileName, Map <String, Integer> words) throws FileNotFoundException{
        Scanner file = new Scanner(new File(fileName));
        while(file.hasNext()){
            String word = file.next();
            Integer count = words.get(word);
            if(count != null)    count++;
            else    count = 1;
            words.put(word, count);
        }
    }
    
    @FXML
    private void LoadChartButtonOnClick(ActionEvent event) throws FileNotFoundException {
        countWords("gender.txt", words);
        System.out.println(words);
         ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Java",50),
            new PieChart.Data("C++",20),
            new PieChart.Data("Python",30),
            new PieChart.Data("C#",10),
            new PieChart.Data("C",15)
        );
        pieChart.setData(list);
        
    }
    
}
