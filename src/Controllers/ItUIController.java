package Controllers;

import freelancingcompany.AppendableObjectOutputStream;
import freelancingcompany.CEO;
import freelancingcompany.Customer;
import freelancingcompany.CustomerCareExecutive;
import freelancingcompany.FinancialOfficer;
import freelancingcompany.Intern;
import freelancingcompany.Manager;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;

public class ItUIController implements Initializable {

    @FXML
    private TextField namefx;
    @FXML
    private TextField emailfx;
    @FXML
    private TextField passwordfx;
    @FXML
    private ComboBox ComboBoxFx;
    @FXML
    private DatePicker DobFx;
    @FXML
    private RadioButton femalefx;
    @FXML
    private RadioButton malefx;
    @FXML
    private RadioButton otherfx;
    @FXML
    private TextField idfx;

    public String ComboBox;
    public String gender;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ComboBoxFx.getItems().add("CEO");
        ComboBoxFx.getItems().add("Customer");
        ComboBoxFx.getItems().add("Customer Care Executive");
        ComboBoxFx.getItems().add("Manager");
        ComboBoxFx.getItems().add("Trainer");
        ComboBoxFx.getItems().add("Intern");
        ComboBoxFx.getItems().add("Financial Officer");
    }

    @FXML
    void designation(ActionEvent event) {
        ComboBox = ComboBoxFx.getValue().toString();
    }

    @FXML
    void AddUserOnClick(ActionEvent event) {

        if (malefx.isSelected()) {
            gender = "male";
        }
        if (femalefx.isSelected()) {
            gender = "feale";
        }
        if (otherfx.isSelected()) {
            gender = "other";
        }

        if (ComboBox.equals("CEO")) {
            File f = null;
            CEO ceo = new CEO(namefx.getText(), gender,idfx.getText(), emailfx.getText(),
                    DobFx.getValue(), passwordfx.getText());

            f = new File("CEO.bin");
            ObjectOutputStream oos = null;
            try {
                if (f.exists()) {
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(ceo);
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();

            }
        }

        //CUSTOMER//
        if (ComboBox.equals("Customer")) {
            File f = null;
            Customer customer = new Customer(namefx.getText(), emailfx.getText(),
                    DobFx.getValue(), passwordfx.getText());
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

        //CUSTOMER CARE EXECUTIVE
        if (ComboBox.equals("Customer Care Executive")) {

            File f = null;
            CustomerCareExecutive CCE = new CustomerCareExecutive(namefx.getText(),gender,idfx.getText(),
                    emailfx.getText(), DobFx.getValue(), passwordfx.getText());
            f = new File("CCEs.bin");
            ObjectOutputStream oos = null;
            try {
                if (f.exists()) {
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(CCE);
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //FACTORY MANAGER
        if (ComboBox.equals("Manager")) {
            File f = null;
            Manager manager = new Manager(namefx.getText(), gender,idfx.getText(), emailfx.getText(),
                    DobFx.getValue(), passwordfx.getText());
            f = new File("Managers.bin");
            ObjectOutputStream oos = null;
            try {
                if (f.exists()) {
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(manager);
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //TRAINER
        if (ComboBox.equals("Trainer")) {
            File f = null;
            Intern it = new Intern(namefx.getText(), emailfx.getText(), DobFx.getValue(), passwordfx.getText());
            f = new File("Trainers.bin");
            ObjectOutputStream oos = null;
            try {
                if (f.exists()) {
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(it);
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        //FINANCIAL OFFICER
        if (ComboBox.equals("Financial Officer")) {
            File f = null;
            FinancialOfficer suplier = new FinancialOfficer(namefx.getText(), gender,idfx.getText(), emailfx.getText(),
                    DobFx.getValue(), passwordfx.getText());

            f = new File("FinancialOfficers.bin");
            ObjectOutputStream oos = null;
            try {
                if (f.exists()) {
                    oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
                } else {
                    oos = new ObjectOutputStream(new FileOutputStream(f));
                }
                oos.writeObject(suplier);
                oos.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }

        emailfx.setText(null);
        passwordfx.setText(null);
    }
}
