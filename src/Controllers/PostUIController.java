
package Controllers;

import freelancingcompany.Post;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

public class PostUIController  implements Initializable {

    @FXML
    private Label deliveryfx;

    @FXML
    private Label emailfx;

    @FXML
    private Label namefx;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    }
    
    
    
    void setData(Post p){
        
        namefx.setText(p.getName());
        emailfx.setText(p.getEmail());
        deliveryfx.setText(p.getDelivery());
        
    }
    
}
