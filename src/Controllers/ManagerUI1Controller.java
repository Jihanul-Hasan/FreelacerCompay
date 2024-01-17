package Controllers;

import freelancingcompany.AppendableObjectOutputStream;
import freelancingcompany.Revenue;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class ManagerUI1Controller implements Initializable {

    @FXML
    private Label statusLabel;
    @FXML
    private PieChart pieChart;
    @FXML
    private TextField week1;
    @FXML
    private TextField week2;
    @FXML
    private TextField week3;
    @FXML
    private TextField week4;
    @FXML
    private ComboBox Monthfx;
    @FXML
    private ComboBox yearfx;
    public String Month="";
    public String Year="";

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for (int i = 1; i <= 12; i++) {
            Monthfx.getItems().add(Integer.toString(i));
        }
         for (int i = 10; i <= 20; i++) {
            yearfx.getItems().add("200"+Integer.toString(i));
        }
    }
    @FXML
    private void loadPieChartButtonOnClick(ActionEvent event) {
        ObservableList<PieChart.Data> list = FXCollections.observableArrayList(
                new PieChart.Data("1ST WEEK", Double.parseDouble(week1.getText())),
                new PieChart.Data("2ND WEEK", Double.parseDouble(week2.getText())),
                new PieChart.Data("3RD WEEK", Double.parseDouble(week3.getText())),
                new PieChart.Data("4TH WEEK", Double.parseDouble(week4.getText()))
        );

        pieChart.setData(list);

        for (PieChart.Data data : pieChart.getData()) {
            data.getNode().addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    statusLabel.setText(String.valueOf(data.getPieValue()));
                }
            }
            );
        }}

    @FXML
    void Month(ActionEvent event) {
        Month = Monthfx.getValue().toString();
    }

    @FXML
    void year(ActionEvent event) {
        Year = yearfx.getValue().toString();
    }
    @FXML
    void sendToCeoOnClick(ActionEvent event) {

        Double a = Double.parseDouble(week1.getText());
        Double b = Double.parseDouble(week2.getText());
        Double c = Double.parseDouble(week3.getText());
        Double d = Double.parseDouble(week4.getText());

        File f = null;
        Revenue revenue = new Revenue(Month,Year, a, b, c, d);
        f = new File("Revenue.bin");
        ObjectOutputStream oos = null;
        try {
            if (f.exists()) {
                oos = new AppendableObjectOutputStream(new FileOutputStream(f, true));
            } else {
                oos = new ObjectOutputStream(new FileOutputStream(f));
            }
           oos.writeObject(revenue);
            oos.close();
        } catch (Exception ex) {
            ex.printStackTrace();

        }
    }
}
