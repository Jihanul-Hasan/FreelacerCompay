package Controllers;

import freelancingcompany.Message;
import freelancingcompany.Post;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class CeoMsgUIController implements Initializable {

    @FXML
    private TableView<Message> tableView;
    @FXML
    private TableColumn<Message, LocalDate> DateColumnFx;

    @FXML
    private TableColumn<Message, String> messageColumnFx;

    @FXML
    private TableColumn<Message, String> nameCollumnFx;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        nameCollumnFx.setCellValueFactory(new PropertyValueFactory<Message, String>("Sender"));
        messageColumnFx.setCellValueFactory(new PropertyValueFactory<Message, String>("Message"));
        DateColumnFx.setCellValueFactory(new PropertyValueFactory<Message, LocalDate>("Date"));
        tableView.setItems(getMessages());
    }

    public ObservableList<Message> getMessages() {
        ObservableList<Message> messages = FXCollections.observableArrayList();

        ObjectInputStream ois = null;
        try {
            Message message;
            ois = new ObjectInputStream(new FileInputStream("Messsages.bin"));
            while (true) {
                message = (Message) ois.readObject();
                messages.add(message);
            }

        } catch (IOException | ClassNotFoundException ex) {
            try {

                if (ois != null) {
                    ois.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ex.printStackTrace();
        }

        return messages;
    }

}
