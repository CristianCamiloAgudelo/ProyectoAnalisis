/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Modelo.*;
import java.awt.Image;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import java.util.LinkedList;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.SplitPane;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.*;
import javafx.scene.shape.Rectangle;
import javax.swing.JButton;
import java.awt.*;
import java.awt.event.ActionListener;
import javafx.event.EventHandler;
import javafx.event.EventType;

/**
 * FXML Controller class
 *
 * @author usuario
 */
public class UniversoController implements Initializable {

    private FileLoader fileLoader;
    private Universo universo;
    @FXML
    private AnchorPane Anchorpane;
    @FXML
    private SplitPane Splitpane;
    @FXML
    private AnchorPane Scroll;
    private ScrollPane Scrollpane;
    @FXML
    private AnchorPane Vista;
    @FXML
    private ImageView Imagen;

    @FXML
    private Label Texto;
    @FXML
    private Button Btn1;
    @FXML
    private GridPane tipo1;
    @FXML
    private ImageView tipo2;
    @FXML
    private ImageView tipo3;

    private boolean bandera = false;
    private String rutaImagen = "";

    /* UniversoController(Universo universo) {
        this.universo = universo;
        this.Texto.setText(this.universo.getNombre()); 
        
    }*/
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    public void setData(Universo universo) {
        this.universo = universo;
        this.Texto.setText(universo.getNombre());
    }

//    public UniversoController(Universo universo) {
//
//        this.universo = universo;
//    }
    /**
     * @return the universo
     */
    public Universo getUniverso() {
        return universo;
    }

    /**
     * @param universo the universo to set
     */
    public void setUniverso(Universo universo) {
        this.universo = universo;
    }

    public void actionPerformed() {
    }

    @FXML
    private void CambiarTexto(ActionEvent event) {
        this.Texto.setText("una por la de negrito");
        this.Texto.setVisible(true);
    }

    @FXML
    private void Agregar(MouseEvent event) {
        if (this.bandera) {
            this.bandera = false;
            System.out.println("creo");
            GridPane grid = new GridPane();
            grid.setLayoutX(event.getX());
            grid.setLayoutY(event.getY());
            grid.setPadding(new Insets(10, 10, 10, 10));
            grid.setVgap(8);
            grid.setHgap(10);

            //input
            TextField input = new TextField("");
            input.setPromptText("Nombre Nebulosa");
            grid.setConstraints(input, 0, 0);

            //imagen
            ImageView imagen = new ImageView(this.rutaImagen);
            grid.setConstraints(imagen, 0, 1);

            // boton
            Button boton = new Button("Aceptar");
            EventHandler<ActionEvent> evento = new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    System.out.println("hola");
                    Label label = new Label();
                    label.setTextFill(javafx.scene.paint.Paint.valueOf("#ffffff"));
                    label.setText(input.getText());
                    grid.setVgap(0);
                    grid.setHgap(0);

                    grid.setConstraints(label, 0, 0);
                    boton.setVisible(false);
                    input.setVisible(false);

                    grid.getChildren().addAll(label);
                    //Vista.getChildren().add(grid);
                }
            };
            boton.setOnAction(evento);
            grid.setConstraints(boton, 0, 2);

            grid.getChildren().addAll(input, imagen, boton);

            Vista.getChildren().add(grid);

        }
    }

    @FXML
    private void crearTipo1(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        System.out.println("tipo1");
    }

    @FXML
    private void crearTipo2(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        System.out.println("tipo2");
    }

    @FXML
    private void crearTipo3(MouseEvent event) {
        this.bandera = true;
        this.rutaImagen = "Imagenes/nebulosa11.png";
        System.out.println("tipo3");
    }

}
