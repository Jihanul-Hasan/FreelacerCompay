package Controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class ManagerDashBoardController implements Initializable {

    @FXML
    private Label NameLabelFx;
    @FXML
    private BorderPane BorderPaneFx;

    @FXML
    void ReportUIonClick(ActionEvent event) {
    }

    private void loadUI(String ui) {
        Parent root;
        try {
            root = FXMLLoader.load(getClass().getResource("/FXML/" + ui + ".fxml"));
            BorderPaneFx.setCenter(root);
        } catch (IOException ex) {
            Logger.getLogger(ManagerDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
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

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void LoadUI1OnClick(ActionEvent event) {
        loadUI("ManagerUI1");
    }

    @FXML
    void SendMessageUIonClick(ActionEvent event) {
        loadUI("MessageUI");
    }

    @FXML
    void ShowMessageUiOnClick(ActionEvent event) {
        loadUI("ManagerMsgUI2");
    }

    @FXML
    void LogOutOnClick(ActionEvent event) throws IOException {
        gotoscene(event,"LogInScene");
    }
}
