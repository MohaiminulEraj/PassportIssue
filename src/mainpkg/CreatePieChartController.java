package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.MouseEvent;

public class CreatePieChartController implements Initializable {

    @FXML
    private Button LoadChartButton;
    @FXML
    private PieChart pieChart;
    @FXML
    private ToggleGroup chart;
    @FXML
    private RadioButton genderRB;
    @FXML
    private RadioButton religionRB;
    @FXML
    private RadioButton divisionRB;
    @FXML
    private Label statLabel;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
       
    }    

    @FXML
    private void LoadChartButtonOnClick(ActionEvent event) {
        
        if(genderRB.isSelected()){
            ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Male",50),
            new PieChart.Data("Female",20)
            );
            pieChart.setData(list);
            
            showDataOnMouseClick();
        }
        if(religionRB.isSelected()){
            ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Islam",70),
            new PieChart.Data("Hinduism",59),
            new PieChart.Data("Buddhism",33),
            new PieChart.Data("Christianity",9)
            );
            pieChart.setData(list);
            
            showDataOnMouseClick();
        }
        if(divisionRB.isSelected()){
            ObservableList <PieChart.Data> list = FXCollections.observableArrayList(
            new PieChart.Data("Barisal",25),
            new PieChart.Data("Chittagong",60),
            new PieChart.Data("Dhaka",75),
            new PieChart.Data("Khulna",55),
            new PieChart.Data("Mymensingh",20),
            new PieChart.Data("Rajshahi",40),
            new PieChart.Data("Rangpur",19),
            new PieChart.Data("Sylhet",22)
            );
            pieChart.setData(list);
            
            showDataOnMouseClick();
        }  
    }
    
    private void showDataOnMouseClick(){
        for(PieChart.Data data: pieChart.getData()){
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>(){
                @Override
                public void handle(MouseEvent event) {
                    statLabel.setText(String.valueOf(data.getPieValue())); 
                }
            }
            );
        }
    }  
}
