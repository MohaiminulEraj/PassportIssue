package mainpkg;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class PassportIssueApp extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("MainPage.fxml"));
        Parent root = FXMLLoader.load(getClass().getResource("Modify.fxml"));
        Scene scene = new Scene(root);
        
        stage.setTitle("Passport Issue Management System");
        stage.setScene(scene);
        stage.show();
     
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
