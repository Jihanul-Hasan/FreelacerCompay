
package Controllers;

import freelancingcompany.Post;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

public class FinancialOfficerUIController implements Initializable {

    private Label namefx;

    
    int col = 0;
    int row = 0;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
      
    }

    private void setPost() {
        namefx.setText("ddddd");

    }
 private Parent loadUIwithdatapass(Post f,String ui) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/" + ui + ".fxml"));
        Parent p = loader.load();

      //  FurnitureViewController fv = loader.<FurnitureViewController>getController();
      //  fv.setInFurnitureViewController(f);

        return p;
    }
private void jihan(){


}
}
