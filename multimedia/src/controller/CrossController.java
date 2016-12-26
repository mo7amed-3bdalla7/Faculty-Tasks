package controller;


import com.jfoenix.controls.JFXButton;
import crossDissolve.CrossDissolve;
import crossDissolve.Gui;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


/**
 * Created by moham on 25/12/2016.
 */
public class CrossController implements Initializable {
    private File file;
    private File mFile;

    @FXML
    private JFXButton do_floyed;

    @FXML
    private ImageView image_view2;

    @FXML
    private Pane root;

    @FXML
    private JFXButton choose_image2;

    @FXML
    private JFXButton choose_image1;

    @FXML
    private JFXButton back;

    @FXML
    private ImageView iamge_view1;

    @FXML
    void choose_image1(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.bmp)", "*.BMP");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);

        //Show open file dialog
        file = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            iamge_view1.setImage(image);
        } catch (IOException ex) {
        }
    }



    @FXML
    void do_floyed_action(ActionEvent event) throws IOException, InterruptedException {
       new Gui(String.valueOf(file));
        CrossDissolve mCrossDissolve=new CrossDissolve();
        Float alpha=Float.parseFloat(JOptionPane.showInputDialog(null,"enter Alpha :"));
        mCrossDissolve.readBMP(String.valueOf(file),String.valueOf(mFile),alpha);

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



    @FXML
    void choose_image2(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.bmp)", "*.BMP");
        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        //Show open file dialog
        mFile = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(mFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            image_view2.setImage(image);
        } catch (IOException ex) {
        }
    }


    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
