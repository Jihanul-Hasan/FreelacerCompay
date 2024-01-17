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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class CeoDashBoardController implements Initializable {

    @FXML
    private MenuBar menufx;
    @FXML
    private BorderPane BorderPaneFx;
    @FXML
    private MenuBar menufx1;

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/" + ui + ".fxml"));
            BorderPaneFx.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(ItDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void gotoscene(ActionEvent event, String str) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/FXML/" + str + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        } catch (ClassCastException ex) {
            Logger.getLogger(CeoUIController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void ReportUIonClick(ActionEvent event) {
        loadUI("CeoUI1");
    }

    @FXML
    void MessageUiOnClick(ActionEvent event) {
        loadUI("CeoUI2");
    }

    @FXML
    void AllEmployeeOnClick(ActionEvent event) {
        loadUI("CeoUI3");
    }

    @FXML
    void PostUIonClick(ActionEvent event) {
        loadUI("Posts");
    }

    @FXML
    void CoursesOnClick(ActionEvent event) {
        loadUI("CeoUI5");
    }

    @FXML
    void LogOutOnClick(ActionEvent event) throws IOException {
        gotoscene(event, "LogInScene");
    }
}
