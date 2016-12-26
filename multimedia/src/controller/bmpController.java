package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import company.BMP;

import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;




/**
 * Created by moham on 25/12/2016.
 */
public class bmpController implements Initializable {

    private BMP mBmp;
    private File mFile;
    @FXML
    private JFXButton choose_image;

    @FXML
    private JFXButton back;



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

    @FXML
    void choose(ActionEvent event) throws IOException {
        Parent p= FXMLLoader.load(getClass().getClassLoader().getResource("view/bmp.fxml"));
        // root.getChildren().setAll(p);
        Scene scene=new Scene(p);
        Stage stage=(Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);


        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Resource File");
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter("BMP", "*.bmp");
        fileChooser.getExtensionFilters().add(extFilter);
        mFile = fileChooser.showOpenDialog(stage);

        mBmp=new BMP();
//        detail=new Text();
//        detail.setText("File Size is :"+String.valueOf(mBmp.bitSetToInt(String.valueOf(mFile))));
//        System.out.println(String.valueOf(mBmp.bitSetToInt(String.valueOf(mFile))));
        JOptionPane.showConfirmDialog(null,"File Size is :"+String.valueOf(mBmp.bitSetToInt(String.valueOf(mFile))));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }


}
