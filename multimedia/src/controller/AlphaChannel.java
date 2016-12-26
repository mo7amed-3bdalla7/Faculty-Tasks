package controller;


import com.jfoenix.controls.JFXButton;
import compression.CompositImage;
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
public class AlphaChannel implements Initializable {
    private File file1;
    private File file2;

    @FXML
    private ImageView image_view3;

    @FXML
    private ImageView image_view2;

    @FXML
    private ImageView image_view1;

    @FXML
    private JFXButton choose_image2;

    @FXML
    private JFXButton choose_image1;

    @FXML
    private JFXButton back;

    @FXML
    private JFXButton done;

    @FXML
    void chooseimage1(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.png)", "*.PNG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        //Show open file dialog
        file1 = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file1);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            image_view1.setImage(image);
        } catch (IOException ex) {
        }
    }



    @FXML
    void chooseimage2(ActionEvent event) {
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        fileChooser.getExtensionFilters().addAll(extFilterJPG);

        //Show open file dialog
        file2 = fileChooser.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(file2);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            image_view2.setImage(image);
        } catch (IOException ex) {
        }
    }



    @FXML
    void doneAction(ActionEvent event) {
        CompositImage compositImage=new CompositImage();
        try {
//            System.out.println("mmmm"+file3.toString());
            compositImage.diplay(file1.toString(),file2.toString());
            File mFile=new File("src/combined.png");
            BufferedImage bufferedImage = ImageIO.read(mFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            //  JOptionPane.showConfirmDialog(null,mFloyed.readBMP(file.toString()));
            image_view3.setImage(image);
        } catch (IOException ex) {
        }
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
