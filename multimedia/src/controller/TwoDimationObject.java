package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import twoDimentionObject.RotationEx;
import twoDimentionObject.ScalingEx;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by moham on 25/12/2016.
 */
public class TwoDimationObject  implements Initializable{
    @FXML
    private JFXButton rotate;

    @FXML
    private JFXButton scale;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton translate;

    @FXML
    void cccccc(ActionEvent event) {

    }

    @FXML
    void rotate(ActionEvent event) {
    new RotationEx().setVisible(true);
    }


    @FXML
    void Scaling(ActionEvent event) {
          new ScalingEx().setVisible(true);
    }


    @FXML
    void translation(ActionEvent event) {

        RotationEx rotationEx=new RotationEx();
        rotationEx.setVisible(true);

     }

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getClassLoader().getResource("view/sample.fxml"));
        // root.getChildren().setAll(p);0
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
