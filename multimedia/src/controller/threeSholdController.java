package controller;

import com.jfoenix.controls.JFXButton;
import company.Threshold;
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
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

/**
 * Created by moham on 25/12/2016.
 */
public class threeSholdController implements Initializable{

    @FXML
    private Pane root;
    private File iconimage;
    @FXML
    private JFXButton choose_image;

    @FXML
    private JFXButton do_floyed;

    @FXML
    private ImageView image_view2;

    @FXML
    private JFXButton back;

    @FXML
    private ImageView iamge_view1;
    private File file;

    @FXML
    void choose_image(ActionEvent event) throws IOException {
        image_view2.setImage(null);
        FileChooser fileChooser = new FileChooser();

        //Set extension filter
        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.bmp)", "*.BMP");
        fileChooser.getExtensionFilters().addAll(extFilterJPG);

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
    void do_floyed_action(ActionEvent event) {
        Threshold mThreshold=new Threshold();
        try {
            System.out.println("mmmm"+file.toString());
            File mFile=new File(mThreshold.readBMP(file.toString()));
            BufferedImage bufferedImage = ImageIO.read(mFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            //  JOptionPane.showConfirmDialog(null,mFloyed.readBMP(file.toString()));
            image_view2.setImage(image);
        } catch (IOException ex) {
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
