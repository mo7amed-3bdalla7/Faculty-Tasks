package controller;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class Controller  implements Initializable {

    @FXML
    private JFXButton LZW;

    @FXML
    private JFXButton Dither_Dissolve;

    @FXML
    private JFXButton TRS_2D_object;

    @FXML
    private JFXButton folyed;

    @FXML
    private JFXButton Run_Length;

    @FXML
    private JFXButton three_shold;

    @FXML
    private JFXButton Shannon_Fano;

    @FXML
    private JFXButton Arithmetic_Coding;

    @FXML
    private Pane root;

    @FXML
    private JFXButton alpha;

    @FXML
    private JFXButton Huffman;

    @FXML
    private JFXButton other_ditheling;

    @FXML
    private JFXButton cross_dissolve;

    @FXML
    private JFXButton Image_info;

    @FXML
    private JFXButton Exit;

    @FXML
    void Image_info(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/Bmp.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Image Info");
        stage.show();
    }

    @FXML
    void LZW_Action(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/lzw.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("LZW ");
        stage.show();
    }

    @FXML
    void threeSholdAction(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/threeshold.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Three Shold");
        stage.show();
    }

    @FXML
    void other_ditheling_action(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/orderdirth.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Order Dirth");
        stage.show();
    }

    @FXML
    void DitherDissolve(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/dithering.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Dithering ");
        stage.show();
    }

    @FXML
    void RunLength(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/RLE.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("LZW ");
        stage.show();
    }

    @FXML
    void Huffman_Action(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/huffman.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Huffman");
        stage.show();
    }

    @FXML
    void ArithmeticCoding(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/arithmtic.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Arthimatic Coding ");
        stage.show();
    }

    @FXML
    void ShannonFano(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/shanonn.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Shanonn ");
        stage.show();
    }

    @FXML
    void TRS2D_objectAction(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/twodimetion.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Two Dimention ");
        stage.show();
    }

    @FXML
    void CrossAction(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/cross.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Cross Action");
        stage.show();
    }

    @FXML
    void floyedAction(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/floyed.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle(" Floyed ");
        stage.show();
    }

    @FXML
    void Exit_Action(ActionEvent event) {
      System.exit(0);
       // ((Node)(event.getSource())).getScene().getWindow().hide();
    }

    @FXML
    void AlphaAction(ActionEvent event) throws IOException {
        Parent p = FXMLLoader.load(getClass().getClassLoader().getResource("view/AlphaChannel.fxml"));
        // root.getChildren().setAll(p);
        Scene scene = new Scene(p);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("AlphaChannel");
        stage.show();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}