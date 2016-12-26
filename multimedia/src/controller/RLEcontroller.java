package controller;


import com.jfoenix.controls.JFXButton;
import compression.RLE;
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
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by moham on 26/12/2016.
 */
public class RLEcontroller implements Initializable {
    private File mFile;
    @FXML
    private JFXButton choose_image;


    @FXML
    private ImageView image_view;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton rle;





    @FXML
    void choose(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.bmp)", "*.BMP");
        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        //Show open file dialog
        mFile = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(mFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            image_view.setImage(image);
        } catch (IOException ex) {
        }
    }



    @FXML
    void RLE(ActionEvent event) throws IOException {
   new RLE(String.valueOf(mFile));
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
