package Controllers;

import freelancingcompany.Message;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;

public class ManagerMsgUI2Controller implements Initializable {

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

    }

}
