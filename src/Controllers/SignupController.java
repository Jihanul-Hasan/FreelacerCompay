package Controllers;

import freelancingcompany.AppendableObjectOutputStream;
import freelancingcompany.Customer;
import freelancingcompany.FinancialOfficer;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class SignupController implements Initializable {

    @FXML
    private TextField namefx;
    @FXML
    private ComboBox comboboxfx;

    @FXML
    private DatePicker dobfx;

    @FXML
    private TextField emailfx;

    @FXML
    private TextField passwordfx;

    String combobox = "";

    @FXML
    void combobox(ActionEvent event) {
        combobox = comboboxfx.getValue().toString();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        comboboxfx.getItems().add("Customer");
        comboboxfx.getItems().add("Intern");
        comboboxfx.getItems().add("Trainer");

    }

    public void SignUpOnClick(ActionEvent event) throws IOException {
        makeCustomer(event);

    }

    private void loadUI(ActionEvent event, String str) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/FXML/" + str + ".fxml"));
        Parent root = loader.load();
        Scene scene = new Scene(root);

        Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
        window.setScene(scene);
        window.show();
    }

    public void makeCustomer(ActionEvent e) throws IOException {

        if (combobox.equals("Customer")) {
            File f = null;
            Customer customer = new Customer(namefx.getText(), emailfx.getText(),
                    dobfx.getValue(), passwordfx.getText());
            f = new File("Customers.bin");
            ObjectOutputStream oos = null;
            try {
                if (f.exists()) {
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(customer);
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
        loadUI(e, "LogInScene");
    }

    @FXML
    void logInUIonClick(ActionEvent event) throws IOException {
        loadUI(event, "LogInScene");
    }

}
