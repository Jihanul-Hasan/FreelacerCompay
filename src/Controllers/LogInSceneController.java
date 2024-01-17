package Controllers;

import freelancingcompany.CEO;
import freelancingcompany.Customer;
import freelancingcompany.FinancialOfficer;
import freelancingcompany.IT;
import freelancingcompany.Intern;
import freelancingcompany.Manager;
import freelancingcompany.Trainer;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInSceneController implements Initializable {

    @FXML
    private ComboBox designationFx;

    @FXML
    private TextField emailfx;

    @FXML
    private TextField passwordfx;
    String designation;

    ObservableList<CEO> ceo = FXCollections.observableArrayList();
    ObservableList<FinancialOfficer> AllFinancialOfficer = FXCollections.observableArrayList();
    ObservableList<Manager> AllManagers = FXCollections.observableArrayList();
    ObservableList<IT> ITDepartment = FXCollections.observableArrayList();
    ObservableList<Trainer> AllTrainer = FXCollections.observableArrayList();
    ObservableList<Intern> AllIntern = FXCollections.observableArrayList();
    ObservableList<Customer> AllCustomers = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        designationFx.getItems().add("CEO");
        designationFx.getItems().add("Manager");
        designationFx.getItems().add("Financial Office Manager");
        designationFx.getItems().add("Intern");
        designationFx.getItems().add("Trainer");
        designationFx.getItems().add("Customer");

    }

    @FXML
    void designation(ActionEvent event) {
        designation = designationFx.getValue().toString();
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

    @FXML
    void loginOnClick(ActionEvent event) throws IOException {

        if (designation.equals("CEO")) {
            ceo = getCEO();
            for (CEO c : ceo) {
                if (c.getEmail().equals(emailfx.getText())) {
                    if (c.getPassword().equals(passwordfx.getText())) {
                        loadUI(event, "CeoDashBoard");
                    } else {
                        emailfx.clear();
                        passwordfx.clear();

                    }
                }

            }
        }

        if (designation.equals("Manager")) {
            AllManagers = getManagers();
            for (Manager m : AllManagers) {
                if (m.getEmail().equals(emailfx.getText())) {
                    if (m.getPassword().equals(passwordfx.getText())) {
                        loadUI(event, "ManagerDashBoard");
                    } else {
                        emailfx.clear();
                        passwordfx.clear();

                    }
                }

            }
        }

        if (designation.equals("Financial Office Manager")) {
            AllFinancialOfficer = getFinancialOfficer();
            for (FinancialOfficer fo : AllFinancialOfficer) {
                if (fo.getEmail().equals(emailfx.getText())) {
                    if (fo.getPassword().equals(passwordfx.getText())) {
                        loadUI(event, "FinancialOfficerDashBoard");
                    } else {
                        emailfx.clear();
                        passwordfx.clear();

                    }
                }

            }
        }
        if (designation.equals("Customer")) {
            AllCustomers = getCustomers();
            for (Customer c : AllCustomers) {
                if (c.getEmail().equals(emailfx.getText())) {
                    if (c.getPassword().equals(passwordfx.getText())) {
                        loadUI(event, "CustomerDashBoard");
                    } else {
                        emailfx.clear();
                        passwordfx.clear();

                    }
                }

            }
        }
    }

    public ObservableList<CEO> getCEO() {
        ObservableList<CEO> ceo = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            CEO c;
            ois = new ObjectInputStream(new FileInputStream("CEO.bin"));
            while (true) {
                c = (CEO) ois.readObject();

                ceo.add(c);
            }
        } catch (IOException ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogInSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ceo;
    }

    public ObservableList<Manager> getManagers() {
        ObservableList<Manager> managers = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            Manager m;
            ois = new ObjectInputStream(new FileInputStream("Managers.bin"));
            while (true) {
                m = (Manager) ois.readObject();
                m.show();
                managers.add(m);
            }
        } catch (IOException ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogInSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return managers;
    }

    public ObservableList<FinancialOfficer> getFinancialOfficer() {
        ObservableList<FinancialOfficer> financialOfficers = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            FinancialOfficer FO;
            ois = new ObjectInputStream(new FileInputStream("FinancialOfficers.bin"));
            while (true) {
                FO = (FinancialOfficer) ois.readObject();

                financialOfficers.add(FO);
            }
        } catch (IOException ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogInSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return financialOfficers;
    }

    public ObservableList<Customer> getCustomers() {
        ObservableList<Customer> customers = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        try {
            Customer c;
            ois = new ObjectInputStream(new FileInputStream("Customers.bin"));
            while (true) {
                c = (Customer) ois.readObject();

                customers.add(c);
            }
        } catch (IOException ex) {
            try {
                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {

            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LogInSceneController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return customers;
    }

    @FXML
    void SignUpUIonClick(ActionEvent event) throws IOException {
        loadUI(event, "Signup");
    }
}
