package controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import compression.Shannon;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by moham on 26/12/2016.
 */
public class shannonController implements Initializable {
    @FXML
    private JFXTextField edit_text;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton done;


    @FXML
    void Action(ActionEvent event) {

        String text=edit_text.getText().toString();
        if (!text.isEmpty()){
           new Shannon(text);
        }
    }


    @FXML
    void back(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getClassLoader().getResource("view/sample.fxml"));
        Scene scene=new Scene(p);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Multimedia");
        stage.show();
    }
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
