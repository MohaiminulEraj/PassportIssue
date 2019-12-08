/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Nabil Akhunjee
 */
public class CreateBarChartController implements Initializable {

    @FXML
    private RadioButton genderRB;
    @FXML
    private ToggleGroup chart;
    @FXML
    private RadioButton religionRB;
    @FXML
    private RadioButton divisionRB;
    @FXML
    private Button LoadChartButton;
    @FXML
    private BarChart<String, Number> barChart;
    @FXML
    private Label statLabel;
    @FXML
    private NumberAxis yAxis;
    @FXML
    private CategoryAxis xAxis;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void LoadChartButtonOnClick(ActionEvent event) {
        if(genderRB.isSelected()){
            XYChart.Series<String,Number> series = new XYChart.Series<String,Number>();
            series.getData().add(new XYChart.Data<String,Number>("Male",90));
            series.getData().add(new XYChart.Data<String,Number>("Female",50));
            series.setName("Gender");
            barChart.getData().clear();
            barChart.getData().addAll(series);
        }
        else if(religionRB.isSelected()){
            
            //barChart.getData().addAll( series1 );
            XYChart.Series<String,Number> series1 = new XYChart.Series<String,Number>();
            series1.getData().add(new XYChart.Data<String,Number>("Islam",70));
            series1.getData().add(new XYChart.Data<String,Number>("Hinduism",59));
            series1.getData().add(new XYChart.Data<String,Number>("Buddhism",33));
            series1.getData().add(new XYChart.Data<String,Number>("Christianity",9));
            series1.setName("Religion");
            barChart.getData().clear();
            barChart.getData().addAll(series1);
        }
        else if(divisionRB.isSelected()){
            XYChart.Series<String,Number> series2 = new XYChart.Series<String,Number>();
            series2.getData().add(new XYChart.Data<String,Number>("Barisal",25));
            series2.getData().add(new XYChart.Data<String,Number>("Chittagong",60));
            series2.getData().add(new XYChart.Data<String,Number>("Dhaka",75));
            series2.getData().add(new XYChart.Data<String,Number>("Khulna",55));
            series2.getData().add(new XYChart.Data<String,Number>("Mymensingh",20));
            series2.getData().add(new XYChart.Data<String,Number>("Rajshahi",40));
            series2.getData().add(new XYChart.Data<String,Number>("Rangpur",19));
            series2.getData().add(new XYChart.Data<String,Number>("Sylhet",22));
            series2.setName("Division");
            barChart.getData().clear();
            barChart.getData().addAll(series2);
        }
        
        
    }
    
    private void showDataOnMouseClick(){
        for(XYChart.Series<String, Number> data: barChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    statLabel.setText(String.valueOf(data.getChart())); 
                }
            }
            );
        }
    }
}
 
    
