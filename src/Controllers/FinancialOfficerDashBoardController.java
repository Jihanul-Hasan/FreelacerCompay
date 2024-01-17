package Controllers;

import freelancingcompany.Post;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

public class FinancialOfficerDashBoardController implements Initializable {

    ObservableList<Post> allPosts = FXCollections.observableArrayList();
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
            Logger.getLogger(FinancialOfficerDashBoardController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    void viewAllPostsOnClick(ActionEvent event) {
        loadUI("Posts");

    }

    @FXML
    void SendMessageUIonClick(ActionEvent event) {
        loadUI("MessageUI");
    }

    @FXML
    void ShowMessageUiOnClick(ActionEvent event) {
        loadUI("ManagerMsgUI2");
    }
}
