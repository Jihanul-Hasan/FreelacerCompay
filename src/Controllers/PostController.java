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
import javafx.scene.layout.GridPane;

public class PostController implements Initializable {

    @FXML
    private GridPane gridefx;
    int col = 0;
    int row = 0;
    ObservableList<Post> allPosts = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        ObjectInputStream ois = null;

        try {
            Post post;
            ois = new ObjectInputStream(new FileInputStream("Posts.bin"));
            while (true) {
                post = (Post) ois.readObject();
                allPosts.add(post);
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

        gridefx.getChildren().clear();
        gridefx.setMinWidth(1000);

        for (Post post : allPosts) {

            try {
                gridefx.add(loadUIwithdatapass(post, "PostUI"), col++, row);
            } catch (IOException ex) {
                Logger.getLogger(PostController.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (col == 3) {
                col = 0;
                row++;
            }

        }
    }

    private Parent loadUIwithdatapass(Post post, String ui) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/FXML/" + ui + ".fxml"));
        Parent p = loader.load();
        PostUIController postcontroller = loader.<PostUIController>getController();
        postcontroller.setData(post);
        return p;
    }
}
