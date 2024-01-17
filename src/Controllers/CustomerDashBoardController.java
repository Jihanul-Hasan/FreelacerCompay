package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class CustomerDashBoardController implements Initializable {

    @FXML
    private BorderPane BorderPanefx;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/" + ui + ".fxml"));
            BorderPanefx.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(CustomerDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void LoadUI1OnClick(ActionEvent event) {
   
    }

    @FXML
    void CustomerUI1onClick(ActionEvent event) {
     loadUI("CustomerUI1");
    }

    @FXML
    void CustomerUI2onClick(ActionEvent event) {
        

    }

    @FXML
    void CustomerUI3onClick(ActionEvent event) {

    }

    @FXML
    void CustomerUI4onClick(ActionEvent event) {

    }

    @FXML
    void LogOutOnClick(ActionEvent event) {

    }
}
