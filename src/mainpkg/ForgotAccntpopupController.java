package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class ForgotAccntpopupController implements Initializable {

    @FXML
    private Button okayCloseStageButton;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void okayCloseStageButtonOnClick(ActionEvent event) {
        //Platform.exit();
        Stage stage  = (Stage) okayCloseStageButton.getScene().getWindow();
        stage.close();
    }
    
}
