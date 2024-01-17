package Controllers;

import freelancingcompany.AppendableObjectOutputStream;
import freelancingcompany.Post;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
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
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerUIController implements Initializable {

    @FXML
    private ComboBox comboboxfx;

    @FXML
    private TextField emailfx;

    @FXML
    private TextField namefx;

    @FXML
    private TextArea textFieldFx;
    protected String combobox;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 1; i < 6; i++) {
            comboboxfx.getItems().add(Integer.toString(i));
        }
    }

    @FXML
    void combobox(ActionEvent event) {
        combobox = comboboxfx
                .getValue().toString();

    }

    private void gotoStage(ActionEvent event, String ui) throws IOException {
        Parent fileChooserViewParent = FXMLLoader.load(getClass().getResource("/FXML/" + ui + ".fxml"));
        Scene fileChooserViewScene = new Scene(fileChooserViewParent);
        //Stage window = (Stage)((Node)event.getSource()).getScene().getWindow();
        Stage newWindow = new Stage();
        newWindow.setTitle("Payment Process");
        newWindow.setScene(fileChooserViewScene);
        newWindow.show();

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
    void ConfirmOnAction(ActionEvent event) throws IOException {

        File f = null;
        Post post = new Post(namefx.getText(), emailfx.getText(), combobox, textFieldFx.getText());
        f = new File("Posts.bin");
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
            oos.writeObject(post);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
        namefx.clear();
        emailfx.clear();
        textFieldFx.clear();
        comboboxfx.getSelectionModel().clearSelection();
    }

    @FXML
    void ProceedToPayOnClick(ActionEvent event) {

    }

    @FXML
    void LogOutOnClick(ActionEvent event) throws IOException {
        gotoscene(event, "LogInScene");
    }

}
