/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;

/**
 * FXML Controller class
 *
 * @author Nabil Akhunjee
 */
public class CreateLineChartController implements Initializable {

    @FXML
    private Button LoadChartButton;
    @FXML
    private LineChart<String, Number> lineChart;
    @FXML
    private RadioButton genderRB;
    @FXML
    private ToggleGroup chart;
    @FXML
    private RadioButton religionRB;
    @FXML
    private RadioButton divisionRB;
    @FXML
    private RadioButton addallRB;
    @FXML
    private ToggleGroup chart1;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
    XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
    XYChart.Series<String,Number> series3 = new XYChart.Series<String,Number>();
        
    @FXML
    private void LoadChartButtonOnClick(ActionEvent event) {
        
        if(genderRB.isSelected()){
            lineChart.getData().clear();
            loadGenderChart();
            lineChart.getData().add(series);
        }
        if(religionRB.isSelected()){
            lineChart.getData().clear();
            loadReligionChart();
            lineChart.getData().add(series2);
        }
        if(divisionRB.isSelected()){
            lineChart.getData().clear();
            loadDivisionChart();
            lineChart.getData().add(series3);
        }
        if(addallRB.isSelected()){
            lineChart.getData().clear();
            loadGenderChart();
            loadReligionChart();
            loadDivisionChart();
            lineChart.getData().addAll(series,series2,series3);
        }
       
        
    }
    
    private void loadGenderChart(){
        series.getData().add(new XYChart.Data<String,Number>("Male",200));
        series.getData().add(new XYChart.Data<String,Number>("Female",500));
        series.setName("Gender");
    }
    private void loadReligionChart(){
        series2.getData().add(new XYChart.Data<String,Number>("Islam",70));
        series2.getData().add(new XYChart.Data<String,Number>("Hinduism",59));
        series2.getData().add(new XYChart.Data<String,Number>("Buddhism",33));
        series2.getData().add(new XYChart.Data<String,Number>("Christianity",9));
        series2.setName("Religion");
    }
    private void loadDivisionChart(){
        series3.getData().add(new XYChart.Data<String,Number>("Barisal",25));
        series3.getData().add(new XYChart.Data<String,Number>("Chittagong",60));
        series3.getData().add(new XYChart.Data<String,Number>("Dhaka",75));
        series3.getData().add(new XYChart.Data<String,Number>("Khulna",55));
        series3.getData().add(new XYChart.Data<String,Number>("Mymensingh",20));
        series3.getData().add(new XYChart.Data<String,Number>("Rajshahi",40));
        series3.getData().add(new XYChart.Data<String,Number>("Rangpur",19));
        series3.getData().add(new XYChart.Data<String,Number>("Sylhet",22));
        series3.setName("Division");
    }
    
}
